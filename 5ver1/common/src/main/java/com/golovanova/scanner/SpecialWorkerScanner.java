package com.golovanova.scanner;

import com.golovanova.data.DataSource;
import com.golovanova.model.*;


import java.util.InputMismatchException;

public class SpecialWorkerScanner {
    private final DataSource dataSource;

    private EnumScanner<Position> positionScanner;
    private EnumScanner<Status> statusScanner;
    private OrganisationScanner organizationScanner;
    private CoordinatesScanner coordinatesScanner;

    public SpecialWorkerScanner(DataSource dataSource) {
        this.dataSource = dataSource;
        positionScanner = new EnumScanner<>(dataSource, Position.class);
        statusScanner = new EnumScanner<>(dataSource, Status.class);
        organizationScanner = new OrganisationScanner(dataSource);
        coordinatesScanner = new CoordinatesScanner(dataSource);
    }


    public Worker scan() {
        System.out.println("Input data of worker: ");
        System.out.println("Input id: ");
        Integer id = dataSource.nextInt();
        System.out.println("Input name: ");
        String name = dataSource.nextLine();
        Coordinates coordinates = null;
        while (coordinates == null) {
            try {
                coordinates = coordinatesScanner.scanCoordinates();
            } catch (Exception e) {
                System.err.println("Incorrect input! Try again.");
            }
        }
        System.out.println("Input salary: ");
        float salary = 0f;
        while (salary == 0f) {
            try {
                salary = dataSource.nextFloat();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect input! Try again.");
            }
        }
        Status status = null;
        while (status == null) {
            try {
                status = statusScanner.scanEnum();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Status!");
            }
        }
        Position position = null;
        while (position == null) {
            try {
                position = positionScanner.scanEnum();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Position!");
            }
        }
        Organization organization = null;
        while (organization == null) {
            try {
                organization = organizationScanner.scan();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Organization!");
            }
        }


        Worker worker = new Worker(
                id,
                name,
                coordinates,
                salary,
                position,
                status,
                organization);

        return worker;
    }
}
