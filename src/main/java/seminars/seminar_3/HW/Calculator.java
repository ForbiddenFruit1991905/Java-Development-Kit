package seminars.seminar_3.HW;
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

    public static <T extends Number, U extends Number> float sum(T a, U b) {
        return a.intValue() + b.floatValue();
    }

    public static <T extends Number, U extends Number> float multiply(T a, U b) {
        return a.intValue() * b.floatValue();
    }

    public static <T extends Number, U extends Number> float subtract(T a, U b) {
        return Math.abs(a.intValue() - b.floatValue());
    }

    public static <T extends Number, U extends Number> float divide(T a, U b) {
        if (b.floatValue() == 0) {
            throw new ArithmeticException("Ошибка при делении на ноль");
        }
        return a.intValue() / b.floatValue();
    }
}
