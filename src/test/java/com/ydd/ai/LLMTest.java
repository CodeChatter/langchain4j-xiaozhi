package com.ydd.ai;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * LLM 测试工具类
 *
 * @author yangjx
 * @date 2025年07月19日 23:59
 */
@SpringBootTest
public class LLMTest {


    /**
     * gpt-4o-mini语言模型接入测试
     */
    @Test
    public void testGPTDemo() {
        //初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                // LangChain4j提供的代理服务器，该代理服务器会将演示密钥替换成真实密钥， 再将请求发给OpenAI API
                // 设置模型api地址（如果apiKey = "demo"，则可省略baseUrl的配置）
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                //设置模型apiKey
                .apiKey("demo")
                //设置模型名称
                .modelName("gpt-4o-mini")
                .build();
        //向模型提问
        String answer = model.chat("你好");
        //输出结果
        System.out.println(answer);
    }


    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testLLMSpringBoot() {
        String answer = openAiChatModel.chat("你是谁？可以帮我干嘛？");

        System.out.println(answer);
    }

}
