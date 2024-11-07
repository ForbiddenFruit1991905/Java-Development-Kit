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

        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        for(Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " +
                    entry.getValue());
        }

        Map<String, Integer> map = Map.of("hello", 1, "world", 2);
        // for each
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }

        // Stream
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // HashSet (повторяющихся значений нет и не может быть!)
        // Начальная емкость по умолчанию - 16, коэффициент загрузки 0,75
        HashSet defaultConstructor = new HashSet();
        // Конструктор с заданной начальной емкостью. Коэффициент загрузки 0,75
        HashSet constructorWithCapacity = new HashSet(32);
        // Конструктор с заданной начальной емкостью и коэффициентом загрузки
        HashSet constructorWithCapacityFactor = new HashSet<>(32, 0.6f);
        // Конструктор, добавляющий элементы из другой коллекции
        HashSet fromCollection = new HashSet<>(defaultConstructor);


        // TreeSet
        // Конструктор по умолчанию
        TreeSet defaultConstructor1 = new TreeSet<>();
        // Конструктор, добавляющий эл-ты из другой коллекции
        TreeSet fromCollection1 = new TreeSet<>(defaultConstructor1);
        // Конструктор создает пустое дерево, где все добавляемые эл-ты впоследствии будут отсортированы компаратором
        TreeSet withComparator = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        // PriorityQueue
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        PriorityQueue<Integer> integerQueueWithComparator =
                new PriorityQueue<>((Integer c1, Integer c2) -> c2 - c1); // обратный порядок
        integerQueueWithComparator.add(3);
        integerQueue.add(3);

        integerQueueWithComparator.add(2);
        integerQueue.add(2);

        integerQueueWithComparator.add(1);
        integerQueue.add(1);

        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.poll());
        System.out.println(integerQueueWithComparator.poll());
        System.out.println(integerQueueWithComparator.poll());
        System.out.println(integerQueueWithComparator.poll());
    }
}
