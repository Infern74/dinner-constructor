import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-".repeat(35));
            printMenu();
            String command = scanner.nextLine().trim();
            System.out.println("-".repeat(35));

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Введена неверная команда");
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
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dc.addNewDish(dishType, dishName); // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine().trim();

        // ввод типов блюд
        while (!nextItem.isEmpty()) {
            dc.saveTypeForDishCombo(nextItem);
            nextItem = scanner.nextLine().trim();
        }

        dc.generateDishCombo(numberOfCombos); // генерация комбинаций блюд и вывод на экран

    }
}
