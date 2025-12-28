package com.EmailAutomation.AI_gen_MAILService.Model;

import com.EmailAutomation.AI_gen_MAILService.Repository.AI_MailRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "Email_automation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AI_gen_Email {
    @Id
    private String id;
    @NotBlank
    @Email
    private String email;
    private Map<String,String> container = new HashMap<>();
    private String my_app_password;
}
