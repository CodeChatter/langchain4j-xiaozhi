package com.ydd.ai;

import com.ydd.ai.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AIService 测试类
 *
 * @author yangjx
 * @date 2025年07月20日 14:11
 */
@SpringBootTest
public class AIServiceTest {


    @Autowired
    private OpenAiChatModel openAiChatModel;


    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        String answer = assistant.chat("你是谁？");
        System.out.println(answer);
    }


    @Autowired
    private Assistant assistant;


    @Test
    public void testChat2() {
        String answer = assistant.chat("你是谁？");
        System.out.println(answer);
    }


    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatQwen() {
        //创建AIService
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        //调用service的接口
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }
}