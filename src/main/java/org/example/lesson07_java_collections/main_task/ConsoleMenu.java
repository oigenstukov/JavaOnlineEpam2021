package org.example;

import org.example.almostExceptions.EmptyCarListException;
import org.example.almostExceptions.NotEnoughMoneyException;
import org.example.almostExceptions.WrongItemException;
import org.example.almostExceptions.WrongLengthException;
import org.example.entity.Auto;
import org.example.entity.TaxiStation;
import org.example.enums.Type;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ConsoleMenu {
    static Scanner sc = new Scanner(System.in);
    static boolean valid = true;
    static TaxiStation ts = new TaxiStation();
    static List<Auto> autoList = new ArrayList<>();
    static int id = 1;

    private static int intChecker() {
        int a = -1;
        do {
            valid = true;
            try {
                a = Integer.parseInt(sc.next());
            } catch (IllegalArgumentException e) {
                WrongItemException.message();
                valid = false;
            }
        } while (!valid);
        return a;
    }

    public static void start() throws InterruptedException {
        while (true){
            System.out.println("1. Create new taxi station;");
            System.out.println("2. Show taxi station;");
            System.out.println("3. Operations with taxi station;");
            System.out.println("0. Exit program.");
            int a = intChecker();
            switch (a) {
                case 1:
                    createTaxiStation();
                    break;
                case 2:
                    showTaxiStation();
                    TimeUnit.MILLISECONDS.sleep(10);
                    // otherwise the loop runs faster than an "exception" is thrown
                    break;
                case 3:
                    if (autoList.isEmpty()) {
                        EmptyCarListException.message();
                        break;
                    }
                    operationsMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void createTaxiStation() throws InterruptedException {
        while (true) {
            System.out.println("Create a new taxi station!");
            System.out.println("1. Create by yourself;");
            System.out.println("2. Create default;");
            System.out.println("0. Back.");
            int a = intChecker();
            switch (a) {
                case 1:
                    createByYourself();
                    break;
                case 2:
                    createDefault();
                    System.out.println("Taxi station created!");
                    return;
                case 0:
                    return;
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void showTaxiStation() {
        if (autoList.isEmpty()) {
            EmptyCarListException.message();
            return;
        }
        System.out.println(ts.toString());
    }

    private static void operationsMenu() {
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Calculate the cost of station;");
            System.out.println("2. Sort cars;");
            System.out.println("3. Cars with specified range of speed;");
            System.out.println("0. Back.");
            int a = intChecker();
            switch (a) {
                case 1:
                    System.out.println("Total price of all cars: " + ts.getPrice());
                    break;
                case 2:
                    sortMenu();
                    break;
                case 3:
                    carOnSpeedRangeMenu();
                    break;
                case 0:
                    return;
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void sortMenu() {
        while (true) {
            System.out.println("Sort by...");
            System.out.println("1. Id;");
            System.out.println("2. Model;");
            System.out.println("3. Price;");
            System.out.println("4. Fuel consumption;");
            System.out.println("5. Max speed;");
            System.out.println("6. Car class;");
            System.out.println("0. Back.");
            int a = intChecker();
            switch (a) {
                case 1:
                    sortById();
                    break;
                case 2:
                    sortByModel();
                    break;
                case 3:
                    sortByPrice();
                    break;
                case 4:
                    sortByFuel();
                    break;
                case 5:
                    sortBySpeed();
                    break;
                case 6:
                    sortByClass();
                    break;
                case 0:
                    return;
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void carOnSpeedRangeMenu() {
        while (true) {
            System.out.println("Choose speed range.");
            System.out.print("From: ");
            int a = intChecker();
            System.out.print("To: ");
            int b = intChecker();
            if (a > b) {
                WrongItemException.message();
            } else {
                carOnSpeedRange(a, b);
                break;
            }
        }
    }

    private static void carOnSpeedRange(int from, int to) {
        System.out.printf("Cars with max speed from %dkm/h to %dkm/h:", from, to);
        autoList.stream()
                .filter(auto -> auto.getSpeed() > from)
                .filter(auto -> auto.getSpeed() < to)
                .forEach(System.out::println);
    }

    private static void sortById() {
        autoList.sort(Comparator.comparing(Auto::getId));
        System.out.println("Sorted by id.");
        showCars();
    }

    private static void sortByModel() {
        autoList.sort(Comparator.comparing(Auto::getModel));
        System.out.println("Sorted by model.");
        showCars();
    }

    private static void sortByPrice() {
        autoList.sort(Comparator.comparing(Auto::getPrice));
        System.out.println("Sorted by price.");
        showCars();
    }

    private static void sortByFuel() {
        autoList.sort(Comparator.comparing(Auto::getConsumption));
        System.out.println("Sorted by fuel consumption.");
        showCars();
    }

    private static void sortBySpeed() {
        autoList.sort(Comparator.comparing(Auto::getSpeed));
        System.out.println("Sorted by max speed.");
        showCars();
    }

    private static void sortByClass() {
        autoList.sort(Comparator.comparing(Auto::getType));
        System.out.println("Sorted by car class.");
        showCars();
    }

    private static void createByYourself() throws InterruptedException {
        autoList.clear();
        ts = new TaxiStation("", autoList);
        while (true) {
            System.out.println("Create your own taxi station!");
            System.out.println("1. Choose your future station name;");
            System.out.println("2. Choose your budget;");
            System.out.println("3. Choose cars for your station;");
            System.out.println("0. Main menu");
            int a = intChecker();
            switch (a) {
                case 1:
                    chooseName();
                    break;
                case 2:
                    chooseBudget();
                    break;
                case 3:
                    if (ts.getBudget() < 7000) {
                        NotEnoughMoneyException.message();
                        break;
                    }
                    chooseCars();
                    break;
                case 0:
                    start();
                    return;
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void createDefault() {
        autoList.clear();
        autoList.add(new Auto(id++, "Mercedes-Benz", 27000, 8.8, 270, Type.BUSINESS));
        autoList.add(new Auto(id++, "Skoda Rapid", 7000, 4.6, 190, Type.ECONOMY));
        autoList.add(new Auto(id++, "Nissan Almera", 8000, 4.7, 200, Type.ECONOMY));
        autoList.add(new Auto(id++, "Iveco Daily", 18000, 10.4, 150, Type.CARGO));
        ts = new TaxiStation("Default station", autoList);
    }

    private static void chooseName() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of your taxi station(3 to 15 letters):");
            String name = scanner.nextLine();
            if (name.length() > 2 && name.length() < 16) {
                ts.setName(name);
                System.out.println("Your station name: " + ts.getName());
                break;
            } else {
                WrongLengthException.message();
            }
        }
    }

    private static void chooseBudget() {
        while (true) {
            System.out.println("Enter your budget(one car costs from 7k to 30k):");
            ts.setBudget(intChecker());
            if (ts.getBudget() > 0) {
                System.out.println("Your budget: " + ts.getBudget());
                break;
            } else {
                WrongItemException.message();
            }
        }
    }

    private static void chooseCars() {
        while (true) {
            System.out.println("Choose cars for your new Taxi station.");
            System.out.println("1. Add car;");
            System.out.println("2. Delete car;");
            System.out.println("3. Show cars;");
            System.out.println("0. Back.");
            int a = intChecker();
            switch (a) {
                case 1:
                    addCarMenu();
                    break;
                case 2:
                    if (autoList.size() < 1) {
                        EmptyCarListException.message();
                        break;
                    }
                    deleteCarMenu();
                    break;
                case 3:
                    showCars();
                    break;
                case 0:
                    return;
                default:
                    WrongItemException.message();
            }
        }
    }

    private static void addCarMenu() {
        while (true) {
            System.out.println("Your budget: " + ts.getBudget());
            if (ts.getBudget() < 7000) {
                NotEnoughMoneyException.message();
                break;
            }
            System.out.println("1. 27000 Mercedes-Benz;");
            System.out.println("2. 32000 BMW 5;");

            System.out.println("3. 7000 Skoda Rapid;");
            System.out.println("4. 8000 Nissan Almera;");
            System.out.println("5. 9000 Volkswagen Polo;");

            System.out.println("6. 11000 Volkswagen Passat;");
            System.out.println("7. 10000 Toyota Camry;");

            System.out.println("8. 18000 Iveco Daily;");
            System.out.println("9. 24000 Mercedes Sprinter;");

            System.out.println("0. Back.");

            int a = intChecker();
            if (a > 0 && a < 10) {
                addCar(a);
            } else if (a == 0) {
                break;
            } else {
                WrongItemException.message();
            }
        }
    }

    private static void deleteCarMenu() {
        while (true) {
            System.out.println("Cars in your station: " + autoList.size());
            System.out.println("Enter id of car, to delete it(0. to return):");
            int a = intChecker();
            if (a > 0 && a <= autoList.size()) {
                deleteCar(a);
            } else if (a == 0) {
                return;
            } else {
                WrongItemException.message();
            }
        }
    }

    private static void showCars() {
        System.out.println(autoList.toString()
                .replace("[", "")
                .replace("]", ""));
    }

    private static void addCar(int a) {
        switch (a) {
            case 1:
                if (ts.getBudget() >= 27000) {
                    autoList.add(new Auto(id++, "Mercedes-Benz", 27000, 8.8, 270,
                            Type.BUSINESS));
                    ts.setBudget(ts.getBudget() - 27000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 2:
                if (ts.getBudget() >= 32000) {
                    autoList.add(new Auto(id++, "BMW 5", 32000, 9.6, 290,
                            Type.BUSINESS));
                    ts.setBudget(ts.getBudget() - 32000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 3:
                if (ts.getBudget() >= 7000) {
                    autoList.add(new Auto(id++, "Skoda Rapid", 7000, 4.6, 190,
                            Type.ECONOMY));
                    ts.setBudget(ts.getBudget() - 7000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 4:
                if (ts.getBudget() >= 8000) {
                    autoList.add(new Auto(id++, "Nissan Almera", 8000, 4.7, 200,
                            Type.ECONOMY));
                    ts.setBudget(ts.getBudget() - 8000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 5:
                if (ts.getBudget() >= 9000) {
                    autoList.add(new Auto(id++, "Volkswagen Polo", 9000, 4.9, 210,
                            Type.ECONOMY));
                    ts.setBudget(ts.getBudget() - 9000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 6:
                if (ts.getBudget() >= 11000) {
                    autoList.add(new Auto(id++, "Volkswagen Passat", 11000, 5.2, 230,
                            Type.COMFORT));
                    ts.setBudget(ts.getBudget() - 11000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 7:
                if (ts.getBudget() >= 10000) {
                    autoList.add(new Auto(id++, "Toyota Camry", 10000, 5.0, 220,
                            Type.COMFORT));
                    ts.setBudget(ts.getBudget() - 10000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 8:
                if (ts.getBudget() >= 18000) {
                    autoList.add(new Auto(id++, "Iveco Daily", 18000, 10.4, 150,
                            Type.CARGO));
                    ts.setBudget(ts.getBudget() - 18000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
            case 9:
                if (ts.getBudget() >= 24000) {
                    autoList.add(new Auto(id++, "Mercedes Sprinter", 24000, 12.0, 180,
                            Type.CARGO));
                    ts.setBudget(ts.getBudget() - 24000);
                } else {
                    NotEnoughMoneyException.message();
                }
                break;
        }
    }

    private static void deleteCar(int a) {
        sortById();
        ts.setBudget(ts.getBudget() + autoList.get(a - 1).getPrice());
        autoList.remove(a - 1);
        id--;
        for (int i = a; i <= autoList.size(); i++) {
            autoList.get(i - 1).setId(i);
        }
    }
}
