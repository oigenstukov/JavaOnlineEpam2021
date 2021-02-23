package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Создать массив объектов. Вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
 */
public class App {
    public static void main(String[] args) {
        Address[] addrs = {
                new Address(4, "Brook", 13, "London", "W1K 4HH", "England"),
                new Address(34, "Carrera", 2, "Genova", "632067", "Columbia"),
                new Address(17, "Keari", 1, "Burlington", "VT 05401", "US")
        };
        Customer[] customers = {
                new Customer(1,"Bundy", "Ted", "Robert", addrs[2],
                        402600049876612L, 100003483L),
                new Customer(2,"Garavito", addrs[1], 402600049876432L),
                new Customer(3,"Shipman", addrs[0], 402600049876689L),
                new Customer(4,"Wuornos", addrs[2], 402600049877659L),
                new Customer(5,"Manson", addrs[2], 402600049871612L)
        };

        Arrays.sort(customers, Comparator.comparing(Customer::getSurname));
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
        System.out.println();

        Customer[] customersInCardNum = showCustomersInCardNum(customers,
                402600049876167L, 402600049876767L);
        for (Customer customer : customersInCardNum) {
            System.out.println(customer);
        }

    }

    static Customer[] showCustomersInCardNum(Customer[] customers, long cardFrom, long cardTo) {
        List<Customer> res = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCardNumber() > cardFrom &&
                    customer.getCardNumber() < cardTo) {
                res.add(customer);
            }
        }
        return res.toArray(new Customer[0]);
    }
}
