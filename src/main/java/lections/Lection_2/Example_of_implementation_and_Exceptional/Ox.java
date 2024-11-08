package lections.Lection_2.Example_of_implementation_and_Exceptional;

public class Ox implements Bull {

    @Override
    public void walk() {
        System.out.println("Walks on hooves");
    }

    @Override
    public void talk() {
        System.out.println("MooooooooOOOOOooo");
    }
}
