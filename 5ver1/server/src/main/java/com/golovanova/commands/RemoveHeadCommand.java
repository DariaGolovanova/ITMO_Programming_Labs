package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;

public class RemoveHeadCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveHeadCommand() {
        super(CommandType.remove_head);
    }

    public Worker execute(List<Worker> workers) {
       Worker w = workers.get(0);
       workers.remove(0);
       return w;
    }
}
