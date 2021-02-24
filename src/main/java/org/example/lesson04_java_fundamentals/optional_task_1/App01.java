package org.example;

/**
 * 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 */
public class App01 {
    public static void main(String[] args) {
        System.out.println(shortest(args));
        System.out.println(longest(args));
    }

    static String shortest(String[] args) {
        String shortest = args[0];
        for (String arg : args) {
            if (arg.length() < shortest.length()) {
                shortest = arg;
            }
        }
        return shortest;
    }

    static String longest(String[] args) {
        String longest = args[0];
        for (String arg : args) {
            if (arg.length() > longest.length()) {
                longest = arg;
            }
        }
        return longest;
    }
}