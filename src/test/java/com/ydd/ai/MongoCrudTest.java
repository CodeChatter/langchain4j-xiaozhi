package com.ydd.ai;

import com.ydd.ai.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


/**
 * MongoDB CRUD 测试类
 *
 * @author yangjx
 * @date 2025年07月21日 12:38
 */
@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入文档
     */
   /* @Test
    public void testInsert() {
        mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
    }*/

    /**
     * 插入文档
     */
    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("687dc744d6c92f46d69bb859", ChatMessages.class);
        System.out.println(chatMessages);
    }


    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("687dc744d6c92f46d69bb859");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新后的聊天记录列表");
        // upsert：如果不存在则插入
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }


    @Test
    public void testDeleteById() {
        Criteria criteria = Criteria.where("_id").is("687dc744d6c92f46d69bb859");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }

}
