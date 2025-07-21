package com.ydd.ai.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 普通记忆 助手接口
 *
 * @author yangjx
 * @date 2025年07月20日 14:53
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {


    //    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}")
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{m}}")
    String chat(@V("m") String userMessage);

}
