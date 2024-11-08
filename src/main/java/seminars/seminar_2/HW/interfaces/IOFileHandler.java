package seminar_2.HW.interfaces;

public interface IOFileHandler {
    String readLogFromFile(String message);
    void saveLogToFile(String message);
}
