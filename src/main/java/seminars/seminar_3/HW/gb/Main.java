package seminars.seminar_3.HW.gb;

public class Main {
    public static void main(String[] args) {
        DB realization = new DB();
        realization.addUser("V", 33, "hi");
        realization.addUser("D", 34, "hallo");
        realization.addUser("K", 15, "gutten morgen");
        System.out.println(realization);
        realization.saveLogToFile();
        System.out.println(realization.readLogFromFile());
        realization.getList();
        
        realization.findUser("D");
        realization.removeUser("K");
        
    }
}
