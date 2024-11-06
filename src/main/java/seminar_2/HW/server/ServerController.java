package seminar_2.HW.server;

import seminar_2.HW.client.ClientGUI;
import seminar_2.HW.client.FileHandler;
import seminar_2.HW.interfaces.IOFileHandler;
import seminar_2.HW.interfaces.ServerView;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ServerController implements ServerView{

    ArrayList<ClientGUI> connectedClientsModel;
    private final JTextArea log = new JTextArea();
    IOFileHandler fileHandler;
    private boolean isServerWorking;

    public ServerController(IOFileHandler fileHandler) {
        this.fileHandler = fileHandler;
        connectedClientsModel = new ArrayList<>();
    }

    @Override
    public void logMessage(String message) {
        log.append(message + "\n");
        fileHandler.saveLogToFile(message);
        fileHandler.readLogFromFile(message);
    }

    @Override
    public void broadcastMessage(String message) {
        logMessage(message);
        for (ClientGUI client : connectedClientsModel) {
            client.logMessage(message);
        }
    }

    @Override
    public void msgClientLog(ClientGUI client) {
        try (FileReader fileReader = new FileReader(FileHandler.PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                client.logMessage(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectUser(String userLogin) {
        if (isServerWorking) {
            log.append("User: " + userLogin + " is connected to server\n");
        }
    }

    @Override
    public void registerClient(ClientGUI clientGUI) {
        if (!connectedClientsModel.contains(clientGUI)) {
            connectedClientsModel.add(clientGUI);
            msgClientLog(clientGUI);
        }
    }

    public void addUser(ClientGUI user) {
        connectedClientsModel.add(user)   ;
    }
}
