package com.example.openai_demo;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAiChatModelTests {
    @Autowired
    private OpenAiChatModel chatModel;
}
