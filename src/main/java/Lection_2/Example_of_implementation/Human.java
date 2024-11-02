package Lection_2.Example_of_implementation;

public interface Human {
    // Поскольку все методы всегда публичные,
    // то этот модификатор принято не писать
    default void walk() {
        System.out.println("Walks on two legs");
    }

    public void talk();
}
