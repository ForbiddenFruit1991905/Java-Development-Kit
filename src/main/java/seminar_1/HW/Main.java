package seminar_1.HW;

import seminar_1.HW.server.ServerWindow;
import seminar_1.HW.client.ClientGUI;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ServerWindow();
        new ClientGUI(serverWindow);
    }
}
