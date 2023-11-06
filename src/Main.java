import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Результат выполнения задачи 1:");
        int[] originArray = {3, 2, 1, 6, 5};
        invertArray(originArray);
        System.out.println(Arrays.toString(originArray));

        System.out.println();
        System.out.println("Результат выполнения задачи 2:");
        String originStr = "aabccddefgghiijjkk";
        checkDoubleChar(originStr);

        System.out.println();
        System.out.println("Результат выполнения задачи 3:");
        int[] expnsArray = generateRandomArray();
        double avgMonthExpns = defineAvgMonthExpns(defineSumMonthExpns(expnsArray));
        System.out.println("Средняя сумма трат за месяц составила: " + String.format("%.2f", avgMonthExpns));

    }

//    Задание 1.
//    Напишите метод, который получает на вход массив и переставляет все его элементы в обратном порядке.
//    Важно: не используйте дополнительные массивы для решения этой задачи. Необходимо корректно пройти по
//    массиву циклом и распечатать его элементы в правильном порядке.
//    В метод приходит массив, допустим:
//    {3, 2, 1, 6, 5}.
//    Нужно без вспомогательного массива переместить элементы так, чтобы поданный массив стал: {5, 6, 1, 2, 3}.
//    Рекомендуем написать этот метод без возвращаемого значения. Вы будете приятно удивлены, что даже если мы
//    не вернем массив, первоначальный массив изменится, когда мы будем модернизировать пришедший в виде параметра
//    массив внутри метода.

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
            }

    }
//    Задание 2
//    Напишите метод, который в виде параметра принимает отсортированную строку.
//    Например, aabccddefgghiijjkk.
//    С помощью цикла проверьте, что в строке нет дублей, и выведите в консоль сообщение об этом.
//    Если дубль найден, нужно прервать поиск по остальным символам и вывести сообщение о присутствии дубля, причем
//    с указанием, какой именно символ задублирован. Затем сразу же прервать выполнение метода.
//    Сам метод ничего возвращать не должен (void).

    public static void checkDoubleChar(String str) {
        char[] strToArray = str.toCharArray();
        for (int i = 0; i < strToArray.length - 1; ) {
            if (strToArray[i] == strToArray[i + 1]) {
                System.out.println("Найден дубль: " + strToArray[i] + strToArray[i + 1]);
                break;
            }
            else {
                i++;
                if (i == strToArray.length - 2) {
                    System.out.println("Дублей в строке нет.");
                }
            }
        }
    }
//    Задание 3
//    Снова вспоминаем домашнее задание по массивам. В нем была задача, которая требовала высчитать среднюю выплату за день.
//    Был дан сгенерированный массив из 30 значений от 100 до 200 тысяч, для его генерации допускается использовать метод
//    из прошлого домашнего задания.
//    Нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
//    Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц поделить
//    на количество дней), и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
//    Важно помнить: подсчет среднего значения может иметь остаток (то есть быть не целым, а дробным числом).
//    Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов и вычислить
//    среднее значение, которое нужно вернуть из метода в виде результата.
//    Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
//    То есть для работы этого метода нужно будет создать еще методы (1 или более), которые его будут обслуживать и вычислять
//    промежуточные результаты. Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.

    public static double defineAvgMonthExpns(int sumExpns) {
       return (double) sumExpns / 30;
    }
    public static int defineSumMonthExpns(int[] expensesArray) {
        int sumExpns = 0;
        for (int i : expensesArray) {
            sumExpns += i;
        }
        return sumExpns;
    }
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}