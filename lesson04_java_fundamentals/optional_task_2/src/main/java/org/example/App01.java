package org.example;

/**
 * 1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 */
public class App01 {
    public static void main(String[] args) {
        int mSize = Integer.parseInt(args[0]);
        int M = 10;
        int a = 2;
        int[][] matrix = mFilling(mSize, M);

        System.out.println(mToString(rowOrdered(matrix, a, false)));
        System.out.println(mToString(colOrdered(matrix, a)));
    }

    static int[][] mFilling(int size, int bound) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * (bound + 1 + bound) - bound);
            }
        }
        return matrix;
    }

    static int[][] rowOrdered(int[][] m, int colNum, boolean isRotated) {
        int[] temp;
        int[][] m1 = m.clone();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < m1.length - 1; i++) {
                if (!isRotated) {
                    if (m1[i][colNum] > m1[i + 1][colNum]) {
                        temp = m1[i + 1];
                        m1[i + 1] = m1[i];
                        m1[i] = temp;
                        isSorted = false;
                    }
                } else {
                    if (m1[i][colNum] < m1[i + 1][colNum]) {
                        temp = m1[i + 1];
                        m1[i + 1] = m1[i];
                        m1[i] = temp;
                        isSorted = false;
                    }
                }
            }
        }
        return m1;
    }

    static int[][] colOrdered(int[][] m, int rowNum) {
        return rotateMatrix(rowOrdered(rotateMatrix(m, false), rowNum, true), true);
    }

    static int[][] rotateMatrix(int[][] m, boolean direction) {
        int[][] res = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (direction) { // to the right
                    res[i][j] = m[m.length - j - 1][i];
                } else {
                    res[i][j] = m[j][m[i].length - i - 1];
                }
            }
        }
        return res;
    }

    static String mToString(int[][] m) {
        StringBuilder res = new StringBuilder();

        for (int[] a : m) {
            for (int a1 : a) {
                res.append(a1).append("\t\t");
            }
            res.append("\n");
        }

        return res.toString();
    }
}
