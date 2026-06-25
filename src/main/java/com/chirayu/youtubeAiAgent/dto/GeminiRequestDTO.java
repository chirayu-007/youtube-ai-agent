package com.chirayu.youtubeAiAgent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GeminiRequestDTO {

    private List<Content> contents;

    @Getter
    @Setter
    @Builder
    public static class Content{
        private List<Part> parts;
    }

    @Getter
    @Setter
    @Builder
    public static  class Part{
        private String text;
    }


}
