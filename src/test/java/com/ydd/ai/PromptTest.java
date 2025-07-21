package com.ydd.ai;

import com.ydd.ai.assistant.MemoryChatAssistant;
import com.ydd.ai.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description
 *
 * @author yangjx
 * @date 2025年07月21日 13:53
 */
@SpringBootTest
public class PromptTest {


    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testPrompt() {
        String answer = separateChatAssistant.chat(3, "今天几号");
        System.out.println(answer);
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer = memoryChatAssistant.chat("我是羊大");
        System.out.println(answer);
        String answer2 = memoryChatAssistant.chat("我18了");
        System.out.println(answer2);
        String answer3 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer3);
    }


    @Test
    public void testUserInfo() {
        // 从数据库中获取用户信息……
        String answer = separateChatAssistant.chat3(10, "我是谁，我多大了", "翠花", 18);
        System.out.println(answer);
    }


}
