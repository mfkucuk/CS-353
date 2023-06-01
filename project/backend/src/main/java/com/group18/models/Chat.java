package com.group18.models;

import java.util.UUID;

import lombok.Data;

@Data
public class Chat {
    private UUID chatId;
    private UUID recipient1Id;
    private UUID recipient2Id;

    public Chat(UUID chatId, UUID recipient1Id, UUID recipient2Id) {
        this.chatId = chatId;
        this.recipient1Id = recipient1Id;
        this.recipient2Id = recipient2Id;
    }
}
