package org.example;

import java.util.Objects;

public class Address {
    private int house;
    private String street;
    private int room;
    private String city;
    private String index;
    private String country;

    public Address() {
    }

    public Address(int house, String street, int room, String city, String index, String country) {
        this.house = house;
        this.street = street;
        this.room = room;
        this.city = city;
        this.index = index;
        this.country = country;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return house == address.house && room == address.room && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(index, address.index) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, street, room, city, index, country);
    }

    @Override
    public String toString() {
        return house +
                " " + street.toUpperCase() +
                " st " + room +
                " " + city.toUpperCase() +
                " " + index.toUpperCase() +
                " " + country.toUpperCase();
    }
}
