package com.EmailAutomation.EmailService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/MailSend")
@RequiredArgsConstructor
public class EmailController {
    private final MailService mailService;

    @GetMapping("/notify/{email}")
    public String send_OTP_mail(@PathVariable("email") String email) {
        return mailService.ConfirmationMail(email);
    }

    @GetMapping("/Mailvia/Software")
    public void sendMailviaSoftware(@RequestParam("from") String from
                           ,@RequestParam("to") String to
                             ,@RequestParam("subject") String subject,
                                          @RequestParam("content") String content) {
        mailService.send_AI_Mail(from,to,subject,content);
    }

}
