package org.example;

/**
 * 4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат
 * на консоль.
 */
public class App04 {
    public static void main(String[] args) {

        System.out.println(sum(toInts(args)));
        System.out.println(mult(toInts(args)));
    }

    static int[] toInts(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    static int sum(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum;
    }

    static int mult(int[] ints) {
        int mult = 1;
        for (int anInt : ints) {
            mult *= anInt;
        }
        return mult;
    }

}
