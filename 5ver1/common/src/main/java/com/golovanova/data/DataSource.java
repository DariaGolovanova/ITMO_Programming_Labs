package com.golovanova.data;

public interface DataSource {
    String nextLine();
    Integer nextInt();
    Float nextFloat();
    Double nextDouble();
    Long nextLong();
}
