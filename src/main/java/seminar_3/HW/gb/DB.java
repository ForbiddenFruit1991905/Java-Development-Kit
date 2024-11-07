package seminar_3.HW.gb;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
Создайте интерфейс, который определяет набор
методов для работы с базой данных (например,
сохранение, удаление, получение данных).
Реализуйте этот интерфейс в конкретном классе.
 */
public class DB implements IOManager, IOFileHandler {

    private String name;
    private int age;
    private String message;
    private ArrayList users;
    IOFileHandler fileHandler;
    IOManager ioManager;

    public DB() {
        this.users = new ArrayList();
        this.fileHandler = new FileHandler();
        this.ioManager = new Realization();
    }

    public void getList() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (Object user : users) {
                System.out.println(((DB) user).getName() + " (" + ((DB) user).getAge() + " years old): " + ((DB) user).getMessage());
            }
        }
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
//        StringBuilder userInformation = new StringBuilder();
//        userInformation.append("Users:\n");
//        for (Object userInfo : users) {
//            userInformation.append(userInfo);
//            userInformation.append("\n");
//        }
//        return userInformation.toString();
        StringBuilder userInformation = new StringBuilder();
        userInformation.append("Users:\n");
        for (Object user : users) {
            userInformation.append(((DB) user).getName())
                    .append(" (")
                    .append(((DB) user).getAge())
                    .append(" years old): ")
                    .append(((DB) user).getMessage())
                    .append("\n");
        }
        return userInformation.toString();
    }

    public void addUser(String name, int age, String message) {
        DB newUser = new DB();
        newUser.name = name;
        newUser.age = age;
        newUser.message = message;
        users.add(newUser);

        String userInfo = name + " (" + age + " years old): " + message;;

        FileHandler fileHandler = new FileHandler();
        fileHandler.setUserInfo(userInfo);
        fileHandler.saveLogToFile();
    }

    @Override
    public String readLogFromFile() {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readLogFromFile();
    }

    @Override
    public void saveLogToFile() {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.readLogFromFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt"))) {
            for (Object user : users) {
                writer.println(((DB) user).getName() + " (" + ((DB) user).getAge() + " years old): " + ((DB) user).getMessage());
            }
            System.out.println("Данные успешно сохранены в файл users.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    @Override
    public String findUser(String name) {
        for (Object user : users) {
            if (((DB) user).getName().equals(name)) {
                System.out.printf("User: %s is found\n", ((DB) user).getName());
                return name;
            }
        }
        return "There's no such name";
    }

    @Override
    public void removeUser(String name) {
        for (Object user : users) {
            if (((DB) user).getName().equals(name)) {
                System.out.printf("User: %s is deleted\n", name);
                users.remove(user);
                break;
            }
        }
        getList();
    }
}
