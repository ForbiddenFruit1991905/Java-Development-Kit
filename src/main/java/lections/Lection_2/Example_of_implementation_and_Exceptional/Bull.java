package lections.Lection_2.Example_of_implementation_and_Exceptional;

public interface Bull {
    public static final int amount = 2;
    default void walk() {
        System.out.println("Walks on " + amount + " hooves");
    }

    void talk();
}
