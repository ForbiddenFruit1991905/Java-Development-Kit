package seminars.seminar_4;

import javax.swing.*;
import java.util.*;

/*
Создайте коллекцию мужских и женских имен с помощью
интерфейса List - добавьте повторяющиеся значения.
Получите уникальный список Set на основании List.
Определите наименьший элемент (алфавитный порядок).
Определите наибольший элемент (по количеству букв в слове,
но в обратном порядке).
Удалите все элементы содержащие букву ‘A’
 */
public class task_2 {
    public static void main(String[] args) {
        List<String> maleName = new ArrayList<>(List.of("Dima", "Dima", "Slava", "Dima", "Misha"));
        List<String> femaleName = new ArrayList<>(List.of("Vika", "Elena", "Vika", "Sonya", "Anna"));
        makeSet(maleName);
        System.out.println(maleName);
        makeSet(femaleName);
        System.out.println(femaleName);
        Set<String> namesHashSet1 = new HashSet<>(maleName);
        Set<String> namesHashSet2 = new HashSet<>(femaleName);
        findMinLetters(namesHashSet1);
        findMinLetters(namesHashSet2);

        minAndMaxLengthName(namesHashSet1);

        sortAscAndDesc(namesHashSet1);

        removeByChar(namesHashSet2, 'A');
    }

    public static void makeSet(List<String> list) {
        new HashSet<>(list);
    }

    public static void findMinLetters(Set<String> list) {
        int minLettersCount = Integer.MAX_VALUE;
        List<String> minLettersWords = new ArrayList<>();
        for (String word : list) {
            int count = word.length();
            if (count < minLettersCount) {
                minLettersCount = count;
                minLettersWords.clear();
                minLettersWords.add(word);
            }
        }
        System.out.println("Список слов с минимальным количеством букв:");
        for (String minLettersWord : minLettersWords) {
            System.out.println(minLettersWord);
        }
        System.out.println("Минимальное количество букв в списке: " + minLettersCount);
    }

    public static void minAndMaxLengthName(Set<String> names) {
        System.out.println("Минимальное количество букв в списке: " +
                names.stream().min(Comparator.comparing(String::length)).orElse(null));
        System.out.println("Максимальное количество букв в списке: " +
                names.stream().max(Comparator.comparing(String::length)).orElse(null));
    }

    public static void sortAscAndDesc(Set<String> list) {
        System.out.println("Отсортированный список в порядке возрастания:");
        list.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println("Отсортированный список в порядке убывания (по длине слов):");
        list.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);
    }

    public static void removeByChar(Set<String> names, char symbol) {
        names.removeIf(name -> name.contains(String.valueOf(symbol)));
        System.out.println("Элементы, содержащие символ '" + symbol + "', были удалены:");
        names.forEach(System.out::println);
    }
}
