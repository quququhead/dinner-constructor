package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    System.out.println();
                    break;
                case "2":
                    generateDishCombo();
                    System.out.println();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Вы ввели некорректное значние. Ваше значние: " + command);
                    System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.checkIsEmpty()){
            System.out.println("Доступных блюд для заказа - нет. Попробуйте добавить блюдо с помощью команды: 1");
            return;
        }
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> dishesType = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                dishesType.add(nextItem);
            } else {
                System.out.println("Типа блюда " + nextItem + " нет! Введите существующий!");
                System.out.println("Доступные типы:");
                for (String type : dc.dishes.keySet()) {
                    System.out.println(type);
                }
            }
            nextItem = scanner.nextLine();
        }
        if (dishesType.isEmpty()) {
            System.out.println("Вы ввели некорректное значение - пустота.");
            return;
        }
        dc.generateDishCombo(numberOfCombos, dishesType);
    }
}