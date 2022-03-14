package com.golovanova.scanner;

import com.golovanova.data.ConsoleDataSource;
import com.golovanova.data.DataSource;

import java.util.Scanner;

public class EnumScanner<T extends Enum> {
    private final DataSource dataSource;
    private final Class<T> clazz;

    public EnumScanner(Class<T> clazz) {
        this.clazz = clazz;
        dataSource = new ConsoleDataSource(new Scanner(System.in));
    }

    public EnumScanner(DataSource dataSource, Class<T> clazz) {
        this.dataSource = dataSource;
        this.clazz = clazz;
    }

    public <T> T scanEnum() throws Exception {
        T[] enumConstants = (T[]) clazz.getEnumConstants();
        System.out.println("Input " + clazz.getSimpleName() + ": ");
        String input = dataSource.nextLine();

        for (T t : enumConstants) {
            if(input.toUpperCase().equals(t.toString().toUpperCase())) {
                return t;
            }
        }

        throw new Exception("Не получилось сканивать ENUM " + clazz.getSimpleName() + " из входных данных: " + input);
    }
}
