package lections.Lection_6.test.src.main.java;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public void printFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        System.out.println(new String((inputStream.readAllBytes())));
    }

    public static void main(String[] args) throws IOException {
       new Main().printFile();
    }
}
