package seminar_2.HW;

import seminar_1.HW.server.ServerWindow;
import seminar_2.HW.client.ClientGUI;
import seminar_2.HW.client.FileHandler;
import seminar_2.HW.interfaces.IOFileHandler;
import seminar_2.HW.interfaces.ServerView;
import seminar_2.HW.server.ServerController;
import seminar_2.HW.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        IOFileHandler fileHandler = new FileHandler();
        ServerView serverView = new ServerController(fileHandler);
        ServerGUI serverGUI = new ServerGUI(serverView);

        new ClientGUI(serverGUI);
        new ClientGUI(serverGUI);
    }
}
