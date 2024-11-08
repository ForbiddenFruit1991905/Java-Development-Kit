package lections.Lection_2.Example_of_implementation_and_Exceptional;

public interface Human {
    // Поскольку все методы всегда публичные,
    // то этот модификатор принято не писать
    default void walk() {
        System.out.println("Walks on two legs");
    }

    public void talk();
}
