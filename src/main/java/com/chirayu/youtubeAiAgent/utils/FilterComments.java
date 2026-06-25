package com.chirayu.youtubeAiAgent.utils;

import com.chirayu.youtubeAiAgent.dto.YouTubeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class FilterComments {

    private static final List<String> BLACK_LIST = List.of(
            "who is watching",
            "anyone in",
            "like if",
            "like this comment",
            "first",
            "watching",
            "Who's here in",
            "starting",
            "date"
    );

    public static List<String> getCleanComments(List<YouTubeResponseDTO.InnerSnippet> comments) {
        return comments.stream()

                .filter(c -> c.getTextOriginal() != null && c.getTextOriginal().trim().length() > 15)

                .filter(c -> c.getLikeCount() != null && c.getLikeCount() > 0)

                .filter(c -> !c.getTextOriginal().contains("http"))

                .filter(c -> {
                    String lowerCaseText = c.getTextOriginal().toLowerCase();
                    return BLACK_LIST.stream().noneMatch(lowerCaseText::contains);
                })

                .map(YouTubeResponseDTO.InnerSnippet::getTextOriginal)

                .distinct()

                .collect(Collectors.toList());
    }
}
