package Lection_2.Example_of_implementation_and_Exceptional;

// Для реализации интерфейса необходимо переопределить все его методы,
// либо сделать класс абстрактным.

public class Man implements Human{

    @Override
    public void walk() {
        System.out.println("Walks on two feet");
    }

    @Override
    public void talk() {
        System.out.println("Talks meaningful words");
    }
}
