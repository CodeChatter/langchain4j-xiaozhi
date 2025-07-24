package com.ydd.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * 小智 agent
 *
 * @author yangjx
 * @date 2025年07月21日 15:21
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        /*chatModel = "openAiChatModel",*/
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderXiaoZhi",
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverXiaoZhiPinecone"
)
public interface XiaoZhiAgent {

    @SystemMessage(fromResource = "xiaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
