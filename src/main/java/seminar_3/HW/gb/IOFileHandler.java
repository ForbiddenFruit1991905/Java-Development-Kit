package seminar_3.HW.gb;
/*
Создайте интерфейс, который определяет набор
методов для работы с базой данных (например,
сохранение, удаление, получение данных).
 */
public interface IOFileHandler {
    String readLogFromFile(String info);
    boolean saveLogToFile(String info);
}