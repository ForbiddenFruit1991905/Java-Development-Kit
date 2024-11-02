package Lection_2.animation_circles;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    // метод для перерисовки канвы (принимает от канвы ряд параметров и распределяет
    // их по методам обновления и рендеринга.)
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    // метод изменяет состояние приложения
    private void update(MainCanvas canvas, float deltaTime) {
    }

    // метод отдает команды рисующимся компонентам
    private void render(MainCanvas canvas, Graphics g) {
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
