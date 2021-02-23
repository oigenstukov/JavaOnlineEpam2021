package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * 4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
 */
public class App04 {
    public static void main(String[] args) {
        int[] nums = toInts(args);
        System.out.println("Answer: " + minUniqueDigits(nums));

    }

    static int[] toInts(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    static int minUniqueDigits(int[] nums) {
        int minNumOfDigits = numOfUniqueDigits(nums[0]);
        int sought = nums[0];

        for (int a : nums) {
            if (numOfUniqueDigits(a) < minNumOfDigits) {
                minNumOfDigits = numOfUniqueDigits(a);
                sought = a;
            }
        }
        return sought;
    }

    static int numOfUniqueDigits(int num) {
        Set<Integer> digits = new HashSet<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits.size();
    }
}
