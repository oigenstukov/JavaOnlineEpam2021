package org.example;

/**
 * 3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */
public class App03 {
    public static void main(String[] args) {
        int[] a = {1, 12, 43, 590, 2};
        for (int i : a) {
            System.out.println(i);
        }
        for (int i : a) {
            System.out.print(i);
        }
    }
}
