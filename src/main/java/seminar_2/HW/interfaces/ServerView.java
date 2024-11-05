package seminar_2.HW.interfaces;

import seminar_2.HW.client.ClientGUI;

public interface ServerView {
    void registerClient(ClientGUI clientGUI);
    void connectUser(String userLogin);
    void msgClientLog(ClientGUI client);
    void broadcastMessage(String message);
    void logMessage(String message);
}
