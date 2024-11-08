package seminar_4;

/*
Создайте коллекцию мужских и женских имен с помощью
интерфейса List.
Отсортируйте коллекцию в алфавитном порядке.
Отсортируйте коллекцию по количеству букв в слове.
Разверните коллекцию.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class task_1 {
    public static void main(String[] args) {
        // Список, созданный с помощью метода List.of() является неизменяемым.
        // Необходимо использовать new ArrayList<>().
        
        List<String> maleName = new ArrayList<>(List.of("Dima", "Slava", "Misha"));
        List<String> femaleName = new ArrayList<>(List.of("Vika", "Elena", "Sonya"));

        sortASC(maleName);
        System.out.println(maleName);
        sortASC(femaleName);
        System.out.println(femaleName);
        sortByLength(maleName);
        System.out.println(maleName);
        sortByLength(femaleName);
        System.out.println(femaleName);
        reverseOrder(maleName);
        System.out.println(maleName);
        reverseOrder(femaleName);
        System.out.println(femaleName);
    }

    public static void sortASC(List<String> list) {
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
    }

    public static void reverseOrder(List<String> list) {
        Collections.reverse(list);
    }

}
