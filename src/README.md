## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2402`

#### Выполнил: `Протасова Екатерина Сергеевна`

#### Вариант: `19`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Программа считывает с консоли число N, затем N целых чисел и заполняет
массив размером N. <br> <br>
Затем она переставляет элементы массива таким образом, чтобы сначала располагались все избыточные числа в порядке возрастания, затем
остальные числа в порядке убывания. Избыточное число — положительное целое число n, сумма положительных собственных делителей (отличных от n которого превышает n. <br> <br> 
Потом программа находит и выводит количество избыточных чисел в массиве. <br> <br>
Далее она выводит элементы массива, заменяя Избыточные числа на слово
«Избыточное», а остальные числа — на «nananan». <br> <br>
Наконец программа заменяет каждое число в массиве на количество его делителей и
выводит полученный массив.

Данную задачу можно разбить на несколько подзадач:
1. Создание массива путем считывания его размера и его элементов с консоли
2. Определение, какие числа являются избыточными
3. Сортировка избыточных по возрастанию, а не избыточных - по убыванию
4. Определение количества избыточных чисел
5. Вывод элементов массива с заменой на соответствующие строки
6. Замена каждого элемента массива на количество его делителей и вывод этого массива на экран


### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать целое число N, которым будет определен размер массива,
а также, как сказано в условии, несколько целых чисел, которыми будет заполнен массив.
N было выбрано натуральным, так как размер массива не может быть задан отрицательным числом, а массив размером 0 - это пустой массив.


|             | Тип           | min значение    | max значение     |
|-------------|---------------|-----------------|------------------|
| N           | Целое число   | 0               | 2<sup>31</sup>-1 |
| array[i][j] | Целое число   | -2<sup>31</sup> | 2<sup>31</sup>-1 |

#### Данные на выход

Программа делает 3 вывода:
1) Количество избыточных чисел
2) Представление избыточных и не избыточных чисел в виде слов
3) Количество делителей каждого элемента массива

|                  | Тип           | min значение | max значение      |
|------------------|---------------|--------------|-------------------|
| redundantCounter | Целое число   | 0            | 2<sup>31</sup>-1  |
| (array[i][j])    | String        | ""           |                   |
| array[i][j]      | Целое число   | 0            | 2<sup>31</sup>-1  |

### 3. Выбор структуры данных

Программа получает целое число N и целые числа, которыми будет заполнен массив. Для их хранения будем использовать переменные (quantity, array[i][j])
типа int.

|             | Название переменной | Тип (в Java) | 
|-------------|---------------------|--------------|
| N           | `quantity`          | `int`        |
| array[i][j] | `array[i][j]`       | `int`        |


### 4. Алгоритм и математическая модель:

1. **Создание массива и ввод данных:**  

   Программа получает целое число N на вход. Для этого используется метод nextInt().
   С помощью цикла for происходит заполнение массива числами с использованием того же метода nextInt().


2. **Определение избыточных чисел:**

   Программа создает дополнительные массивы redundant и notRedundant для избыточных и неизбыточных чисел соответственно.
   Используя цикл for, программа находит сумму таких чисел, меньших проверяемого числа, на которые это число делится без остатка.
   Если сумма больше проверяемого числа, а само число - положительное, то оно добавляется в массив redundant. В противном случае
   число добавляется в массив notRedundant.


3. **Сортировка:**  
   
   Программа сортирует массив избыточных чисел по возрастанию, а неизбыточных - по убыванию. Обе сортировки выполняются 
   методом пузырька.


4. **Определение количества избыточных чисел:**

   Для подсчета таких чисел используется дополнительная переменная redundantCounter. С помощью цикла for программа проходится
   по массиву redundant и увеличивает redundantCounter на 1 в том случае, если элемент больше 0. После этого следует вывод
   количества чисел на экран.


5. **Вывод элементов массива с заменой на соответствующие строки:**

   Для выполнения этого шага программа использует два цикла for: один - для массива redundant, второй - для массива notRedundant.
   Таким образом два отсортированных массива записываются в начальный массив array. Параллельно с этим программа выводит
   для каждого избыточного числа слово "Избыточное", а для каждого неизбыточного - "nananan".


6. **Замена каждого элемента массива на количество его делителей:**  
   
   С помощью вложенного цикла for программа заменяет каждое число на количество его делителей следующим образом: она 
   запоминает число в новой переменной number, а затем обнуляет ячейку массива array, в которой находится число.
   Посредством цикла осуществляется подсчет делителей, в это количество входит и само число.


### 5. Программа

```java
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
```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на N = 0:

    - **Input**:
        ```
        0
        ```

    - **Output**:
        ```
        Количество Избыточных чисел: 0
        ```

2. Тест на N = -1:

    - **Input**:
        ```
        -1
        ```

    - **Output**:
        ```
        Exception in thread "main" java.lang.NegativeArraySizeException: -1
        ```

3. Тест на базовый случай:

    - **Input**:
        ```
        5
        12 33 45 6 107
        ```

    - **Output**:
        ```
        Количество Избыточных чисел: 1
        Избыточное nananan nananan nananan nananan 
        12 107 45 33 6
        6 2 6 4 4
        ```

4. Тест на все избыточные числа:

    - **Input**:
        ```
        4
        12 20 24 18
        ```

    - **Output**:
        ```
        Количество Избыточных чисел: 4
        Избыточное Избыточное Избыточное Избыточное
        12 18 20 24
        6 6 6 8
        ```

5. Тест на все неизбыточные числа:

    - **Input**:
        ```
        4
        7 13 11 5
        ```

    - **Output**:
        ```
        Количество Избыточных чисел: 0
        nananan nananan nananan nananan 
        13 11 7 5
        2 2 2 2
        ```
6. Тест, включающий отрицательное значение и ноль:

   - **Input**:
       ```
       5
       12 0 -3 18 11
       ```

   - **Output**:
       ```
       Количество Избыточных чисел: 2
       Избыточное Избыточное nananan nananan nananan  
       12 18 11 0 -3
       6 6 2 0 0
       ```