package com.golovanova.commands;

import com.golovanova.CommandType;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoryCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;
    private final int COMMAND_HISTORY_SIZE = 11;

    public HistoryCommand() {
        super(CommandType.history);
    }
    //TODO


    public void execute(ArrayList<CommandType> history, CommandType commandType) {
        while (history.size() > 11) {
            history.remove(0);
        }

        for (CommandType command : history) {
            System.out.println(command);
        }
    }
}
