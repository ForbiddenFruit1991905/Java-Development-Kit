package Lection_2.animation_circles.Example_of_implementation;

public class Minotaurus implements Human, Bull {

    @Override
    public void walk() {
        System.out.println("Walks on two legs");
    }

    @Override
    public void talk() {
        System.out.println("Asks you a riddle");
    }
}
