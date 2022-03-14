package com.golovanova;

public enum CommandType {
    help("help", "display help for available golovanova.golovanova.commands"),
    info("info", "display information about the collection"),
    show("show", "output all elements of the collection " +
            "in a string representation to the standard output stream"),
    add("add {element}", "add a new item to the collection"),
    update("update id {element}", "update the value of a collection " +
            "element whose id is equal to the specified one"),
    remove_by_id("remove_by_id id",
            "delete an item from the collection by its id"),
    clear("clear", "clear the collection"),
    execute_script("execute_script file_name", "read and execute the script from the specified " +
            "file. The script contains golovanova.golovanova.commands in the same form as the user enters them interactively."),
    exit("exit", "end the program (without saving it to a file)"),
    remove_head("remove_head", "print the first item in the collection and delete it"),
    remove_lower("remove_lower {element_id}", "remove all items from the collection that are " +
            "smaller than the specified one"),
    history("history", "print the last 11 golovanova.golovanova.commands (without their arguments)"),
    remove_any_by_organization("remove_any_by_organization organization", "remove one element from the " +
            "collection whose organization field value is equivalent to the specified one"),
    average_of_salary("average_of_salary", "output the average value of the salary field for all items in the collection"),
    filter_by_organization("filter_by_organization organization", "output elements whose organization field value is equal to the specified value");

    private String name;
    private String description;

    CommandType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
