package com.golovanova.scanner;

import com.golovanova.data.DataSource;
import com.golovanova.model.Coordinates;

public class CoordinatesScanner {
    private final DataSource dataSource;

    public CoordinatesScanner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Coordinates scanCoordinates() {
        System.out.println("Input coordinates: ");
        System.out.println("Input x: ");
        Double x = dataSource.nextDouble();
        System.out.println("Input y: ");
        Float y = dataSource.nextFloat();

        return new Coordinates(x, y);
    }
}
