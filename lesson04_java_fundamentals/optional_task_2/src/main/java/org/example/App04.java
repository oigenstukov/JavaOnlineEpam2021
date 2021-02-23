package org.example;

import static org.example.App01.mFilling;
import static org.example.App01.mToString;

/**
 * 4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
 */
public class App04 {
    public static void main(String[] args) {
        int mSize = Integer.parseInt(args[0]);
        int M = 10;
        int[][] matrix = mFilling(mSize, M);
        System.out.println(mToString(matrix));
        int maxEl = maxElem(matrix);

        System.out.println(mToString(clearRowColWithMaxElem(matrix, maxEl)));
    }

    static int maxElem(int[][] m) {
        int max = 0;
        for (int[] ints : m) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }

    static int[][] clearRow(int[][] m, int rowNum, int max) {
        for (int i = 0; i < m.length; i++) {
            if (m[rowNum][i] != max) {
                m[rowNum][i] = 0;
            }
        }
        return m;
    }

    static int[][] clearCol(int[][] m, int colNum, int max) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][colNum] != max) {
                m[i][colNum] = 0;
            }
        }
        return m;
    }

    static int[][] clearRowCol(int[][] m, int row, int col, int max) {
        return clearRow(clearCol(m, col, max), row, max);
    }

    static int[][] clearRowColWithMaxElem(int[][] m, int max) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == max) {
                    m = clearRowCol(m, i, j, max);
                }
            }
        }
        return m;
    }
}
