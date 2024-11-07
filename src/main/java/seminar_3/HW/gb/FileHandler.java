package seminar_3.HW.gb;

import java.io.*;

public class FileHandler implements IOFileHandler {

    public static String PATH = "src/main/java/seminar_3/HW/gb/users.txt";

    @Override
    public boolean saveLogToFile(String info) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
            writer.println(info);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readLogFromFile(String info) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}

