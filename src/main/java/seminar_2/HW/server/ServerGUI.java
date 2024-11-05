
package seminar_2.HW.server;

import seminar_2.HW.interfaces.ServerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {

    private static final int X = 400;
    private static final int Y = 400;
    private static final int W = 300;
    private static final int H = 300;
    private boolean isServerWorking;
    public ServerView server;
    private final JTextArea log = new JTextArea();

    public ServerGUI(ServerView server) {
        this.server = server;

        JScrollPane listScrollPane = new JScrollPane();
        add(listScrollPane, BorderLayout.CENTER);

        setTitle("Chat group");
        setAlwaysOnTop(true);
        isServerWorking = false;

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    log.append("Server is running...\n");
                    isServerWorking = true;
                }
            }
        });
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server is stopped.\n");
                    isServerWorking = false;
                }
            }
        });

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

}

