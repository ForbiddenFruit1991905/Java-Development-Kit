package seminar_1.HW.task_2;

import javax.swing.*;
import java.awt.*;

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
    private static final JTextArea msgLog = new JTextArea();

    JPanel topFields = new JPanel(new GridLayout(3, 2));
    JTextField ip = new JTextField("000.0.0.0");
    JTextField port = new JTextField("8080");
    JTextField login = new JTextField("v_m");
    JPasswordField password = new JPasswordField("54321");
    JButton btnLogin = new JButton("Login");

    JPanel bottomFields = new JPanel(new BorderLayout());
    JPanel msgField = new JPanel(new BorderLayout());
    JTextField msg = new JTextField("some message");
    JButton btnSend = new JButton("Send");
    
    public ClientGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat group");

        topFields.add(ip);
        topFields.add(port);
        topFields.add(login);
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

        setVisible(true);

    }

    
}
