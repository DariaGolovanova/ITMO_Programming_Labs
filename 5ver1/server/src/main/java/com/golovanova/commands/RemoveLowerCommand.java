package com.golovanova.commands;

import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

//@Slf4j //Slf4j, logback.xml - читать
public class RemoveLowerCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveLowerCommand() {
        super(CommandType.remove_lower);
    }

    public List<Worker> execute(List<Worker> workers, String elementIdStr) throws WorkerNotFoundException {
        Integer elementIdInt = Integer.parseInt(elementIdStr);
        Worker worker = null;
        for (Worker w: workers) {
            if(w.getId().equals(elementIdInt)) {
                worker = w;
            }
        }

        if (worker == null) {
            throw new WorkerNotFoundException("wrong id: " + elementIdStr);
        }

        Iterator<Worker> iterator = workers.iterator();

        while(iterator.hasNext()){
            Worker w = iterator.next();
            if (w.compareTo(worker) == -1) {
            iterator.remove(); }
        }
        return workers;

    }
}
