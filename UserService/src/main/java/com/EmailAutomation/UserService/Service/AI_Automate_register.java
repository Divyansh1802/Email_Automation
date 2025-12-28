package com.EmailAutomation.UserService.Service;

import com.EmailAutomation.UserService.Configuration.WebClientConfig;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class AI_Automate_register {
    private final WebClientConfig  webClientConfig;


    public void sendUserID(@NotBlank @Email String email) {
        try {
            webClientConfig.AI_genClient()
                    .get()
                    .uri("/AI_Mail/register/{email}", email)
                    .retrieve()
                    .bodyToMono(void.class)
                    .block();
        }catch (Exception e){
            return;
        }
    }
}
