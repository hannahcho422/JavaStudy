package com.example.openai_demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.ai.audio.tts.TextToSpeechPrompt;
import org.springframework.ai.audio.tts.TextToSpeechResponse;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAiAudioSpeechModelTests {

    @Autowired
    private OpenAiAudioSpeechModel speechModel;

    @Test
    public void testSpeechModelSimple() throws IOException {
        byte[] bin = speechModel.call(
                "안녕하세요 반갑습니다. 스프링부트는 자바 프레임워크 중에 가장 인기가 많은 프레임워크입니다."
        );
        Files.write(Path.of("D:\\archive\\audio\\ai_tts_simple.mp3"), bin);
    }

    @Test
    public void testSpeechModelOptions() throws IOException {
        OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
                .model("tts-1-hd") // tts-1, tts-1-hd
                .voice(OpenAiAudioApi.SpeechRequest.Voice.NOVA)
                .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .speed(1.0d) 
                .build();

        String textToSpeech =
                "안녕하세요 반갑습니다. 스프링부트는 자바 프레임워크 중에 가장 인기가 많은 프레임워크입니다.";

        TextToSpeechPrompt prompt = new TextToSpeechPrompt(textToSpeech, speechOptions);
        TextToSpeechResponse response = speechModel.call(prompt);

        System.out.println("meta = " + response.getMetadata());

        System.out.println("Rate limit information is not available.");

        Files.write(Path.of("D:\\archive\\audio\\ai_tts_options.mp3"), response.getResult().getOutput());
    }
}