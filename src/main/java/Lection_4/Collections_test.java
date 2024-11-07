package Lection_4;

import java.util.*;

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

        /// List

        // ArrayList
        ArrayList<Integer> list = new ArrayList<>(collection);
        // [] <- 1
        // [_], [1] <- 2
        // [1], [_ _], [1_], [1 2] <- 3
        // [1 2], [_ _ _ _], [1 2 _ _], [1 2 3] <- 4 0(1)
        // [1 2 3 4 5] <- подставляем 7 во 2-индекс 0(n)
        // [_ _ _ _ _ _ _ _ _ _]
        // [1 2 3 4 5 _ _ _ _ _]
        // [1 2 3 3 4 5 _ _ _ _]
        // [1 2 7 3 4 5 _ _ _ _]
        // ist.get(1)  O(1)
        // list.set(1, 2)  O(1)
        // list.contains()  O(n)
    }
}
