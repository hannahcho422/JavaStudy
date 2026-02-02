package com.example.openai_demo;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.messages.AssistantMessage;
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

    @Test
    public void testChatModelMessageContext() {
        var system = new SystemMessage("간략하게 답변해 주세요.");
        var message1 = new UserMessage("서울 올림픽에 대해 알려 주세요.");
        var assistant1 = new AssistantMessage("서울 올림픽, 공식명칭은 제24회 하계 올림픽대회는 1988년 9월 17일부터 10월 2일까지 대한민국 서울에서 개최되었습니다. 이 대회는 한국에서 처음으로 열린 올림픽 경기로, 총 159개 국가가 참여하였고 23종목의 경기가 진행되었습니다. 서울 올림픽은 성공적인 개최로 평가받았으며, 그로 인해 한국은 국제 스포츠 무대에서의 위상이 크게 향상되었습니다. 또한, 대회 기간 동안 평화와 화합을 강조하며 많은 이들에게 기억에 남는 현장이 되었습니다.");
        var message2 = new UserMessage("그럼 바로 그 이전 올림픽은 어디야?");
        var assistant2 = new AssistantMessage("바로 이전 올림픽은 1984년 하계 올림픽으로, 미국 로스앤젤레스에서 개최되었습니다. 이 대회는 7월 28일부터 8월 12일까지 진행되었고, 많은 국가가 참여한 강행된 올림픽 중 하나였습니다.");
        var message3 = new UserMessage("그럼 그 2개의 올림픽 중 참여 국가는 어디가 많아?");
        String response = chatModel.call(system, message1, assistant1, message2, assistant2, message3);
        System.out.println(response);

    }
}
