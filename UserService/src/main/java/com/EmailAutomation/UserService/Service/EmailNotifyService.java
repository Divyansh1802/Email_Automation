package com.EmailAutomation.UserService.Service;

import com.EmailAutomation.UserService.Configuration.WebClientConfig;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailNotifyService {
    private final WebClientConfig  webClientConfig;
    private final CacheService  cacheService;

    @Cacheable(cacheNames = "otp",key = "#email")
    public void sendOTP(@NotBlank @Email String email) {
        try {
            String newOTP=webClientConfig.EmailClient()
                    .get()
                    .uri("/MailSend/notify/{email}",email)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            cacheService.storeotp(email,newOTP);
            System.out.println(newOTP);
        } catch (Exception e) {
            return;
        }
    }
}
