package seminar_3.HW.gb;

import java.io.*;

public class FileHandler implements IOFileHandler {
    private static String PATH = "src/main/java/seminar_3/HW/gb/users.txt";
    private String userInfo;

    @Override
    public void saveLogToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
            writer.println(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readLogFromFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}

