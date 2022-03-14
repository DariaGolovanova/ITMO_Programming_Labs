package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;

public class ClearCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;
    public ClearCommand() {
        super(CommandType.clear);
    }

    public List<Worker> execute(List<Worker> workers) {
        workers.clear();
        return workers;
    }
}
