package com.golovanova.dto;

import com.golovanova.CommandType;

public class PayloadCommandMessage implements CommandMessage {
    private CommandType commandType;
    private Payload payload;

    public PayloadCommandMessage(CommandType commandType, Payload payload) {
        this.commandType = commandType;
        this.payload = payload;
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    public Payload getPayload() {
        return payload;
    }
}
