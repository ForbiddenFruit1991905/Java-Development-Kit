package seminar_1.HW.server;

import seminar_1.HW.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ServerWindow extends JFrame {
    /*
    Задача: Создать простейшее окно управления сервером
    (по сути, любым), содержащее две кнопки (JButton) –
    запустить сервер и остановить сервер. Кнопки должны
    просто логировать нажатие (имитировать запуск и остановку
    сервера, соответственно) и выставлять внутри интерфейса
    соответствующее булево isServerWorking.
    *Добавить на окно компонент JtextArea и выводить
    сообщения сервера в него, а не в терминал.
     */

    private static final int X = 400;
    private static final int Y = 400;
    private static final int W = 300;
    private static final int H = 300;
    private boolean isServerWorking;
    public static final String PATH = "src/main/java/seminar_1/HW/log.txt";

    private JList<ClientGUI> clientGUIList;
    private boolean isConnected = false;

    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JTextArea log = new JTextArea();

    public void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public JList<ClientGUI> getConnectedClients() {
        return clientGUIList;
    }

    public void addUser(ClientGUI clientGUI) {
        if (isConnected) {
            clientGUIList.add(clientGUI);
            clientGUI.setConnected(true);
        }
    }

    public void exitUser(ClientGUI clientGUI) {
        if (isConnected) {
            clientGUIList.remove(clientGUI);
            clientGUI.setConnected(false);
        }
    }

    public void logMessage(String message) {
        log.append(message + "n");
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
                log.append(line + "n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerWindow() {
        clientGUIList = new JList<>();
        DefaultListModel clientList = new DefaultListModel<>();
//        clientGUIList.setModel(new DefaultListModel<>()); // Устанавливаем модель для JList
        clientList.addElement("Alice");
        clientList.addElement("Bob");
        clientList.addElement("Charlie");
        clientGUIList.setModel(clientList);


        JScrollPane listScrollPane = new JScrollPane(clientGUIList); // Добавляем JList в JScrollPane для прокрутки
        add(listScrollPane, BorderLayout.CENTER); // Добавляем JScrollPane в центральную часть панели

        setTitle("Chat group");
        setAlwaysOnTop(true);
        isServerWorking = false;

        log.setEditable(false); // Чтобы запретить редактирование
        JScrollPane scrollPane = new JScrollPane(log); // Добавление прокрутки для JTextArea
        add(scrollPane);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    System.out.println("Server is running...");
                    log.append("Server is running...\n");
                    isServerWorking = true; // Обновляем значение переменной на true
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    System.out.println("Server is stopped...");
                    log.append("Server is stopped...\n");
                    isServerWorking = false; // Обновляем значение переменной на false
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(X, Y, W, H);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }
}
