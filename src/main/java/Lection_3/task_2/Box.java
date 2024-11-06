package Lection_3.task_2;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruits> {

    private List<T> fruits = new ArrayList<>();

    void addFruit(T fruit) {
        fruits.add(fruit);
    }

    float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    int compareTo(Box<?> anotherBox) {
        return Float.compare(this.getWeight(), anotherBox.getWeight());
    }

    void transferFruits(Box<T> anotherBox) {
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
