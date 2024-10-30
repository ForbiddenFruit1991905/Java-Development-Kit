package seminar_1.HW.task_1;

import javax.swing.*;
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
    *Добавить на окно компонент JtextArea и выводить
    сообщения сервера в него, а не в терминал.
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

        log.setEditable(false); // Чтобы запретить редактирование
        JScrollPane scrollPane = new JScrollPane(log); // Добавление прокрутки для JTextArea
        add(scrollPane);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    System.out.println("Server is running");
                    log.append("Server is running\n");
                    isServerWorking = true; // Обновляем значение переменной на true
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    System.out.println("Server is stopped");
                    log.append("Server is stopped\n");
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
