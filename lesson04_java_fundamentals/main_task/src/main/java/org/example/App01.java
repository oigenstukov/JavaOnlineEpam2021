package org.example;

/**
 * 1.     Приветствовать любого пользователя при вводе его имени через командную строку.
 */
public class App01 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Enter your name.");
            System.exit(1);
        }
        System.out.println("Hello, " + args[0] + "!");
    }
}
