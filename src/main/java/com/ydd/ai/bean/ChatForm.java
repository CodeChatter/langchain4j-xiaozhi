package com.ydd.ai.bean;

import lombok.Data;

/**
 * 对话信息
 *
 * @author yangjx
 * @date 2025年07月21日 15:28
 */
@Data
public class ChatForm {

    //对话id
    private Long memoryId;
    //用户问题
    private String message;

}
