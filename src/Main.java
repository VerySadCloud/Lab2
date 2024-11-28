import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Объявляем объект класса Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Вводим размер массива, создаем массив и заполняем его числами
        int quantity = scanner.nextInt();
        int[] array = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            array[i] = scanner.nextInt();
        }

        // Создаем массивы для избыточных и не избыточных чисел
        int[] redundant = new int[quantity];
        int[] notRedundant = new int[quantity];

        // Задаем позицию в массивах
        int positionRedundant = 0;
        int positionNotRedundant = 0;

        // Определяем, какие числа избыточные
        for (int i = 0; i < quantity; i++) {
            boolean isRedundant = false;
            int sumRedundant = 0;
            int number = array[i];
            for (int j = 1; j < number; j++) {
                if (number % j == 0) {
                    sumRedundant += j;
                }
            }
            if (sumRedundant > number) {
                isRedundant = true;
            }
            if (isRedundant && (number > 0)) {
                redundant[positionRedundant++] = array[i];
            } else {
                notRedundant[positionNotRedundant++] = array[i];
            }
        }

        // Сортируем массив избыточных по возрастанию
        for (int i = 0; i < positionRedundant-1; i++) {
            for (int j = 0; j < positionRedundant-1-i; j++) {
                if (redundant[j] > redundant[j+1]) {
                    int placeHolder = redundant[j];
                    redundant[j] = redundant[j+1];
                    redundant[j+1] = placeHolder;
                }
            }
        }

        // Сортируем массив не избыточных по убыванию
        for (int i = 0; i < positionNotRedundant-1; i++) {
            for (int j = 0; j < positionNotRedundant-1-i; j++) {
                if (notRedundant[j] < notRedundant[j+1]) {
                    int placeHolder = notRedundant[j];
                    notRedundant[j] = notRedundant[j+1];
                    notRedundant[j+1] = placeHolder;
                }
            }
        }

        // Подсчитываем количество избыточных чисел
        int redundantCounter = 0;
        for (int i = 0; i < redundant.length; i++) {
            if (redundant[i] > 0) {
                redundantCounter++;
            }
        }

        // Выводим количество избыточных чисел на экран
        System.out.println("Количество Избыточных чисел: " + redundantCounter);

        // Объединяем два массива, записывая их в начальный и выводя на экран нужные строки
        for (int i = 0; i < positionRedundant; i++) {
            array[i] = redundant[i];
            System.out.print("Избыточное ");
        }
        for (int i = positionRedundant; i < array.length; i++) {
            array[i] = notRedundant[i-positionRedundant];
            System.out.print("nananan ");
        }

        System.out.println();

        // (Выводим отсортированный массив на экран)
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Заменяем числа в массиве на количество их делителей
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            array[i] = 0;
            for (int j = 1; j <= number; j++) {
                if (number % j == 0) {
                    array[i]++;
                }
            }
        }

        System.out.println();

        // Выводим массив с количеством делителей
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}