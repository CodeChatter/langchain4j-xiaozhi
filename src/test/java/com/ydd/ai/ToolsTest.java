package com.ydd.ai;

import com.ydd.ai.assistant.MemoryChatAssistant;
import com.ydd.ai.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Function calling 测试类
 *
 * @author yangjx
 * @date 2025年07月21日 16:49
 */
@SpringBootTest
public class ToolsTest {


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testOriginLLM() {
        String answer = memoryChatAssistant.chat("1+2等于几，475695037565的平方根是多少？");
        //答案：3，689706.4865
        System.out.println(answer);
        // 1+2等于3呀！😄 475695037565的平方根大约是689345.55哦！📐 侬还有啥想问的伐？

        // 原始的大模型，计算数值并不一定准确，可能会有误差。
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = separateChatAssistant.chat(12, "1+2等于几，475695037565的平方根是多少？");
        //答案：3，689706.4865
        System.out.println(answer);
    }

}
