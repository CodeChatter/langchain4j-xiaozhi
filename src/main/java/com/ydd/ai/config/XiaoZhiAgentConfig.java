package com.ydd.ai.config;

import com.ydd.ai.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * 小智 智能体配置
 *
 * @author yangjx
 * @date 2025年07月21日 15:25
 */
@Configuration
public class XiaoZhiAgentConfig {


    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;


    @Bean
    ChatMemoryProvider chatMemoryProviderXiaoZhi() {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
