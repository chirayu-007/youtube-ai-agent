package com.chirayu.youtubeAiAgent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class YouTubeResponseDTO {

    private String nextPageToken;
    private List<Item> items;

    @ToString
    @Getter
    @Setter
    public static class Item {
        private Snippet snippet;
    }

    @ToString
    @Getter
    @Setter
    public static class Snippet {
        private TopLevelComment topLevelComment;
    }

    @ToString
    @Getter
    @Setter
    public static class TopLevelComment {
        private InnerSnippet snippet;
    }

    @ToString
    @Getter
    @Setter
    public static class InnerSnippet {
        private String textOriginal;
        private String authorDisplayName;
        private Integer likeCount;
        private String publishedAt;
    }
}