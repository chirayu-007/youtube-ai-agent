package com.chirayu.youtubeAiAgent.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AiRequestDTO {

    private String geminiApiKey;
    private String youTubeApiKey;
    private String videoId;
}
