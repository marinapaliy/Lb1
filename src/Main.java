import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть метод:");
        System.out.println("1. Порівняння елементів масиву");
        System.out.println("2. Гра 'FizzBuzz'");
        System.out.println("3. Розділення масиву");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                int[] array = {1, 2, 2, 3, 4, 4, 5};
                boolean result = compareArray(array);
                System.out.println("Результат порівняння елементів масиву: " + result);
                break;
            case 2:
                fizzBuzzGame();
                break;
            case 3:
                int[] arrayToSplit = {1, 1, 1, 2, 1};
                boolean canSplit = splitArray(arrayToSplit);
                System.out.println("Можливість розділення масиву: " + canSplit);
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }

    public static boolean compareArray(int[] arr) {
        if (arr.length < 2) {
            return false; // Масив має бути довжиною 2 або більше
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false; // Якщо знайдено елемент, що менший за попередній, повернути false
            }
        }

        return true; // Усі елементи більші або дорівнюють попередньому
    }

    public static void fizzBuzzGame() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static boolean splitArray(int[] arr) {
        if (arr.length < 2) {
            return false; // Масив має бути довжиною 2 або більше
        }

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false; // Сума елементів масиву повинна бути парним числом для розділення на дві рівні частини
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum == totalSum / 2) {
                return true; // Знайдено розділення
            }
        }

        return false; // Неможливо розділити масив на дві частини з однаковою сумою
    }
}
