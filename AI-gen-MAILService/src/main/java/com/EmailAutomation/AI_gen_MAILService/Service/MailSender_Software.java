package com.EmailAutomation.AI_gen_MAILService.Service;

import com.EmailAutomation.AI_gen_MAILService.Configuration.WebClientConfig;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class MailSender_Software {
      private final WebClientConfig webClientConfig;

      public void Send_Mail(String from,String to,String subject,String content){
          try {
              webClientConfig.EmailClient()
                      .get()
                      .uri(uriBuilder -> uriBuilder
                              .path("/MailSend/Mailvia/Software")
                              .queryParam("from",from)
                              .queryParam("to",to)
                              .queryParam("subject",subject)
                              .queryParam("content",content)
                              .build()
                      )
                      .retrieve()
                      .bodyToMono(void.class)
                      .block();
          }catch(Exception ex){
              throw new RuntimeException(ex);
          }
      }

}
