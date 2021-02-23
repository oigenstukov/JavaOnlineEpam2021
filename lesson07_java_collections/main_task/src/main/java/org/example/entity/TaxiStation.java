package org.example.entity;

import java.util.List;

public class TaxiStation {
    private String name;
    private List<Auto> autoList;
    private int price;
    private int budget;

    public TaxiStation() {
    }

    public TaxiStation(String name, List<Auto> autoList) {
        this.name = name;
        this.autoList = autoList;
    }

    public TaxiStation(String name, List<Auto> autoList, int budget) {
        this.name = name;
        this.autoList = autoList;
        this.budget = budget;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Auto> getAutoList() {
        return autoList;
    }

    public int getPrice() {
        int price = 0;
        for (Auto a : autoList) {
            price += a.getPrice();
        }
        return price;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Taxi station '" + name +
                "'\nCar list: " +
                autoList.toString()
                        .replace("[", "")
                        .replace("]", "");
    }
}
