package com.golovanova.data;

import java.util.Arrays;
import java.util.List;

public class LinesDataSource implements DataSource {
    private final List<String> data;
    private int cursor = 0;

    public LinesDataSource(List<String> data) {
        this.data = data;
    }

    public LinesDataSource(String string) {
        this.data = Arrays.asList(string.split("\n"));
    }

    public boolean endOfData() {
        return cursor >= data.size();
    }

    @Override
    public String nextLine() {
        String value = data.get(cursor);
        cursor++;
        return value;
    }

    @Override
    public Integer nextInt() {
        String str = data.get(cursor);
        Integer value = Integer.parseInt(str);
        cursor++;
        return value;
    }

    @Override
    public Float nextFloat() {
        String str = data.get(cursor);
        Float value = Float.parseFloat(str);
        cursor++;
        return value;
    }

    @Override
    public Double nextDouble() {
        String str = data.get(cursor);
        Double value = Double.parseDouble(str);
        cursor++;
        return value;
    }

    @Override
    public Long nextLong() {
        String str = data.get(cursor);
        Long value = Long.parseLong(str);
        cursor++;
        return value;
    }
}
