package com.EmailAutomation.UserService.Service;

import com.EmailAutomation.UserService.Configuration.EncoderConfig;
import com.EmailAutomation.UserService.DTO.RegisterRequest;
import com.EmailAutomation.UserService.Model.STATUS;
import com.EmailAutomation.UserService.Model.User_Client;
import com.EmailAutomation.UserService.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EncoderConfig  encoderConfig;
    private final EmailNotifyService  emailNotifyService;
    private final CacheService cacheService;
    private final AI_Automate_register  ai_Automate_register;

    public  String SignUp_User(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            return "EMAIL ALREADY EXISTS ";
        }
        User_Client user_Client = new User_Client();
        user_Client.setEmail(request.getEmail());
        user_Client.setFirstName(request.getFirstName());
        user_Client.setLastName(request.getLastName());
        user_Client.setUserStatus(STATUS.UNVERIFIED);
        user_Client.setPhoneNumber(request.getPhoneNumber());
        user_Client.setPassword(encoderConfig.passwordEncoder()
                                        .encode(request.getPassword()));
        userRepository.save(user_Client);
        emailNotifyService.sendOTP(request.getEmail());
        ai_Automate_register.sendUserID(request.getEmail());

        return "OTP SENT";
    }

    public  String VerifyOTP(String email,String otp) {
        User_Client user_Client = userRepository.findByEmail(email);
        if(user_Client==null) {
            return "EMAIL NOT REGISTERED ";
        }
        if(user_Client.getUserStatus()==STATUS.VERIFIED) {
            return "EMAIL ALREADY VERIFIED ";
        }
        String OTP;
        try{
            OTP= cacheService.getOtp(email);
        }catch(Exception e){
            return "OTP EXPIRED OR NOT GENERATED";
        }
        if(!otp.equals(OTP)){
            return "OTP INVALID";
        }
        user_Client.setUserStatus(STATUS.VERIFIED);
        userRepository.save(user_Client);
        cacheService.clearOtp(email);

        return "USER VERIFIED";
    }

    public String deleteUSER(String email) {
        User_Client user_Client = userRepository.findByEmail(email);
        if(user_Client==null) {
            return "EMAIL NOT REGISTERED ";
        }
        userRepository.delete(user_Client);
        cacheService.clearOtp(email);
        return "USER DELETED";
    }

    //SCHEDULING SERVICE --> for users who have registered but not verified will be deleted after 23 hours
    public void UpdateUserSTATUS() {
        List<User_Client> user_Clients = userRepository.findAll();
        for(User_Client user : user_Clients) {
            if(user.getUserStatus()==STATUS.UNVERIFIED) {
                long hours= Duration.between(user.getCreatedAt(), LocalDateTime.now()).toHours();
                if(hours<23) {
                    userRepository.delete(user);
                }
            }
        }
    }



}
