package TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettings extends JFrame {
    private static final int WINDOW_HEIGHT = 350;
    private static final int WINDOW_WIDTH = 230;
//    private JButton btnStart;
    static public int sliderSizeValue = 3;
    static public int sliderWinValue = 3;

    /*
    Задание 1
    Задача: Добавить на экран компоновщик-сетку
    с одним столбцом и добавить над существующей
    кнопкой следующие компоненты в заданном
    порядке: JLabel с заголовком «Выберите режим
    игры», сгруппированные в ButtonGroup
    переключаемые JRadioButton с указанием режимов
    «Человек против компьютера» и «Человек против
    человека», JLabel с заголовком «Выберите размеры
    поля», JLabel с заголовком «Установленный размер
    поля:», JSlider со значениями 3..10, JLabel
    с заголовком «Выберите длину для победы», JLabel
    с заголовком «Установленная длина: », JSlider
    со значениями 3..10.
    Задание 2
    Задача: Добавить компонентам
    интерактивности, а именно, при перемещении
    ползунка слайдера в соответствующих лейблах
    должны появляться текущие значения
    слайдеров. Для этого необходимо добавить
    к слайдеру слушателя изменений (как это было
    сделано для действия кнопки).
     */
    
    JLabel labelMode = new JLabel("Выберите режим игры:");
    JRadioButton HVB = new JRadioButton("Человек против Человека", true);
    JRadioButton HVA = new JRadioButton("Человек против Компьютера", false);
//    ButtonGroup topButtonGroup = new ButtonGroup();
    JLabel labelSize = new JLabel(String.format("Выберите размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);
    JLabel labelWin = new JLabel(String.format("Выберите длину для победы: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);
    JButton btnStart = new JButton("Запуск новой игры");
    JPanel grid = new JPanel(new GridLayout(9, 1));
//    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel topButton = new JPanel(new GridLayout(2, 1));
//    JPanel middle = new JPanel(new GridLayout(2,1));
//    JPanel bottom = new JPanel(new GridLayout(2,1));

    GameSettings(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        grid.add(labelMode);
        grid.add(HVB);
        grid.add(HVA);
        grid.add(topButton);
        grid.add(topButton);
        grid.add(labelSize);
        grid.add(sliderSize);
        grid.add(labelWin);
        grid.add(sliderWin);
        grid.add(btnStart);

//        topButtonGroup.add(HVB);
//        topButtonGroup.add(HVA);
//        topButton.add(HVB);
//        topButton.add(HVA);
//
//        top.add(labelMode);
//        top.add(topButton);
//
//        top.add(labelMode);
//        top.add(topButton);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                sliderSizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Установите размер поля: %d", sliderSizeValue));
            }
        });
//        middle.add(labelSize);
//        middle.add(sliderSize);

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                sliderWinValue = sliderWin.getValue();
                labelWin.setText(String.format("Установите длину для победы: %d", sliderWinValue));
            }
        });
//        bottom.add(labelWin);
//        bottom.add(sliderWin);

//        grid.add(top);
//        grid.add(middle);
//        grid.add(bottom);
//        grid.add(btnStart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                gameWindow.startNewGame(0, sliderSizeValue, sliderSizeValue, sliderWinValue);
            }
        });
        add(grid);

//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                gameWindow.startNewGame(0, 3, 3, 3);
//            }
//        });
//        add(btnStart);
        
    }
}
