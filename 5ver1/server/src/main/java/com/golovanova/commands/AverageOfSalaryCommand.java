package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;


public class AverageOfSalaryCommand extends AbstractCommand implements Serializable {
    private double averageSalary;
    static final long SerialVersionUID = -4862926644813433707L;

    public AverageOfSalaryCommand() {
        super(CommandType.average_of_salary);
    }


    public double execute(List<Worker> workers) {

        for (Worker w: workers) {
            averageSalary+= w.getSalary();
        }
        return averageSalary = averageSalary/workers.size();
    }
}
