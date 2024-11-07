package seminar_3.HW.gb;

import java.io.File;
import java.io.IOException;
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
        realization.saveLogToFile();
        System.out.println(realization.readLogFromFile());
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
            userInformation.append(userInfo);
            userInformation.append("\n");
        }
        return userInformation.toString();
    }

    public void addUser(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
        String userInfo = getName() + " (" + getAge() + " years old): " + getMessage();

        FileHandler fileHandler = new FileHandler();
        fileHandler.setUserInfo(userInfo);
        fileHandler.saveLogToFile();
    }

    @Override
    public void removeUser() {
        users.remove(name);
    }

    @Override
    public String readLogFromFile() {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readLogFromFile();
    }

    @Override
    public void saveLogToFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readLogFromFile();
    }
}
