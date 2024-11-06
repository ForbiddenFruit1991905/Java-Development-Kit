package Lection_3.task_1;

public class ArraySwap {
    /*
    Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
     */
    public static <T> void swapElements(T[] intArray, int i1, int i2) {
            T temp = intArray[i1];
            intArray[i1] = intArray[i2];
            intArray[i2] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        swapElements(intArray, 1, intArray.length - 1);
        for (Integer i : intArray) {
            System.out.println(i);
        }
    }
}
