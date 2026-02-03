package com.example.demo_tool_call;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.tool.ToolCallingChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_tool_call.model.ProductOrder;
import com.example.demo_tool_call.repository.ProductOrderRepository;
import com.example.demo_tool_call.tool.ProductOrderTool;

@SpringBootTest
public class OpenAiToolTests {
    private static final Logger log = LoggerFactory.getLogger(OpenAiToolTests.class);
    @Autowired
    private OpenAiChatModel chatModel;
    @Autowired
    private ProductOrderTool productOrderTool;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @BeforeEach
    public void beforeEach() {
        productOrderRepository.save(ProductOrder.builder()
                .orderNumber("1000000")
                .productName("맥북에어")
                .shippingAddress("서울시 영등포구 여의도동")
                .shippingStatus("배송중").build());
        productOrderRepository.save(ProductOrder.builder()
                .orderNumber("1000001")
                .productName("아이폰")
                .shippingAddress("서울시 강남구 역삼동")
                .shippingStatus("준비중").build());
    }

    @AfterEach
    public void AfterEach() {
        productOrderRepository.deleteAll();
    }

    @Test
    public void testProductOrder() {
        ToolCallback[] productOrderTools = ToolCallbacks.from(productOrderTool);
        ChatOptions chatOptions = ToolCallingChatOptions.builder()
                .toolCallbacks(productOrderTools)
                .build();

        // 제가 주문한 상품들의 목록을 알려 주세요.
        // 맥북에어 배송 상태를 알려 주세요.
        // 맥북에어 주문을 취소해 주세요.
        // 삼성 노트북 주문을 취소해 주세요.
        Prompt prompt = new Prompt("맥북에어 주문을 취소해 주세요.", chatOptions);
        ChatResponse  ChatResponse = chatModel.call(prompt);

        for (Generation generation : ChatResponse.getResults()) {
            System.out.println(generation.getOutput().getText());
        }
    }
}
