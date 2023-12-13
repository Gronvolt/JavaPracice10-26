import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static boolean continueExecution = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (continueExecution) {
            //Task roster
            int numberOfTask = taskRoaster();
            switch (numberOfTask) {
                case 1: {
                    task1();
                    break;
                }
                case 2: {
                    task2();
                    break;
                }
                case 3: {
                    task3();
                    break;
                }
                case 4: {
                    task4();
                    break;
                }
                case 5: {
                    task5();
                    break;
                }
                case 6: {
                    task6();
                    break;
                }
                case 7: {
                    task7();
                    break;
                }
                case 8: {
                    task8();
                    break;
                }
                case 9: {
                    task9();
                    break;
                }
                default:
                    System.out.println("\nВыберите задание!");
                    break;
            }
            nextTaskQuestion();
        }
    }

    public static int taskRoaster() {
        System.out.print("Выберите задание для проверки: ");
        return scanner.nextInt();
    }

    public static void nextTaskQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Хотите проверить другую задачу?  Да/Нет: ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("да") || choice.equalsIgnoreCase("yes")) {
            continueExecution = true;
        } else if (choice.equalsIgnoreCase("нет") || choice.equalsIgnoreCase("no")) {
            scanner.close();
            continueExecution = false;
        }
    }

    public static void task1() {
        //Два одномерных массива заполняются случайными
        //числами. Необходимо:
        //■ Сформировать третий массив, содержащий элементы
        //обоих массивов;
        //■ Сформировать третий массив, содержащий элементы
        //обоих массивов без повторений;
        //■ Сформировать третий массив, содержащий элементы
        //общие для двух массивов;
        //■ Сформировать третий массив, содержащий только
        //уникальные элементы каждого из массивов;
        //■ Сформировать третий массив, содержащий только
        //минимальное и максимальное значение каждого из
        //массивов.

        //Пустой массив для наполнения случайными числами
        int[] firstNumsArr = new int[10];
        int[] secondNumsArr = new int[10];

        //Наполнение массива
        for (int i = 0; i < firstNumsArr.length; i++) {
            firstNumsArr[i] = randomNumber();
            secondNumsArr[i] = randomNumber();
        }

        //Массив для результатов
        int[] resultArr = new int[20];

        //Формирование массива со значениями из двух предыдущих
        System.arraycopy(firstNumsArr, 0, resultArr, 0, firstNumsArr.length);
        System.arraycopy(secondNumsArr, 0, resultArr, 10, secondNumsArr.length);

        Arrays.sort(resultArr);
        System.out.println("Изначальный массив: " + Arrays.toString(resultArr)
                + ". Длина: " + resultArr.length + " элементов");

        //Массив, содержащий элементы обоих массивов без повторений
        int[] uniqueValuesArr = new int[resultArr.length];
        uniqueValuesArr[0] = resultArr[0];
        for (int i = 1; i < resultArr.length; i++) {
            if (uniqueValuesArr[i - 1] != resultArr[i]) {
                uniqueValuesArr[i] = resultArr[i];
            }
        }

        System.out.println("Массив, содержащий элементы обоих массивов без повторений: " + Arrays.toString(uniqueValuesArr)
                + ". Длина: " + uniqueValuesArr.length + " элементов");

        //Массив, содержащий только одинаковые элементы
        int[] equalValuesArr = new int[resultArr.length];
        equalValuesArr[0] = resultArr[0];
        for (int i = 1; i < resultArr.length; i++) {
            if (equalValuesArr[i - 1] == resultArr[i]) {
                equalValuesArr[i] = resultArr[i];
            }
        }

        System.out.println("Массив, содержащий общие элементы обоих массивов: " + Arrays.toString(uniqueValuesArr)
                + ". Длина: " + uniqueValuesArr.length + " элементов");

        //Массив, содержащий минимальное и максимальное значение каждого из массивов
        Arrays.sort(firstNumsArr);
        Arrays.sort(secondNumsArr);
        int[] minMaxValsArr = {
                firstNumsArr[0],
                firstNumsArr[firstNumsArr.length - 1],
                secondNumsArr[0],
                secondNumsArr[secondNumsArr.length - 1]
        };

        System.out.println("Массив, содержащий минимальное и максимальное значение каждого из массивов: "
                + Arrays.toString(minMaxValsArr)
                + ". Длина: " + minMaxValsArr.length + " элемента.");
    }

    public static void task2() {
        //Пользователь с клавиатуры вводит зарплату сотрудников фирмы. Необходимо отсортировать полученные
        //данные по возрастанию или убыванию в зависимости
        //от выбора пользователя.

        //Ввод данных с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите зарплаты через пробел: ");
        String values = scanner.nextLine();
        System.out.println("Введите \"1\", если хотите отсортировать по возрастанию.");
        System.out.println("Введите \"2\", если хотите отсортировать по убыванию.");
        System.out.print("Ввод: ");
        int usersChoice = scanner.nextInt();


        //Преобразование в массив
        String[] valsArr = values.split(" ");
        Integer[] integerValsArr = new Integer[valsArr.length];
        for (int i = 0; i < valsArr.length; i++) {
            integerValsArr[i] = Integer.parseInt(valsArr[i]);
        }

        //Сортировка массивов, в зависимости от выбора пользователя
        if (usersChoice == 1) {
            Arrays.sort(integerValsArr);
        }
        if (usersChoice == 2) {
            Arrays.sort(integerValsArr, Collections.reverseOrder());
        }

        //Вывод результатов
        System.out.println("Отсортированные зарплаты: " + Arrays.toString(integerValsArr));

    }

    public static void task3() {
        //Есть одномерныймассив из 15 элементов, заполненный
        //случайными числами. Необходимо первые 7 элементов
        //отсортировать по возрастанию, оставшиеся 8 элементов
        //по убыванию.

        //Массив со случайными значениями
        Integer[] arrWithRandomVals = new Integer[15];

        for (int i = 0; i < arrWithRandomVals.length; i++) {
            arrWithRandomVals[i] = randomNumber();
        }

        System.out.println("Массив со случайными значениями: " + Arrays.toString(arrWithRandomVals));

        //Разделение массива на две части
        Integer[] firstHalfOfArr = new Integer[7];
        Integer[] secondHalfOfArr = new Integer[8];

        System.arraycopy(arrWithRandomVals, 0, firstHalfOfArr, 0, 7);
        System.arraycopy(arrWithRandomVals, 7, secondHalfOfArr, 0, 8);

        //Сортировка массивов
        Arrays.sort(firstHalfOfArr);
        Arrays.sort(secondHalfOfArr, Collections.reverseOrder());

        //Вывод результатов
        System.out.println(
                "Первые 7 элементов: " + Arrays.toString(firstHalfOfArr)
                        + "\n" + "Оставшиеся 8 элементов: " + Arrays.toString(secondHalfOfArr)
        );
    }

    public static void task4() {
        //Есть одномерный массив из 10 элементов, заполненный случайными числами. Необходимо найти число,
        //введенное пользователем. Используйте алгоритм бинарного поиска.

        //Формирование массива со случйными значениями
        int[] randomValsArr = new int[10];

        for (int i = 0; i < randomValsArr.length; i++) {
            randomValsArr[i] = randomNumber();
        }

        //Предварительная сортировка для бинароного поиска
        Arrays.sort(randomValsArr);
        System.out.println(Arrays.toString(randomValsArr));

        //Ввод числа с консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для поиска: ");
        int numForSearching = scanner.nextInt();

        //Поиск по массиву
        int index = Arrays.binarySearch(randomValsArr, numForSearching);

        //Вывод результатов
        if (randomValsArr[index] == numForSearching) {
            System.out.println("Искомое число " + numForSearching + " найдено, под индексом: " + index);
        } else System.out.println("Искомое число не найдено!");


    }

    public static void task5() {
        //Пользователь с клавиатуры вводит элементы двумерного массива (3x3). Необходимо найти сумму элементов
        //массива, среднеарифметическое, отобразить на экран все
        //элементы массива

        //Ввод данных
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы первого масива через пробел: ");
        String firstString = scanner.nextLine();
        System.out.print("Введите элементы второго масива через пробел: ");
        String secondString = scanner.nextLine();

        //Преобразование в массивы чисел
        String[] firstStringArr = firstString.split(" ");
        String[] secondStringArr = secondString.split(" ");
        int[] firstIntegerArr = new int[firstStringArr.length];
        int[] secondIntegerArr = new int[secondStringArr.length];

        for (int i = 0; i < firstIntegerArr.length; i++) {
            firstIntegerArr[i] = Integer.parseInt(firstStringArr[i]);
            secondIntegerArr[i] = Integer.parseInt(secondStringArr[i]);
        }

        //Преобразование в двумерный массив
        int[][] resultArr = new int[2][3];

        //Наполнение массивов значениями из первых двух
        resultArr[0] = firstIntegerArr;
        resultArr[1] = secondIntegerArr;

        //Переменные для хранения результатов
        int sumOfElements = 0;
        int averageOfElements;

        //Вычисление результатов
        for (int[] ints : resultArr) {
            for (int anInt : ints) {
                sumOfElements += anInt;
            }
        }

        averageOfElements = sumOfElements / (firstIntegerArr.length + secondIntegerArr.length);

        //Вывод результатов
        System.out.println("Получившийся массив: " + Arrays.deepToString(resultArr));
        System.out.println("Сумма всех его элементов: " + sumOfElements);
        System.out.println("Среднее арифметическое: " + averageOfElements);
    }

    public static void task6() {
        //В двумерноммассиве, заполненномслучайными числами, определить минимальный и максимальный элементы
        //для каждой строки. Результаты вывести на экран.

        //Формирование массива со случайными числами
        int[][] arrWithRandomNums = getTwoRangedArr(5, 5);

        //Вывод результатов в консоль
        System.out.println(Arrays.deepToString(arrWithRandomNums));

        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Минимальное значение "
                            + (i + 1) + "й строки массива: "
                            + arrWithRandomNums[i][0]
            );
            System.out.println(
                    "Максимальное значение "
                            + (i + 1) + "й строки массива: "
                            + arrWithRandomNums[i][arrWithRandomNums.length - 1]
            );
        }
    }

    public static void task7() {
        //В двумерном массиве, заполненном случайными числами, определить минимальный и максимальный элементы
        //для каждого столбца. Результаты вывести на экран

        //Формирование массива со случайными числами
        //Массив был предварительно отсортирован
        int[][] arrWithRandomNums = getTwoRangedArr(5, 5);

        //Переменнаые для хранения результатов
        int[] tempArr = new int[arrWithRandomNums.length];

        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[j] = arrWithRandomNums[j][i];
            }
            Arrays.sort(tempArr);
            System.out.println("Минимальный " + tempArr[0]);
            System.out.println("Максимальный " + tempArr[tempArr.length - 1]);
        }

        //Вывод результатов в консоль
        System.out.println(Arrays.deepToString(arrWithRandomNums));
    }

    public static void task8() {
        //Есть два двумерных массива (матрицы размером
        //2x2), заполненные случайными числами. Найдите сумму
        //матриц, разницу матриц, произведение матриц.

        //Формирование массивов со случайными числами
        //Массив был предварительно отсортирован
        int[][] firstArrWithRandomNums = getTwoRangedArr(2, 2);
        int[][] secondArrWithRandomNums = getTwoRangedArr(2, 2);

        //Массивы для хранения результатов
        int[][] resultMatrixAddition = new int[2][2];
        int[][] resultMatrixSubtraction = new int[2][2];
        int[][] resultMatrixProduct = new int[2][2];

        //Вычисление результатов
        for (int i = 0; i < resultMatrixAddition.length; i++) {
            for (int j = 0; j < resultMatrixAddition.length; j++) {
                resultMatrixAddition[i][j] = firstArrWithRandomNums[i][j] + secondArrWithRandomNums[i][j];
                resultMatrixSubtraction[i][j] = firstArrWithRandomNums[i][j] - secondArrWithRandomNums[i][j];
                resultMatrixProduct[i][j] = firstArrWithRandomNums[i][j] * secondArrWithRandomNums[i][j];
            }
        }

        //Вывод результатов в консоль
        System.out.println("Первая матрица: " + Arrays.deepToString(firstArrWithRandomNums));
        System.out.println("Вторая матрица: " + Arrays.deepToString(secondArrWithRandomNums));
        System.out.println("Сумма матриц: " + Arrays.deepToString(resultMatrixAddition));
        System.out.println("Разница матриц: " + Arrays.deepToString(resultMatrixSubtraction));
        System.out.println("Произведение матриц: " + Arrays.deepToString(resultMatrixProduct));
    }

    public static void task9() {
        //Напишите программу, которая создает двухмерный
        //массив и заполняет его по следующему принципу: пользователь вводит число (например, 8) первый элемент
        //массива принимает значение этого числа, последующий
        //элемент массива принимает значение этого числа +7 (т.е.
        //15 для нашего примера), третий элемент массива предыдущий элемент +7 (т.е. 22 для нашего примера). Созданный
        //массив вывести на экран

        //Ввод данных с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();

        //Формирование массива
        int[] arr = new int[20];
        arr[0] = num;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1] + num;
        }

        //Вывод результатов
        System.out.println(Arrays.toString(arr));
    }

    //Метод для получения случайного числа
    public static int randomNumber() {
        int min = 1;
        int max = 5;

        // Формула для получения случайного целого числа в указанном диапазоне
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    //Формирование массива со случайными числами
    public static int[][] getTwoRangedArr(int rows, int cols) {
        //Формирование массива со случайными числами
        int[][] arrWithRandomNums = new int[rows][cols];
        for (int i = 0; i < arrWithRandomNums.length; i++) {
            for (int j = 0; j < arrWithRandomNums[i].length; j++) {
                arrWithRandomNums[i][j] = randomNumber();
            }
        }

        for (int[] arrWithRandomNum : arrWithRandomNums) {
            Arrays.sort(arrWithRandomNum);
        }
        return arrWithRandomNums;
    }
}
