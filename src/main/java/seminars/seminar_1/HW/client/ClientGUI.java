package seminar_1.HW.client;

import seminar_1.HW.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientGUI extends JFrame {
    /*
    Создать окно клиента чата. Окно должно содержать JtextField
    для ввода логина, пароля, IP-адреса сервера, порта подключения
    к серверу, область ввода сообщений, JTextArea область просмотра
    сообщений чата и JButton подключения к серверу и отправки сообщения
    в чат. Желательно сразу сгруппировать компоненты, относящиеся
    к серверу сгруппировать на JPanel сверху экрана, а компоненты,
    относящиеся к отправке сообщения – на JPanel снизу.
    *Добавить на экран компонент JList – имитацию списка пользователей, заполнить этот список
    несколькими выдуманными именами пользователей чата. Подсказка: компонент не может добавлять
    или убирать элементы списка, он работает с методом setListData(), изучите его аргументы.
    Домашнее задание:
    1. Отправлять сообщения из текстового поля сообщения в лог
    по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
    2. Продублировать импровизированный лог (историю) чата в файле;
    3. При запуске клиента чата заполнять поле истории из файла, если он существует.
    Обратите внимание, что чаще всего история сообщений хранится на сервере
    и заполнение истории чата лучше делать при соединении с сервером, а не при
    открытии окна клиента.
     */
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private final JTextArea msgLog = new JTextArea();
    private final ServerWindow serverWindow;
    private boolean loginConnection;

    JPanel topFields = new JPanel(new GridLayout(3, 2));
    JTextField ip = new JTextField("000.0.0.0");
    JTextField port = new JTextField("8080");
    JPasswordField password = new JPasswordField("54321");
    JButton btnLogin = new JButton("Login");

    private static final String[] login ={"V_M", "D_S", "S_D"};

    private final JComboBox login_list = new JComboBox<>(login); // JComboBox - для выпадающего списка

    JPanel bottomFields = new JPanel(new BorderLayout());
    JPanel msgField = new JPanel(new BorderLayout());
    JTextField msg = new JTextField(/*"some message"*/);
    JButton btnSend = new JButton("Send");

    public void sendMessage() {
        if(loginConnection == false) {
            msgLog.append("User is not connected.\n");
            return;
        }
        if (msg.getText().isEmpty()) {
            msgLog.append("Message cannot be empty.\n");
            return;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        // LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"))
        String selectedUser = (String) login_list.getSelectedItem();
        String message = "Date: " + localDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " user: " + selectedUser + ": " + msg.getText();
        if (serverWindow.isServerWorking()) {
            msg.setText("");
            serverWindow.broadcastMessage(message);
        } else {
            msgLog.append("Server is not running\n");
        }
    }

    public ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat group");

        topFields.add(ip);
        topFields.add(port);
        topFields.add(login_list);
        topFields.add(password);
        topFields.add(btnLogin);
        add(topFields, BorderLayout.NORTH);

        msgField.add(msg, BorderLayout.CENTER);
        msgField.add(btnSend, BorderLayout.EAST);
        bottomFields.add(msgField, BorderLayout.CENTER);
        add(bottomFields, BorderLayout.SOUTH);

        msgLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(msgLog);
        add(scrollPane);
        
        msg.setEnabled(false);

        loginConnection = false;

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.isServerWorking()) {
                    topFields.setVisible(false);
                    msg.setEnabled(true);
                    btnSend.setEnabled(true);
                    msgLog.append("Successful user connection\n");
                    loginConnection = true;
                    serverWindow.connectUser((String) login_list.getSelectedItem());
                    serverWindow.registerClient(ClientGUI.this);
                } else {
                    msgLog.append("Server is not running\n");
                }
            }
        });

        ActionListener sendActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                sendMessage();
            }
        };
        msg.addActionListener(sendActionListener);
        btnSend.addActionListener(sendActionListener);

        setVisible(true);
    }

    public void logMessage(String msg) {
        msgLog.append(msg + "\n");
    }

}
