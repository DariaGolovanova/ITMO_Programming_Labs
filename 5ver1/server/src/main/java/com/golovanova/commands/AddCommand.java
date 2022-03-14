package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;
import com.golovanova.utility.CollectionFileManager;

import java.io.Serializable;
import java.util.List;

public class AddCommand extends AbstractCommand implements Serializable {
    private final CollectionFileManager collectionFileManager;

    public AddCommand(CollectionFileManager collectionFileManager) {
        super(CommandType.add);
        this.collectionFileManager = collectionFileManager;
    }

    public List<Worker> execute(List<Worker> workers, Worker worker) {
        workers.add(worker);
        collectionFileManager.writeCollection(workers);
        return workers;
    }
}
