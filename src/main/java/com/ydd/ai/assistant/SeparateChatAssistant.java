package com.ydd.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 隔离会话 助手接口
 *
 * @author yangjx
 * @date 2025年07月20日 14:59
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
//        chatModel = "openAiChatModel",
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools" // 指定工具类
)
public interface SeparateChatAssistant {


    //    @SystemMessage("你是我的好朋友，请用东北话回答问题。")
    //    @SystemMessage("你是我的好朋友，请用西安话回答问题。今天是{{current_date}}")
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);


    @UserMessage("你是我的好朋友，请用河南话回答问题。{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);


    @SystemMessage(fromResource = "my-prompt-template3.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );

}
