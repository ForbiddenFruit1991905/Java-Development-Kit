package Lection_2.animation_circles.Example_of_implementation;

public class Main {
    public static void main(String[] args) {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Human man1 = new Man();
        Bull ox1 = new Ox();

        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos = new Minotaurus();

        Bull[] allBulls = {ox0, ox1, minos0, minos};
        Human[] allHumans = {man0, man1, minos, minos1};
    }
}
