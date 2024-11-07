package seminar_3.HW.gb;

import java.awt.*;
import java.util.ArrayList;

/*
Создайте интерфейс, который определяет набор
методов для работы с базой данных (например,
сохранение, удаление, получение данных).
Реализуйте этот интерфейс в конкретном классе.
 */
public class Realization implements IOManager, IOFileHandler {
    
    public static void main(String[] args) {
        Realization realization = new Realization();
        realization.addUser("V", 33, "hi");
        realization.addUser("D", 34, "hallo");
        System.out.println(realization);
        realization.saveLogToFile("Testing saveLogToFile method.");
        System.out.println(realization.readLogFromFile("Testing readLogFromFile method."));
    }
    private String name;
    private int age;
    private String message;
    private ArrayList users;
    IOFileHandler fileHandler;

    public Realization() {
        this.users = new ArrayList();
        this.fileHandler = new FileHandler();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        StringBuilder userInformation = new StringBuilder();
        userInformation.append("Users:\n");
        for (Object userInfo : users) {
            userInformation.append(userInfo).append("\n");
        }
        return userInformation.toString();
    }

    public void addUser(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
        String userInfo = name + " (" + age + " years old): " + message;
        users.add(userInfo);
        saveLogToFile(userInfo);
        readLogFromFile(userInfo);
    }

    @Override
    public void removeUser() {
        users.remove(name);
    }

    @Override
    public String readLogFromFile(String info) {
        return info;
    }

    @Override
    public boolean saveLogToFile(String info) {
        System.out.println(info);
        return false;
    }
}
