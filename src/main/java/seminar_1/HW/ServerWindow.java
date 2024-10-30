package seminar_1.HW;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    /*
    Задача: Создать простейшее окно управления сервером
    (по сути, любым), содержащее две кнопки (JButton) –
    запустить сервер и остановить сервер. Кнопки должны
    просто логировать нажатие (имитировать запуск и остановку
    сервера, соответственно) и выставлять внутри интерфейса
    соответствующее булево isServerWorking.
     */

    private static final int X = 400;
    private static final int Y = 500;
    private static final int W = 350;
    private static final int H = 450;
    private boolean isServerWorking;

    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JTextArea log = new JTextArea();

    ServerWindow() {
        setTitle("Chat group");
        setAlwaysOnTop(true);
        isServerWorking = false;
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    System.out.println("Server is running");
                    isServerWorking = true; // Обновляем значение переменной на true
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    System.out.println("Server is stopped");
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
