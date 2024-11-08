package seminars.seminar_3;

import java.util.Arrays;

/*
Описать собственную коллекцию – список на основе массива.
Коллекция должна иметь возможность хранить любые типы данных,
иметь методы добавления и удаления
 */
public class Task_2 <T> {

    private Object[] arr;
    private int size;

    public Task_2 (int length) {
        this.arr = new Object[length];
    }

    public void addToArr(T element) {
        if (size >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = element;
    }

    public void removeElement(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                break;
            }

        }
    }


//    public void remove(int index) {
//    // Проверка пределов
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
//        }
//
//    // Копирование элементов
//        for (int i = index; i < size - 1; i++) {
//            arr[i] = arr[i + 1];
//        }
//
//        size--;
//    }
}
