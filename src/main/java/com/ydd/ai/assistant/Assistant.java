package com.ydd.ai.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 普通 助手接口
 *
 * @author yangjx
 * @date 2025年07月20日 14:10
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel"
)
public interface Assistant {


    String chat(String userMessage);


}
