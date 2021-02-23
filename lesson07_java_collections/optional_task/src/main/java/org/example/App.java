package org.example;

import java.io.*;
import java.util.*;

/**
 * Optional Task
 * Задания из раздела "Additional Unit" являются вспомогательными для курса "Коллекции". В процессе изучения
 * разделов курса рекомендуется решить 3-5 задач из списка.
 * <p>
 * 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 * <p>
 * 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
 * <p>
 * 3.   Создать список из элементов каталога и его подкаталогов.
 * <p>
 * 4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 * <p>
 * 5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а
 * положительные — в начало списка.
 * <p>
 * 6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из
 * класса Collections.
 * <p>
 * 7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок.
 * Использовать стек.
 * <p>
 * 8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром
 * букв, считать одинаковыми. Использовать класс HashSet.
 */
public class App {
    static File fName = new File("stairway.txt");
    static List<String> strings = new ArrayList<>();
    static ArrayList<File> dirList = new ArrayList<>();

    public static void main(String[] args) {

        /*
            1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
         */
        try (FileReader reader = new FileReader(fName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                strings.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(fName, false)) {
            for (int i = strings.size() - 1; i >= 0; i--) {
                writer.write(strings.get(i));
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*
            2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
         */
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> chList = new LinkedList<>();
        System.out.println("Enter the number: ");
        char[] chars = scanner.nextLine().toCharArray();
        for (char aChar : chars) {
            chList.add(aChar);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chList.removeLast();
        }
        String str = new String(chars);
        System.out.println(str);

        /*
            3.   Создать список из элементов каталога и его подкаталогов.
         */
        File myDir = new File("src");
        try {
            dirList = getDirList(myDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        dirList.forEach(s -> System.out.println(s.getPath()));

        /*
            4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
         */
        strings.clear();
        System.out.println("\nStrings by length:");
        try (FileReader reader = new FileReader(fName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                strings.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("I/O exception " + e.getMessage());
        }
        strings.sort(Comparator.comparing(String::length));
        strings.forEach(System.out::println);

        /*
            5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а
         положительные — в начало списка.
         */
        Integer[] intArray = {-1, 2, -3, 2, 1, -4};
        List<Integer> intList = new ArrayList<>();
        Collections.addAll(intList, intArray);

        intList.forEach(System.out::print);
        System.out.println();
        int replaced = 0;
        for (int i = 0; i < intList.size() - replaced; i++) {
            if (intList.get(i) < 0) {
                intList.add(intList.get(i));
                intList.remove(i);
                replaced++;
            }
        }
        intList.forEach(System.out::print);

        /*
            6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод
             sort() из класса Collections.
         */
        strings.clear();
        System.out.println("\nStrings sorted:");
        try (FileReader reader = new FileReader(fName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                strings.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("I/O exception " + e.getMessage());
        }
        strings.sort(Comparator.comparing(String::toString));
        strings.forEach(System.out::println);

        /*
            8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся
            только регистром букв, считать одинаковыми. Использовать класс HashSet.
         */
        HashSet<String> hashSet = new HashSet<>();
        System.out.println("Words from file: ");
        try (FileReader reader = new FileReader(fName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNext()) {
                hashSet.add(sc.next());
            }
        } catch (IOException e) {
            System.out.println("I/O exception" + e.getMessage());
        }
        hashSet.stream()
                .sorted()
                .forEach(System.out::println);

    }


    public static ArrayList<File> getDirList(File file) throws IOException {
        File[] currentDir = file.listFiles();
        if (currentDir != null) {
            for (File f : currentDir) {
                if (f.isDirectory()) {
                    dirList.add(f);
                    getDirList(f);
                }
            }
        } else {
            System.out.println("currentDir is null");
        }
        return dirList;
    }

}
