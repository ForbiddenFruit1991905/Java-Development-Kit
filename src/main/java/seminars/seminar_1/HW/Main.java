package seminar_1.HW;

import seminar_1.HW.server.ServerWindow;
import seminar_1.HW.client.ClientGUI;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();

        ClientGUI user1 = new ClientGUI(serverWindow);
        ClientGUI user2 = new ClientGUI(serverWindow);
        serverWindow.addUser(user1);
        serverWindow.addUser(user2);
    }
}
