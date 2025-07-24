package com.ydd.ai.controller;

import com.ydd.ai.assistant.XiaoZhiAgent;
import com.ydd.ai.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * description
 *
 * @author yangjx
 * @date 2025年07月21日 15:28
 */
@Tag(name = "羊大小智")
@RestController
@RequestMapping("/xiaozhi")
public class XiaoZhiController {

    @Autowired
    private XiaoZhiAgent xiaozhiAgent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }


}
