package com.group18.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Message {
    private String content;
    private LocalDateTime dateSent;
    private UUID sender;
    private UUID chatId;

    public Message(String content, LocalDateTime dateSent, UUID sender, UUID chatId) {
        this.content = content;
        this.dateSent = dateSent;
        this.sender = sender;
        this.chatId = chatId;
    }
}
