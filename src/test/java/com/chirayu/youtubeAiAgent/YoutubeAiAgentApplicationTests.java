package com.chirayu.youtubeAiAgent;

import com.chirayu.youtubeAiAgent.dto.AiRequestDTO;
import com.chirayu.youtubeAiAgent.dto.YouTubeResponseDTO;
import com.chirayu.youtubeAiAgent.service.AiService;
import com.chirayu.youtubeAiAgent.service.YoutubeService;
import com.chirayu.youtubeAiAgent.utils.FilterComments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class YoutubeAiAgentApplicationTests {

    @Autowired
    YoutubeService youtubeService;

    @Autowired
    AiService aiService;


	@Test
	void contextLoads() {
	}

    @Test void getMessages(){
        ObjectMapper mapper = new ObjectMapper();

//        YouTubeResponseDTO response = youtubeService.getComments("rRdJrhZAhBo");


//        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
//
//        System.out.println(prettyJson);
//
//        List<YouTubeResponseDTO.InnerSnippet> commentList = response.getItems().stream()
//                .map(item -> item.getSnippet().getTopLevelComment().getSnippet()).toList();
//
//        System.out.println("Downloaded " + commentList.size() + " raw comments.");
//
//        List<String> cleanedComments = FilterComments.getCleanComments(commentList);
//
//
//        System.out.println("Surviving clean comments: " + cleanedComments.size());
//
//
//        System.out.println(cleanedComments);
    }

    @Test
    public void getAiReply(){

        AiRequestDTO aiRequestDTO = new AiRequestDTO();
        aiRequestDTO.setGeminiApiKey("AIzaSyDmxJf1F8RAqTiqx82-JaINE2ZLIDJKSsk");
        aiRequestDTO.setVideoId("cvoLc3deAdQ");
        aiRequestDTO.setYouTubeApiKey("AIzaSyAavyYfTSGFbItu3HVTuMfrj852WX4_OBI");


        String str = aiService.getAiReply(aiRequestDTO);

        System.out.println(str);
    }

}
