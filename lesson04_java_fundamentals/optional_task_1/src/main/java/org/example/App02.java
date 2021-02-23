package org.example;

import java.util.Arrays;

/**
 * 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
 */
public class App02 {
    public static void main(String[] args) {
        Arrays.sort(args);

        for (String s: args) {
            System.out.print(s + " ");
        }
    }
}

