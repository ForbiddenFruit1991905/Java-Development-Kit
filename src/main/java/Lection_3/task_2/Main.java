package Lection_3.task_2;

public class Main {
    public static void main(String[] args) {
        Apples apple1 = new Apples();
        Apples apple2 = new Apples();
        Oranges orange1 = new Oranges();

//        Box<Fruits> fruitsBox = new Box<>();
//        fruitsBox.addFruit(new Oranges());
//        fruitsBox.addFruit(new Apples());
//        fruitsBox.addFruit(new Apples());
//        fruitsBox.addFruit(new Apples());
//        fruitsBox.addFruit(new Apples());

        Box<Apples> appleBox1 = new Box<>();
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);

        Box<Oranges> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);

        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        Box<Apples> appleBox2 = new Box<>();
        appleBox1.transferFruits(appleBox2);

        System.out.println("После пересыпания вес коробки с яблоками 1: " + appleBox1.getWeight());
        System.out.println("После пересыпания вес коробки с яблоками 2: " + appleBox2.getWeight());

        int res = appleBox1.compareTo(appleBox2);
        if (res == 1) {
            System.out.println("Первая коробка с яблоками тяжелее второй.");
        } else if (res == -1) {
            System.out.println("Первая коробка с яблоками легче второй.");
        } else if (res == 0) {
            System.out.println("Вес коробок с яблоками одинаковый.");
        }
    }
}
