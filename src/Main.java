import java.util.Arrays;
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

    //Метод для получения случайного числа
    public static int randomNumber() {
        int min = -100;
        int max = 100;

        // Формула для получения случайного целого числа в указанном диапазоне
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
