package com.chirayu.youtubeAiAgent.service;

import com.chirayu.youtubeAiAgent.dto.AiRequestDTO;
import com.chirayu.youtubeAiAgent.dto.AiResponseDTO;
import com.chirayu.youtubeAiAgent.dto.GeminiRequestDTO;
import com.chirayu.youtubeAiAgent.dto.YouTubeResponseDTO;
import com.chirayu.youtubeAiAgent.utils.PromptBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AiService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private YoutubeService youtubeService;

    @Autowired
    private PromptBuilder promptBuilder;

    @Value("${gemini.api.url}")
    private String geminiUrl;

   public GeminiRequestDTO getAiRequest(String prompt){

       return GeminiRequestDTO.builder()
               .contents(List.of(
                       GeminiRequestDTO.Content.builder()
                               .parts(List.of(
                                       GeminiRequestDTO.Part.builder()
                                               .text(prompt).build()
                               )).build()
               )).build();
   }

   public AiResponseDTO getAiResponse(String apiKey, String prompt){
       return restClient.post()
               .uri(geminiUrl)
               .header("x-goog-api-key", apiKey)
               .header("Content-Type", "application/json")
               .body(getAiRequest(prompt))
               .retrieve()
               .body(AiResponseDTO.class);
   }

    public String getReply(String geminiApiKey, String prompt){
        return getAiResponse(geminiApiKey, prompt).getCandidates().get(0)
                .getContent()
                .getParts()
                .get(0)
                .getText();
    }

    public String getAiReply(AiRequestDTO requestDTO){
        List<String> filteredComments = youtubeService.getFilteredComments(requestDTO.getVideoId(), requestDTO.getYouTubeApiKey());
        String prompt = promptBuilder.getPrompt(filteredComments);
        return getReply(requestDTO.getGeminiApiKey(), prompt);
    }
}
