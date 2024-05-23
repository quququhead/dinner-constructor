package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes;

    DinnerConstructor() {
        dishes = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        if (dishType.isEmpty() || dishName.isEmpty() || dishName.equals(" ") || dishType.equals(" ")) {
            System.out.println("Вы ввели некорректные данные. Проверьте правильность ввода типа или названия блюда!");
            return;
        }
        ArrayList<String> dish;
        if (dishes.containsKey(dishType)) {
            dish = dishes.get(dishType);
            if (dish.contains(dishName)) {
                System.out.println("Это блюдо (" + dishName
                        + ") уже присутствует в этом типе (" + dishType + ")!");
                return;
            }
        } else {
            dish = new ArrayList<>();
        }
        dish.add(dishName);
        dishes.put(dishType, dish);
        System.out.println(dishes);
    }

    boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    boolean checkIsEmpty() {
        return dishes.isEmpty();
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> dishesType) {
        HashMap<String, ArrayList<String>> combo = new HashMap<>();
        Random random = new Random();
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> dishesForCombo = new ArrayList<>();
            for (String type : dishesType) {
                ArrayList<String> comboDish = dishes.get(type);
                String dish = comboDish.get(random.nextInt(comboDish.size()));
                dishesForCombo.add(dish);
            }
            combo.put("Комбо " + i, dishesForCombo);
            System.out.println("Комбо " + i);
            System.out.println(combo.get("Комбо " + i));
        }
    }
}