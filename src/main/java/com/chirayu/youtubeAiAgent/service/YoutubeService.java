package com.chirayu.youtubeAiAgent.service;

import com.chirayu.youtubeAiAgent.dto.YouTubeResponseDTO;
import com.chirayu.youtubeAiAgent.utils.FilterComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class YoutubeService {

    @Value("${youtube.api.url}")
    private String apiUrl;

//    @Value("${youtube.api.key}")
//    private String apiKey;

    @Autowired
    private RestClient restClient;

    public YouTubeResponseDTO getComments(String videoId, String apiKey) {

        String urlTemplate = apiUrl + "?part=snippet&order=relevance&key={key}&videoId={id}&maxResults=100";

        return restClient.get()
                .uri(urlTemplate, apiKey, videoId)
                .retrieve()
                .body(YouTubeResponseDTO.class);
    }

    public List<String> getFilteredComments(String videoId, String youtubeApikey){
        YouTubeResponseDTO response = getComments(videoId, youtubeApikey);

        List<YouTubeResponseDTO.InnerSnippet> comments = response.getItems().stream()
                .map(comment -> comment.getSnippet().getTopLevelComment().getSnippet()).toList();

        List<String> commentList = FilterComments.getCleanComments(comments);

        return commentList;
    }
}