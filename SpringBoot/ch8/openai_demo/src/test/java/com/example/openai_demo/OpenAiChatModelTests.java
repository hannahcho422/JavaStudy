package com.example.openai_demo;

import org.junit.jupiter.api.Test;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAiChatModelTests {
    @Autowired
    private OpenAiChatModel chatModel;

    @Test
    public void testChatModelSimple() {
        String response = chatModel.call("Hello, who are you?");
        System.out.println(response);
    }
}
