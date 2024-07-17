package org.example.salary;

public class Freelancer implements CalcSalary {

    private String name;

    private int month;

    public Freelancer(String name, int month) {
        this.name = name;
        this.month = month;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calcMonth() {
        return month * 0.967;
    }
}