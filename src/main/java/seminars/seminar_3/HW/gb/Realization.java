package seminars.seminar_3.HW.gb;

import java.util.ArrayList;

public class Realization implements IOManager{
    private ArrayList users;
    DB db;

    public Realization() {
        this.users =new ArrayList<>();
    }

    @Override
    public String findUser(String name) {
        if (db.getName() == name) {
            return name;
        } else {
            return "There's no such name";
        }
    }

    @Override
    public void removeUser(String name) {
        if (findUser(name).equals(name)) {
            users.remove(name);
        } else {
            System.out.println("There's no such name");
        }
    }
}
