package com.EmailAutomation.UserService.Controller;

import com.EmailAutomation.UserService.DTO.RegisterRequest;
import com.EmailAutomation.UserService.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EmailAutomate/Auth")
@Data
@RequiredArgsConstructor
public class UserController {
    private final UserService  userService;

    @PostMapping("/SignUp")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.SignUp_User(request));
    }

    @GetMapping("/VerifyUser/{email}")
    public ResponseEntity<String> verifyUser(@PathVariable("email") String email,
                                             @RequestParam("otp") String otp) {
        return ResponseEntity.ok(userService.VerifyOTP(email,otp));
    }

    @DeleteMapping("/remove/{email}")
    public ResponseEntity<String> removeUser(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.deleteUSER(email));
    }
}
