package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        В рамках выполнения задачи необходимо:
        Создать свой Java Maven проект;
        Добавьте зависимость commons-math3 (предназначена для решения
        математических задач) и изучить интерфейс библиотеки.
        Воспользоваться пакетом org.apache.commons.math3.stat и классом
        DescriptiveStatistics.
        Создать коллекцию из числовых элементов.
        С помощью объекта DescriptiveStatistics вычислить минимальное и
        максимальное значение, сумму и среднее арифметическое.
        Воспользоваться пакетом org.apache.commons.math3.util.
        С помощью класса ArithmeticUtils найти: факториал числа N.
        Наименьшее общее частное двух чисел.
        Наибольший общий делитель двух чисел.
        Проверить что число N это степень двойки.
         */
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Минимальное значение в массиве = " + descriptiveStatistics.getMin());
        System.out.println("Максимальное значение в массиве = " + descriptiveStatistics.getMax());
        System.out.println("Сумма всех значений в массиве = " + descriptiveStatistics.getSum());
        System.out.println("Среднее арифметическое значение всех элементов в массиве = " + descriptiveStatistics.getMean());
        System.out.println("**************************");
        System.out.println("Факториал числа 5: " + ArithmeticUtils.factorial(5));
        System.out.println("Наименьшее общее частное двух чисел 15 b 25: " + ArithmeticUtils.lcm(15, 25));
        System.out.println("Наибольший общий делитель двух чисел 10 и 30: " + ArithmeticUtils.gcd(10, 30));
        System.out.println("Проверить что число 20 это степень двойки: " + ArithmeticUtils.isPowerOfTwo(16));

    }
}