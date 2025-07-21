package com.ydd.ai.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * mongodb 存储聊天记录表
 *
 * @author yangjx
 * @date 2025年07月21日 12:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {

    //唯一标识，映射到 MongoDB 文档的 _id 字段
    @Id
//    private Long messageId;
    private ObjectId messageId;

    private String memoryId;

    //存储当前聊天记录列表的json字符串
    private String content;
}
