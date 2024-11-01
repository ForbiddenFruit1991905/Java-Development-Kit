
package seminar_1.HW.server;

import seminar_1.HW.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ServerWindow extends JFrame {

    private static final int X = 400;
    private static final int Y = 400;
    private static final int W = 300;
    private static final int H = 300;
    private boolean isServerWorking;
    public static final String PATH = "src/main/java/seminar_1/HW/log.txt";

    private DefaultListModel<ClientGUI> connectedClientsModel = new DefaultListModel<>();
    private JList<ClientGUI> clientGUIList;
    private boolean isConnected = false;

    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JTextArea log = new JTextArea();

    public boolean addUser(ClientGUI clientGUI) {
        if (!isConnected) {
            return false;
        }
        connectedClientsModel.addElement(clientGUI);
        return true;
    }

    public void exitUser(ClientGUI clientGUI) {
        if (!isConnected || clientGUI != null) {
            connectedClientsModel.removeElement(clientGUI);
        }
    }

    public void logMessage(String message) {
        log.append(message + "\n");
        saveLogToFile();
        readLogFromFile();
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
        clientGUIList = new JList<>(connectedClientsModel);

        JScrollPane listScrollPane = new JScrollPane(clientGUIList);
        add(listScrollPane, BorderLayout.CENTER);

        setTitle("Chat group");
        setAlwaysOnTop(true);
//        isServerWorking = false;

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    logMessage("Server is running...\n");
                    isServerWorking = true;
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    logMessage("Server is stopped.\n");
                    isServerWorking = false;
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
        setVisible(true);


    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void connectUser(String selectedItem) {
    }

    public void registerClient(ClientGUI clientGUI) {
        if (!connectedClientsModel.contains(clientGUI)) {
            connectedClientsModel.addElement(clientGUI);
            msgClientLog(clientGUI);
        }
    }

    private void msgClientLog(ClientGUI client) {
        try (FileReader fileReader = new FileReader(PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //TODO возможно переделать метод logMessage
                logMessage(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new ServerWindow();
//    }
}

