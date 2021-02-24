package org.example.entity;

import org.example.enums.Type;

import java.util.Objects;

public class Auto {
    private int id;
    private String model;
    private int price;
    private double consumption;
    private int speed;
    private Type type;

    public Auto() {
    }

    public Auto(int id, int price, double consumption, int speed, Type type) {
        this.id = id;
        this.model = "N/A";
        this.price = price;
        this.consumption = consumption;
        this.speed = speed;
        this.type = type;
    }

    public Auto(int id, String model, int price, double consumption, int speed, Type type) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.consumption = consumption;
        this.speed = speed;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id && price == auto.price && Double.compare(auto.consumption, consumption) == 0 && speed == auto.speed && Objects.equals(model, auto.model) && type == auto.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, price, consumption, speed, type);
    }

    @Override
    public String toString() {
        return "\nAuto #" + id +
                "\tmodel: '" + model + '\'' +
                "\tprice:  " + price +
                "\tfuel consumption: " + consumption + "\tlitres per 100 km" +
                "\tmax speed: " + speed +
                "\tcar class: " + type;
    }
}
