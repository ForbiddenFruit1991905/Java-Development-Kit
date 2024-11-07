package Lection_4;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Collections_test {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);
        // Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        // For each
        for (Integer value : collection) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Stream api
        collection.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
        // или
        collection.stream().forEach(System.out::println);
    }
}
