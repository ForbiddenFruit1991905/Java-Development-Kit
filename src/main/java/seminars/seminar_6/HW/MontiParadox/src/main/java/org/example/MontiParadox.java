package org.example;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.util.Precision;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

/*
В качестве задачи предлагаю вам реализовать код для демонстрации
парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно
убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой.
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>.
Вывести на экран статистику по победам и поражениям.
Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта.
 */
public class MontiParadox {
    private static final int numSimulations = 1000;
    public static void main(String[] args) {
        /*
        В контексте симуляции парадокса Монти Холла, `RandomDataGenerator` используется для имитации случайных событий
        в игре, таких как выбор выигрышной двери, выбор игроком двери и т.д. Путем использования `RandomDataGenerator`
        можно эффективно моделировать случайные процессы и получать случайные данные для различных целей в
        программировании и анализе данных.
         */
        RandomDataGenerator randomData = new RandomDataGenerator();
        HashMap<Integer, Boolean> results = new HashMap<>();
        
        for (int i = 1; i <= numSimulations; i++) {
            // Имитация начала игры
            int winningDoor = randomData.nextInt(1, 3);
            int playerChoice = randomData.nextInt(1, 3);

            // Монти открывает одну из невыигрышных дверей
            int montyDoor;
            do {
                montyDoor = randomData.nextInt(1, 3);
            } while (montyDoor == winningDoor || montyDoor == playerChoice);

            // Игрок принимает решение о смене двери
            int newChoice;
            newChoice = randomData.nextInt(1, 3);
            while (newChoice == playerChoice || newChoice == montyDoor) {
                newChoice = randomData.nextInt(1, 3);
            }

            // Проверка выигрыша игрока
            boolean win = newChoice == winningDoor;
            results.put(i, win);
        }
        // Вывод итогового счета
        Collection<Boolean> values = results.values();
        long wins = 0;
        for (boolean value : values) {
            if (value) {
                wins++;
            }
        }

        System.out.println("Количество побед: " + wins);
        double winPercentage = Precision.round((double) wins / numSimulations * 100, 2);
        System.out.println("Процент побед: " + winPercentage + "%");
        System.out.println("Количество проигрышей: " + (numSimulations - wins));
        System.out.println("Процент проигрышей: " + Precision.round(100 - winPercentage, 2) + "%");
        
//        Пробую научиться пользоваться стримами
//        Stream<Boolean> valuesStream = results.values().stream();
//        Stream<Boolean> trueValuesStream = valuesStream.filter(value -> value.booleanValue() == true);
//        long wins = trueValuesStream.count();
//        long wins = results.values().stream().filter(Boolean::booleanValue).count();
        /* ---> long wins = results.values().stream().filter(Boolean::booleanValue).count();
        - `results.values()` - получаем коллекцию значений из HashMap `results`
        - `.stream()` - создаем поток данных из коллекции значений.
        - `.filter(Boolean::booleanValue)` - фильтруем поток, оставляя только те значения, которые преобразуются в
        `true` при вызове метода `booleanValue()` у объектов типа `Boolean`.
        - `.count()` - подсчитываем количество элементов в потоке.
         */

    }
}