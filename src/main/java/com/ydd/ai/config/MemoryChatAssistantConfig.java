package com.ydd.ai.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 记忆助手配置类
 *
 * @author yangjx
 * @date 2025年07月20日 14:54
 */
@Configuration
public class MemoryChatAssistantConfig {


    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }

}
