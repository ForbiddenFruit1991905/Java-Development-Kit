package seminar_2.HW.client;

import seminar_2.HW.interfaces.IOFileHandler;

import java.io.*;

public class FileHandler implements IOFileHandler {

    public static String PATH = "src/main/java/seminar_2/HW/log.txt";

    public void saveLogToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
            writer.write(message);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLogFromFile(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (FileReader reader = new FileReader(PATH)){
//            int c;
//            while ((c = reader.read()) != -1){
//                stringBuilder.append((char) c);
//            }
//            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
//            return stringBuilder.toString();
//        } catch (Exception e){
//            e.fillInStackTrace();
//            return null;
//        }
//    }
        return message;
    }
}
