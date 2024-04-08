package task4.models;

import java.util.Objects;

public abstract class Employee {
    private Integer serviceNumber;
    private String phoneNumber;
    private String name;
    private Integer stage;

    public Employee(Integer serviceNumber, String phoneNumber, String name, Integer stage) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public Integer getStage() {
        return stage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getServiceNumber() {
        return serviceNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "serviceNumber=" + serviceNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", workedOut=" + stage +
                '}';
    }
}
