package com.chirayu.youtubeAiAgent.controller;

import com.chirayu.youtubeAiAgent.dto.AiRequestDTO;
import com.chirayu.youtubeAiAgent.dto.YouTubeRequestDTO;
import com.chirayu.youtubeAiAgent.dto.YouTubeResponseDTO;
import com.chirayu.youtubeAiAgent.service.AiService;
import com.chirayu.youtubeAiAgent.service.YoutubeService;
import com.chirayu.youtubeAiAgent.utils.FilterComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/youTube/api")
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    @Autowired
    private AiService aiService;

    @PostMapping("/rawComments")
    public ResponseEntity<YouTubeResponseDTO> getRawComments(@RequestBody YouTubeRequestDTO youTubeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(youtubeService.getComments(youTubeRequestDTO.getVideoId(), youTubeRequestDTO.getApiKey()));
    }

    @PostMapping("/filteredComments")
    public ResponseEntity<List<String>> getFilteredComments(@RequestBody YouTubeRequestDTO youTubeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(youtubeService.getFilteredComments(youTubeRequestDTO.getVideoId(), youTubeRequestDTO.getApiKey()));
    }

    @PostMapping("/ai/suggestion")
    public ResponseEntity<String> getAiSuggestion(@RequestBody AiRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.getAiReply(requestDTO));
    }
}
