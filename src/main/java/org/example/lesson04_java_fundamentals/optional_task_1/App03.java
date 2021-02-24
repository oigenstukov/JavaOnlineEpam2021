package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 */
public class App03 {
    public static void main(String[] args) {
        int avg = avgLength(args);
        System.out.println(avg);
        System.out.println("Length less than average:");
        lessAvg(avg, args).forEach(System.out::println);

        System.out.println("Length more than average:");
        moreAvg(avg, args).forEach(System.out::println);

    }

    static int avgLength(String[] args) {
        int sum = 0;
        for (String s : args) {
            sum += s.length();
        }
        return sum/args.length;
    }

    static List<String> lessAvg(int avg, String[] args) {
        List<String> res = new ArrayList<>();
        for (String s : args) {
            if (s.length() <= avg) {
                res.add(s);
            }
        }
        return res;
    }

    static List<String> moreAvg(int avg, String[] args) {
        List<String> res = new ArrayList<>();
        for (String s : args) {
            if (s.length() > avg) {
                res.add(s);
            }
        }
        return res;
    }
}
