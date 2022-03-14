package com.golovanova.commands;

import com.golovanova.CommandType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HelpCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public HelpCommand() {
        super(CommandType.help);
    }

    public String execute() {
        CommandType[] commandTypes = CommandType.values();
        String helpString = Arrays.stream(commandTypes)
                .map(c -> new StringBuilder(c.getName()).append(" - ").append(c.getDescription()).toString()
                ).collect(Collectors.joining("\n"));

        return helpString;
    }
}
