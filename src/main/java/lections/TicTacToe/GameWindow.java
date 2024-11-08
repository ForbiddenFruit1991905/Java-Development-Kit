package lections.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 507;
//    public static final int WINDOW_POS_X = 300;
//    public static final int WINDOW_POS_Y = 100;
    public static final String WINDOW_NAME = "lections/TicTacToe";

    JButton btnStart = new JButton("Start new Game");
    JButton btnExit = new JButton("Exit");

    GameMap gameMap;
    GameSettings settings;

    GameWindow() {
        // параметры окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_NAME);
        setResizable(false);

        //элементы основная часть
        gameMap = new GameMap();
        settings = new GameSettings(this);
        settings.setVisible(true);
        //обработчики кнопок
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                settings.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        //элементы нижняя часть (кнопки Start/Exit)
        JPanel panBottom = new JPanel((new GridLayout(1, 2)));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(gameMap);
        setVisible(true);
    }
    //TODO должен быть boolean mode???
    void startNewGame(int mode, int size_x, int size_y, int win_len){
//        gameMap.setVisible(true);
        gameMap.startNewGame(mode, size_x, size_y, win_len);
    }
}
