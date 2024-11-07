package seminar_3.HW;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция. Методы должны возвращать результат своей работы.
 */
public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        float b = 2.5F;
//        float b = 0;
        System.out.println(sum(a, b));
        System.out.println(multiply(a, b));
        System.out.println(subtract(a, b));
        System.out.println(divide(a, b));
    }

    public static float sum(int a, float b) {
        return a + b;
    }

    public static float multiply(int a, float b) {
        return a * b;
    }

    public static float subtract(int a, float b) {
        return Math.abs(a - b);
    }

    public static float divide(int a, float b) {
        if (b == 0) {
            throw new ArithmeticException("Ошибка при делении на ноль");
        }
        return a / b;
    }
}
