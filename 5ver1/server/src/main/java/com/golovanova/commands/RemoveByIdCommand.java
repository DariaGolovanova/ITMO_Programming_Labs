package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;

public class RemoveByIdCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveByIdCommand() {
        super(CommandType.remove_by_id);
    }

    public List<Worker> execute(List<Worker> workers, int argument) {
            for (Worker w : workers) {
                if (w.getId() == argument) {
                    workers.remove(w);
                }
            }
            return workers;
    }
}
