package com.golovanova.utility;

import com.golovanova.CommandType;

public class CommandDecoder {
    public static CommandType decode(String input) {
        String[] split = input.split(" ");
        switch (split[0]) {
            case "help": return CommandType.help;
            case "info": return CommandType.info;
            case "add": return CommandType.add;
            case "show": return CommandType.show;
            case "update": return CommandType.update;
            case "remove_by_id": return CommandType.remove_by_id;
            case "clear": return CommandType.clear;
            case "execute_script": return CommandType.execute_script;
            case "exit": return CommandType.exit;
            case "remove_head": return CommandType.remove_head;
            case "remove_lower": return  CommandType.remove_lower;
            case "history": return CommandType.history;
            case "remove_any_by_organization": return CommandType.remove_any_by_organization;
            case "average_of_salary": return CommandType.average_of_salary;
            case "filter_by_organization": return CommandType.filter_by_organization;
            default: throw new IllegalArgumentException("Wrong command: " + split[0]);
        }
    }
}
