package com.golovanova.dto;

import com.golovanova.CommandType;

public class StringCommandMessage implements CommandMessage {
    private CommandType commandType;
    private String argument;

    public StringCommandMessage(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }
    
    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    public String getArgument() {
        return argument;
    }
}
