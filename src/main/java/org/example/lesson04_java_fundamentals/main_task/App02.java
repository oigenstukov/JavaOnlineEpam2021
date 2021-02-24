package org.example;

/**
 * 2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */
public class App02 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Enter some argument");
            System.exit(1);
        } else {
            for (int i = args.length - 1; i >= 0; i--) {
                System.out.print(args[i] + " ");
            }
        }
    }
}
