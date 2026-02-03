package com.example.openai_demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAiAudioSpeechModelTests {
    @Autowired
    private OpenAiAudioSpeechModel speechModel;

    private static final Logger log = 
            LoggerFactory.getLogger(com.example.openai_demo.OpenAiAudioSpeechModelTests.class);

    @Test
    public void testSeechModelSimple() throws IOException {
        byte[] bin = speechModel.call("안녕하세요 반갑습니다. 스프링부트는 자바 프레임워크 중에 가장 인기가 많은 프레임워크입니다.");
        Files.write(Paths.get("D:\\archive\\audio\\ai_tts_simple.mp3"), bin);
    }

}
