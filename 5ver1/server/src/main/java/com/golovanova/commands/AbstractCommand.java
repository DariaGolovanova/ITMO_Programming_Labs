package com.golovanova.commands;

import com.golovanova.CommandType;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    private CommandType commandType;

    public AbstractCommand(CommandType commandType) {
        this.commandType = CommandType.help;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return commandType.toString();
    }

    public int hashCode() {
        return commandType.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return commandType.equals(other.commandType);
    }
}
