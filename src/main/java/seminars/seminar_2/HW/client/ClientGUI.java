package seminar_2.HW.client;

import seminar_2.HW.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientGUI extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private final JTextArea msgLog = new JTextArea();
    private final ServerGUI serverGUI;
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
    JTextField msg = new JTextField();
    JButton btnSend = new JButton("Send");

    public ClientGUI(ServerGUI serverGUI) {
        this.serverGUI = serverGUI;
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
                if (serverGUI.isServerWorking()) {
                    topFields.setVisible(false);
                    msg.setEnabled(true);
                    btnSend.setEnabled(true);
                    msgLog.append("Successful user connection\n");
                    loginConnection = true;
                    serverGUI.server.connectUser((String) login_list.getSelectedItem());
                    serverGUI.server.registerClient(ClientGUI.this);
                } else {
                    msgLog.append("Server is not running\n");
                }
            }
        });

        ActionListener sendActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        };
        msg.addActionListener(sendActionListener);
        btnSend.addActionListener(sendActionListener);

        setVisible(true);
    }

    public void sendMessage() {
        if(!loginConnection) {
            logMessage("User is not connected.\n");
            return;
        }
        if (msg.getText().isEmpty()) {
            logMessage("Message cannot be empty.\n");
            return;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String selectedUser = (String) login_list.getSelectedItem();
        String message = "Date: " + localDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " user: " + selectedUser + ": " + msg.getText();
        if (serverGUI.isServerWorking()) {
            msg.setText("");
            serverGUI.server.broadcastMessage(message);
        } else {
            logMessage("Server is not running\n");
        }
    }
    
    public void logMessage(String msg) {
        msgLog.append(msg + "\n");
    }

}
