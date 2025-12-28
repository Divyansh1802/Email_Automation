package com.EmailAutomation.AI_gen_MAILService.Service;

import com.EmailAutomation.AI_gen_MAILService.Configuration.WebClientConfig;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Data
@RequiredArgsConstructor
public class GetRecommendation {
    private final WebClientConfig  webClientConfig;

    @Value("${gemini.api.url}")
    private String gemini_url;
    @Value("${gemini.api.key}")
    private String gemini_api_key;

    public String AiMailAssist(Map<String, Object> requestData) {
        try{
            return webClientConfig.AiPromptClient()
                    .post()
                    .uri(gemini_url)
                    .header("Content-Type","application/json")
                    .header("x-goog-api-key",gemini_api_key)
                    .bodyValue(requestData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
