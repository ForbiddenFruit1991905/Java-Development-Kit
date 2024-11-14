package org.example;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public void printFile() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("org/example/hello.txt");
        if (inputStream != null) {
            System.out.println(new String(inputStream.readAllBytes()));
        } else {
            System.out.println("Файл не найден");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().printFile();
    }
}

