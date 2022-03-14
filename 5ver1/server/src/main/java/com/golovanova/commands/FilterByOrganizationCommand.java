package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.List;

public class FilterByOrganizationCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public FilterByOrganizationCommand() {
        super(CommandType.filter_by_organization);
    }

    public String execute (List<Worker> workers, String organisationName) {
        String result = "";
        for (Worker w : workers) {
            if (w.getOrganization().getName().equals(organisationName)) {
                result += w.toString() + "\n";
            }
        }
        return result;
    }
}
