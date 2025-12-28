package com.EmailAutomation.AI_gen_MAILService.Controller;

import com.EmailAutomation.AI_gen_MAILService.DTO.ResponseRequest;
import com.EmailAutomation.AI_gen_MAILService.Service.AI_MailService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AI_Mail")
@Data
@RequiredArgsConstructor
public class AI_mailController {
    private final AI_MailService ai_MailService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody ResponseRequest request){
        return ResponseEntity.ok(ai_MailService.CreatePrompt(request));
    }

    @GetMapping("/register/{email}")
    public void registerEmail(@PathVariable("email") String email){
        ai_MailService.registerClient(email);
    }

    @PostMapping("/generate/send")
    public ResponseEntity<String> generate_sendEmail(@RequestBody ResponseRequest request){
        return ResponseEntity.ok(ai_MailService.CreatePrompt_send(request));
    }
}
