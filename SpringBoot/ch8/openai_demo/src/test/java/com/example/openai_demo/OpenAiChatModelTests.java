package com.example.openai_demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.metadata.RateLimit;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;


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

    @Test
    public void testChatGptPrompt() {
        List<Message> messages = List.of(
            new SystemMessage("간략하게 답변해주세요."),
            new UserMessage("서울 올림픽에 대해 알려 주세요."),
            new AssistantMessage("서울 올림픽, 공식명칭은 제24회 하계 올림픽대회는 1988년 9월 17일부터 10월 2일까지 대한민국 서울에서 개최되었습니다. 이 대회는 한국에서 처음으로 열린 올림픽 경기로, 총 159개 국가가 참여하였고 23종목의 경기가 진행되었습니다. 서울 올림픽은 성공적인 개최로 평가받았으며, 그로 인해 한국은 국제 스포츠 무대에서의 위상이 크게 향상되었습니다. 또한, 대회 기간 동안 평화와 화합을 강조하며 많은 이들에게 기억에 남는 현장이 되었습니다."),
            new UserMessage("그럼 바로 그 이전 올림픽은 어디야?"),
            new AssistantMessage("바로 이전 올림픽은 1984년 하계 올림픽으로, 미국 로스앤젤레스에서 개최되었습니다. 이 대회는 7월 28일부터 8월 12일까지 진행되었고, 많은 국가가 참여한 강행된 올림픽 중 하나였습니다."),
            new UserMessage("그럼 그 2개의 올림픽 중 참여 국가는 어디가 많아?")
        );

        ChatOptions chatOptions = OpenAiChatOptions.builder()
                .model(OpenAiApi.ChatModel.GPT_4_O)
                .N(2)   // 답변 개수
                .temperature(1.0)   // 창의성, 다양성 온도
                .build();

        Prompt prompt = new Prompt(messages, chatOptions);

        ChatResponse chatResponse = chatModel.call(prompt);
        
        // Token 사용량
        Usage usage = chatResponse.getMetadata().getUsage();
        System.out.println("pormptTokens = " + usage.getPromptTokens());
        System.out.println("completionTokens = " + usage.getCompletionTokens());
        System.out.println("totalTokens = " + usage.getTotalTokens());
        System.out.println("totalTokens = " + usage.getTotalTokens());

        // 요청 제한 상세
        RateLimit rateLimit = chatResponse.getMetadata().getRateLimit();
        System.out.println("requestLimit = " + rateLimit.getRequestsLimit());
        System.out.println("requtesRemaining = " + rateLimit.getRequestsRemaining());
        System.out.println("requestReset = " + rateLimit.getRequestsReset());

        // 토큰 사용 제한 상세
        System.out.println("tokensLimit = " + rateLimit.getTokensLimit());
        System.out.println("tokensRemaining = " + rateLimit.getTokensRemaining());
        System.out.println("tokensReset = " + rateLimit.getTokensReset());

        for (Generation generation : chatResponse.getResults()) {
            System.out.println(generation.getOutput().getText());
        }
    }

    @Test
    public void testChatModelImage() {
        Resource resource = new FileSystemResource("/Users/hannahcho/Desktop/etc/Images/Milk.png");

        var media = Media.builder()
                .mimeType(MimeTypeUtils.IMAGE_PNG)
                .data(resource)
                .build();

        Message message = UserMessage.builder()
                .text("사진에 제목을 붙인다면 무엇이 좋을까?")
                .media(media)
                .build();

        String response = chatModel.call(message);
        System.out.println("result = " + response);
    }

    @Test
    public void testChatModelAudioInput() {
        var audioResource = new ClassPathResource("sample_audio.mp3");
        var media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType("audio/mp3"))
                .data(audioResource)
                .build();
        var userMessage = UserMessage.builder()
                .text("이 오디오 파일의 내용에 대해 요약해 주세요")
                .media(media)
                .build();
        var chatOptions = OpenAiChatOptions.builder()
                .model(OpenAiApi.ChatModel.GPT_4_O_AUDIO_PREVIEW)
                .build();
        var prompt = Prompt.builder()
                .messages(userMessage)
                .chatOptions(chatOptions)
                .build();

        ChatResponse response = chatModel.call(prompt);

        System.out.println("result = " + response.getResult().getOutput().getText());
    }

    @Test
    public void testChatModelAudioOutput() throws IOException {
        ChatResponse response = chatModel.call(new Prompt("스프링부트에 대해 간단하게 설명해 주세요",
                OpenAiChatOptions.builder()
                        .temperature(0.5)
                        .model(OpenAiApi.ChatModel.GPT_4_O_AUDIO_PREVIEW)
                        .outputModalities(List.of("text", "audio"))
                        .outputAudio(new OpenAiApi.ChatCompletionRequest.AudioParameters(
                                OpenAiApi.ChatCompletionRequest.AudioParameters.Voice.NOVA,
                                OpenAiApi.ChatCompletionRequest.AudioParameters.AudioResponseFormat.MP3)
                        ).build()));

        String text = response.getResult().getOutput().getText(); // audio transcript
        System.out.println("result = " + text);

        byte[] audio = response.getResult().getOutput().getMedia().getFirst().getDataAsByteArray(); // audio data
        Files.write(Paths.get("D:\\archive\\audio\\ai_chat_audio.mp3"), audio);
    }

    @Test
    public void testChatModelAudioInputOutput() throws IOException {
        var audioResource = new ClassPathResource("sample_audio_ask.mp3");
        var media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType("audio/mp3"))
                .data(audioResource)
                .build();
        var userMessage =UserMessage.builder()
                .text("질문에 친절하고 간략하게 답변해 주세요")
                .media(media)
                .build();

        ChatResponse response = chatModel.call(new Prompt(userMessage,
        OpenAiChatOptions.builder()
                .temperature(0.5)
                .model(OpenAiApi.ChatModel.GPT_4_O_AUDIO_PREVIEW)
                .outputModalities(List.of("text", "audio"))
                .outputAudio(new OpenAiApi.ChatCompletionRequest.AudioParameters(
                        OpenAiApi.ChatCompletionRequest.AudioParameters.Voice.NOVA,
                        OpenAiApi.ChatCompletionRequest.AudioParameters.AudioResponseFormat.MP3)
                ).build()));

        String text = response.getResult().getOutput().getText(); // audio transcript
        System.out.println("result = " + text);

        byte[] audio = response.getResult().getOutput().getMedia().getFirst().getDataAsByteArray(); // audio data
        Files.write(Paths.get("D:\\archive\\audio\\ai_chat_audio_answer.mp3"), audio);
    }
}

