package com.golovanova.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 */
public class Worker implements Comparable<Worker> {
    private static Integer idSequence = 0;

    /**
     * @param workers
     */
    public static void updateIdSequence(Collection<Worker> workers) {
        Integer currentMaxId = workers.stream()
                .mapToInt(Worker::getId)
                .max()
                .orElse(0);

        if (currentMaxId > idSequence) {
            idSequence = currentMaxId;
        }
    }

    /**
     * @return id
     */
    private static Integer generateId() {
        idSequence++;
        return idSequence;
    }

    //Поле не может быть null, Значение поля должно быть больше 0,
    private Integer id;
    // Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonIgnore
    private ZonedDateTime creationDate = ZonedDateTime.now(); //Поле не может быть null,
    // Значение этого поля должно генерироваться автоматически
    private Float salary; //Поле может быть null, Значение поля должно быть больше 0
    @JsonIgnore
    private LocalDate startDate = LocalDate.now(); //Поле не может быть null
    @NotNull
    private Position position; //Поле может быть null
    private Status status; //Поле не может быть null
    private Organization organization; //Поле может быть null
    @JsonIgnore
    private Integer minId = 1;
    @JsonIgnore
    private Integer minSalary = 1;

    public Worker() {
    }

    /**
     * @param name
     * @param coordinates
     * @param salary
     * @param position
     * @param status
     * @param organization
     */
    public Worker(@NotNull String name, @NotNull Coordinates coordinates,
                  @NotNull Float salary, @NotNull Position position, @NotNull Status status,
                  @NotNull Organization organization) {
        this.id = generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.salary = Math.max(salary, minSalary);
        this.startDate = LocalDate.now();
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    /**
     * @param id
     * @param name
     * @param coordinates
     * @param salary
     * @param position
     * @param status
     * @param organization
     */
    public Worker(@NotNull Integer id, @NotNull String name, @NotNull Coordinates coordinates,
                  @NotNull Float salary, @NotNull Position position, @NotNull Status status,
                  @NotNull Organization organization) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.salary = Math.max(salary, minSalary);
        this.startDate = LocalDate.now();
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    /**
     * @return id
     */

    public Integer getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return creationTime
     */
    @JsonIgnore
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return salary
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * @return startDate
     */
    @JsonIgnore
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return organization
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @param creationDate
     */
    @JsonIgnore
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @param salary
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }

    /**
     * @param startDate
     */
    @JsonIgnore
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param organization
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * @param o
     * @return equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(name, worker.name) &&
                Objects.equals(coordinates, worker.coordinates) &&
                Objects.equals(creationDate, worker.creationDate) &&
                Objects.equals(salary, worker.salary) &&
                Objects.equals(startDate, worker.startDate) &&
                position == worker.position &&
                status == worker.status &&
                Objects.equals(organization, worker.organization);
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary,
                startDate, position, status, organization);
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        String info = "";
        info += "Worker №" + id;
        info += " (added " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Name: " + name;
        info += "\n Coordinates: " + coordinates;
        info += "\n Salary: " + salary;
        info += "\n started work: " + startDate;
        info += "\n Position: " + position; //??
        info += "\n Status: " + status;
        info += "\n Organization: " + organization;
        return info;
    }

    /**
     * @param w
     * @return compared param
     */
    @Override
    public int compareTo(Worker w) {
        Comparator<Status> statusComparator = Status.getComparator();
        Comparator<Position> positionComparator = Position.getComparator();

        int compareStatus = statusComparator.compare(getStatus(), w.getStatus());
        int comparePosition = positionComparator.compare(getPosition(), w.getPosition());

        if (compareStatus != 0) {
            return compareStatus;
        }

        return comparePosition;
    }
}