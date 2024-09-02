package org.example.salary;

public class PartTimer implements CalcSalary{

    private int hourPay;
    private int time;
    private String name;

    public PartTimer(String name,int hourPay, int time) {
        this.hourPay = hourPay;
        this.time = time;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calcMonth() {
        return hourPay * time;
    }
}
