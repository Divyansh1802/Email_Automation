package com.EmailAutomation.AI_gen_MAILService.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResponseRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String Subject;
    @NotBlank
    private String Body;
    @NotBlank
    private String To;

}
