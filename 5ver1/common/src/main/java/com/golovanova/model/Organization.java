package com.golovanova.model;



import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Organization {
    private String name;
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private final int minEmployeesCount = 1;

    /**
     * @param employeesCount
     * @param type
     * @param name
     */
    public Organization(@NotNull Long employeesCount, @NotNull OrganizationType type, @NotNull String name) {
        this.employeesCount = Math.max(minEmployeesCount, employeesCount);
        this.type = type;
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return employeesCount
     */
    public Long getEmployeesCount() {
        return employeesCount;
    }

    /**
     * @return OrganizationType
     */
    public OrganizationType getType() {
        return type;
    }

    /**
     * @param o
     * @return equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(employeesCount, that.employeesCount) &&
                type == that.type;
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeesCount, type);
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Organization: " +
                "name: " + name +
                ", number of workers: " + employeesCount +
                ", type of organisation: " + type;
    }
}
