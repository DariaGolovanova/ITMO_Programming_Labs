package com.golovanova.commands;

import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.data.ConsoleDataSource;
import com.golovanova.data.DataSource;
import com.golovanova.CommandType;
import com.golovanova.model.Worker;
import com.golovanova.scanner.SpecialWorkerScanner;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class UpdateCommand extends AbstractCommand implements Serializable {
    private DataSource dataSource;
    private SpecialWorkerScanner workerScanner;
    static final long SerialVersionUID = -4862926644813433707L;

    public UpdateCommand() {
        super(CommandType.update);
        dataSource = new ConsoleDataSource(new Scanner(System.in));
        workerScanner = new SpecialWorkerScanner(dataSource);
    }

    public UpdateCommand(DataSource dataSource) {
        super(CommandType.update);
        this.dataSource = dataSource;
        workerScanner = new SpecialWorkerScanner(dataSource);
    }

    public void execute(List<Worker> workers, Worker worker) throws WorkerNotFoundException {
        try {
            for (Worker w : workers) {
                if (w.getId().equals(worker.getId())) {
                    w.setCoordinates(worker.getCoordinates());
                    w.setCreationDate(worker.getCreationDate());
                    w.setName(worker.getName());
                    w.setOrganization(worker.getOrganization());
                    w.setPosition(worker.getPosition());
                    w.setStatus(worker.getStatus());
                    w.setSalary(worker.getSalary());
                    w.setStartDate(worker.getStartDate());
                }
            }
        } catch (NullPointerException exception) {
            System.err.println("Worker is null!");
        }
    }
}
