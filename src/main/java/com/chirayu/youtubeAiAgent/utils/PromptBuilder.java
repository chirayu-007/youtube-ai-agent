package com.chirayu.youtubeAiAgent.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromptBuilder {

    public String getPrompt(List<String> filteredComments){

        List<String> safeComments = filteredComments.stream().limit(100).toList();

        String formatedComments = "- " + String.join("\n- ", safeComments);

        return "You are an expert YouTube content strategist. " +
                "Analyze the following recent comments from my subscribers. " +
                "Your goal is to tell me exactly what my audience wants to see next.\n\n" +
                "Please provide:\n" +
                "1. A brief summary of the overall sentiment.\n" +
                "2. The top 2 most requested topics.\n" +
                "3. 3 specific video title ideas based on this feedback.\n\n" +
                "Here is the raw comment data:\n" +
                formatedComments;
    }
}
