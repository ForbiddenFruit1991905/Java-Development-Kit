package Lection_2.Example_of_implementation_and_Exceptional;

// Реализация множества интерфейсов

public class Minotaurs implements Human, Bull {

    @Override
    public void walk() {
        System.out.println("Walks on two legs");
    }

    @Override
    public void talk() {
        System.out.println("Asks you a riddle");
    }
}
