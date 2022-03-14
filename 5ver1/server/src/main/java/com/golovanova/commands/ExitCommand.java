package com.golovanova.commands;

import com.golovanova.CommandType;

import java.io.Serializable;
//TODO ??

public class ExitCommand extends AbstractCommand implements Serializable { ;
    static final long SerialVersionUID = -4862926644813433707L;
    public ExitCommand() {
        super(CommandType.exit);
    }

    public void execute() {
        System.exit(0);
    }
}
