package com.golovanova.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Stack;

public class RecursionChecker {
    private Stack<String> filenames = new Stack<>();

    public boolean checkRecursionIsPresent(String filename) throws IOException {
        if(filenames.search(filename) != -1) {
            return true;
        }

        filenames.add(filename);
        File file = new File(filename);

        List<String> lines = Files.readAllLines(file.toPath());
        for (String l : lines) {
            if (l.contains("execute_script")) {
                return checkRecursionIsPresent(l.split(" ")[1]);
            }
        }

        return false;
    }
}
