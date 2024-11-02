package Lection_2.Example_of_implementation;

public interface Bull {
    public static final int amount = 2;
    default void walk() {
        System.out.println("Walks on " + amount + " hooves");
    }

    void talk();
}
