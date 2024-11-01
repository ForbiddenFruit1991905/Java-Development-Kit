
package seminar_1.HW.server;

import seminar_1.HW.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ServerWindow extends JFrame {

    private static final int X = 400;
    private static final int Y = 400;
    private static final int W = 300;
    private static final int H = 300;
    private boolean isServerWorking;
    public static final String PATH = "src/main/java/seminar_1/HW/log.txt";

//    private DefaultListModel<ClientGUI> connectedClientsModel = new DefaultListModel<>();
//    private JList<ClientGUI> clientGUIList;
    private ArrayList<ClientGUI> connectedClientsModel = new ArrayList<>();
//    private boolean isConnected;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    public void logMessage(String message) {
        log.append(message + "\n");
        saveLogToFile();
        readLogFromFile();
    }
    //TODO если сервер работает,то broadcastMessage, если нет, то сообщение о незапуске сервера
    public void broadcastMessage(String message) {
        logMessage(message);
        for (ClientGUI client : connectedClientsModel) {
            client.sendMessage();
        }
    }

    private void msgClientLog(ClientGUI client) {
        try (FileReader fileReader = new FileReader(PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            String line;
            while ((bufferedReader.readLine()) != null) {
                //TODO возможно переделать метод logMessage
                client.sendMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLogToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
            writer.println(log.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLogFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerWindow() {
        connectedClientsModel = new ArrayList<>();

        JScrollPane listScrollPane = new JScrollPane();
        add(listScrollPane, BorderLayout.CENTER);

        setTitle("Chat group");
        setAlwaysOnTop(true);
        isServerWorking = false;

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    log.append("Server is running...\n");
                    isServerWorking = true;
//                    saveLogToFile();
//                    readLogFromFile();
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server is stopped.\n");
                    isServerWorking = false;
//                    saveLogToFile();
//                    readLogFromFile();
//                    resetClientPanels();
                }
            }
        });

        //Панелька кнопок
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);

        add(btnPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(W, H);
        setLocation(X, Y);
        log.setEditable(false);
        setVisible(true);
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void addUser(ClientGUI user) {
        connectedClientsModel.add(user)   ;
    }

    public void connectUser(String userLogin) {
        if (isServerWorking) {
            log.append("User: " + userLogin + " is connected to server\n");
        }
    }

    public void registerClient(ClientGUI clientGUI) {
        if (!connectedClientsModel.contains(clientGUI)) {
            connectedClientsModel.add(clientGUI);
            msgClientLog(clientGUI);
        }
    }

    private void resetClientPanels() {
        for (ClientGUI client : connectedClientsModel) {
            client.resetPanelTop();
        }
    }
     /*
    public boolean addUser(ClientGUI clientGUI) {
        if (!isConnected) {
            return false;
        }
        connectedClientsModel.add(clientGUI);
        return true;
    }

    public void exitUser(ClientGUI clientGUI) {
        if (!isConnected || clientGUI != null) {
            connectedClientsModel.remove(clientGUI);
        }
    }
    */

}

