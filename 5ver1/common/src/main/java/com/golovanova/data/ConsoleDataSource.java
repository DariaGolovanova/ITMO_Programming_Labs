package com.golovanova.data;

import java.util.Scanner;

public class ConsoleDataSource implements DataSource {
    private final Scanner scanner;

    public ConsoleDataSource(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public Integer nextInt() {
        return new Scanner(System.in).nextInt();
    }

    @Override
    public Float nextFloat() {
        return new Scanner(System.in).nextFloat();
    }

    @Override
    public Double nextDouble() {
        return new Scanner(System.in).nextDouble();
    }

    @Override
    public Long nextLong() {
        return new Scanner(System.in).nextLong();
    }
}
