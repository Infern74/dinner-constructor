import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu;
    ArrayList<String> typesForDinnerCombo;
    ArrayList<String> dinnerCombo;
    Random rand;

    DinnerConstructor() {
        dinnerMenu = new HashMap<>();
        typesForDinnerCombo = new ArrayList<>();
        rand = new Random();
    }
    void addNewDish(String dishType, String dishName) {
        if (dinnerMenu.containsKey(dishType)) {
            ArrayList<String> dishNames = dinnerMenu.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dinnerMenu.put(dishType, dishNames);
        }
    }

    void saveTypeForDishCombo(String dishType) {
        if (dinnerMenu.containsKey(dishType)) {
            typesForDinnerCombo.add(dishType);
        } else {
            System.out.println("Такого типа блюд еще нет в нашем меню, попробуйте использовать что-то другое");
        }
    }

    void generateDishCombo(int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i+1));
            dinnerCombo = new ArrayList<>();
            for (String element : typesForDinnerCombo) {
                ArrayList<String> dishNames = dinnerMenu.get(element);
                String dish = dishNames.get(rand.nextInt(dishNames.size()));
                dinnerCombo.add(dish);
            }
            System.out.println(dinnerCombo);
        }
        typesForDinnerCombo = new ArrayList<>();
    }
}