package com.EmailAutomation.AI_gen_MAILService.Service;

import com.EmailAutomation.AI_gen_MAILService.DTO.ResponseRequest;
import com.EmailAutomation.AI_gen_MAILService.Model.AI_gen_Email;
import com.EmailAutomation.AI_gen_MAILService.Repository.AI_MailRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
@Data
@RequiredArgsConstructor
public class AI_MailService {

      private final AI_MailRepository  ai_mailRepository;
      private final GetRecommendation getRecommendation;
      private final MailSender_Software  mailSender;

      public  String CreatePrompt(ResponseRequest request) {
         Map<String,Object> requestData =    Map.of(
                "contents",new Object[]{
                        Map.of("parts"
                        , new Object[]{
                                Map.of(
                                        "text", "write a mail in very short for with just " +
                                                "the body content no other stuff "+
                                                request.getBody()
                                )
                                })
                }
          );
         return StorePrompt_Response(requestData,request);
     }

    public  String CreatePrompt_send(ResponseRequest request) {
        Map<String,Object> requestData =    Map.of(
                "contents",new Object[]{
                        Map.of("parts"
                                , new Object[]{
                                        Map.of(
                                                "text", "write a mail in short for with just " +
                                                        "the body content no subject "+
                                                        request.getBody()
                                        )
                                })
                }
        );
        String content_body=StorePrompt_Response(requestData,request);
        mailSender.Send_Mail(request.getEmail(), request.getTo(), request.getSubject(), content_body);
        return content_body ;
    }

     public String StorePrompt_Response(Map<String, Object> requestData,
                                        ResponseRequest request) {

          String response=getRecommendation.AiMailAssist(requestData);
          if(response==null || response.isBlank()){
              throw new RuntimeException();
          }
          String aitext;
          if(response.trim().startsWith("{")) {
              try {

                  ObjectMapper objectMapper = new ObjectMapper();
                  JsonNode rootNode = objectMapper.readTree(response);

                  aitext = String.valueOf(rootNode.path("candidates")
                          .get(0)
                          .path("content")
                          .get("parts")
                          .get(0)
                          .path("text"));
              }catch (Exception e){
                  throw new RuntimeException(e);
              }
          }
          else{
              aitext = response;
          }

          AI_gen_Email mail= ai_mailRepository.findByEmail(request.getEmail());
          mail.getContainer().put(request.getSubject(), aitext);
          ai_mailRepository.save(mail);
          return aitext;
     }

    public void registerClient(String email) {
          if(ai_mailRepository.existsByEmail(email)){
              return;
          }
          AI_gen_Email mail=new AI_gen_Email();
          mail.setEmail(email);
          ai_mailRepository.save(mail);
          System.out.println("USER CREATED BY LOGIN ");
          System.out.println(ai_mailRepository.findByEmail(email));
    }

}
