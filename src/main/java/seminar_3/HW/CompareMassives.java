package seminar_3.HW;
/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы
одного типа по парно по индексам.
 */
public class CompareMassives {
    public static void main(String[] args) {
        Object[] arr1 = {1, "a", 3.4};
        Object[] arr2 = {4, "b", 2.4};
//        Object[] arr2 = {4, 5, 2.4};
        System.out.println(compareArrays(arr1, arr2));
    }

    public static boolean compareArrays(Object[] arr1, Object[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].getClass() != arr2[i].getClass()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
