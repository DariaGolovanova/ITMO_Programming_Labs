package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;

public class ShowCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public ShowCommand() {
        super(CommandType.show);
    }

    public String execute(List<Worker> workers) {
        String result = "";
        for (Worker w : workers) {
            result += w.toString() + "\n";
        }
        return result;
    }
}
