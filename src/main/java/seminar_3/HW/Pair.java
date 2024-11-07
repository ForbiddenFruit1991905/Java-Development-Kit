package seminar_3.HW;
/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из
составляющих пары, а также переопределение метода toString(), возвращающее строковое
представление пары.
 */
public class Pair  <T, U> {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println(pair.toString());
    }

    private T t;
    private U u;

    public Pair(T first, U second) {
        this.t = first;
        this.u = second;
    }

    public T getFirst() {
        return t;
    }

    public U getSecond() {
        return u;
    }

    @Override
    public String toString() {
        return getFirst().getClass() + " " + getSecond().getClass();
    }
    
}
