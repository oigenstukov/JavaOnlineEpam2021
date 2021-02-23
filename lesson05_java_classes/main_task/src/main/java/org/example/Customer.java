package org.example;

import java.util.Objects;

/**
 * 2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
 */
public class Customer {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private Address address;
    private long cardNumber;
    private long accountNumber;

    public Customer() {
    }

    public Customer(int id, String surname, Address address, long cardNumber) {
        this.id = id;
        this.surname = surname;
        this.address = address;
        this.cardNumber = cardNumber;
    }

    public Customer(int id, String surname, String name, String middleName, Address address, long cardNumber,
                    long accountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && cardNumber == customer.cardNumber && accountNumber == customer.accountNumber && Objects.equals(surname, customer.surname) && Objects.equals(name, customer.name) && Objects.equals(middleName, customer.middleName) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, middleName, address, cardNumber, accountNumber);
    }

    @Override
    public String toString() {
        if (middleName == null ||
                name == null ||
                accountNumber == 0L) {
            return id +
                    " " + surname +
                    ", address: " + address +
                    ", card number: " + cardNumber +
                    ", account number: null";
        }

        return id +
                " " + name +
                " " + middleName +
                " " + surname +
                ", address: " + address +
                ", card number: " + cardNumber +
                ", account number: " + accountNumber;
    }
}

