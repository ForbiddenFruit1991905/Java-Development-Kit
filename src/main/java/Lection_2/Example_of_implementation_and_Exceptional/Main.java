package Lection_2.Example_of_implementation_and_Exceptional;

public class Main {
    public static void main(String[] args) {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Human man1 = new Man();
        Bull ox1 = new Ox();

        // При использовании интерфейсов важно то, что классы не связаны между
        // собой наследованием, а обращение к ним единообразно
        Bull minos0 = new Minotaurs();
        Human minos1 = new Minotaurs();
        Minotaurs minos = new Minotaurs();

        Bull[] allBulls = {ox0, ox1, minos0, minos};
        Human[] allHumans = {man0, man1, minos, minos1};
    }
}
