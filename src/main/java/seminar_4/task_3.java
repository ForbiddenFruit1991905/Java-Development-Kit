package seminar_4;

import java.util.*;
import java.util.stream.Collectors;

/*
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
значение.
● Найдите человека с самым маленьким номером телефона.
● Найдите номер телефона человека чье имя самое большое в алфавитном
порядке.
 */
public class task_3 {

    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("777", "Vika");
        phonebook.put("555", "Dima");
        phonebook.put("999", "Sonya");

        System.out.println(findByMinPhoneNumber(phonebook));
        System.out.println(findByMaxAlphabetName(phonebook));
    }

    public static String findByMinPhoneNumber(Map<String, String> phonebook) {
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        long number = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("Наименьший номер: %s, владелец: %s", number, phonebook.get(String.valueOf(number)));
    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook) {
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
//        Map.Entry<String, String> name = elements.stream().max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        Map.Entry<String, String> name = elements.stream().max(Map.Entry.comparingByValue()).get();
        return String.format("Наибольшее имя в алфавитном порядке: %s, номер телефона %s",
                name.getValue(), name.getKey());
    }
}
