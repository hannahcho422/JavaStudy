package com.example.openai_demo;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
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

    @Test
    public void testChatModelMessage() {
        UserMessage userMessage = new UserMessage("서울 올림픽에 대해 알려주세요.");
        SystemMessage systemMessage = new SystemMessage("답변은 최대한 간결하게 하고 곤련된 내용은 뉴슬르 참고하라고 해줘.");
        String response = chatModel.call(userMessage, systemMessage);
        System.out.println(response);
    }
}
