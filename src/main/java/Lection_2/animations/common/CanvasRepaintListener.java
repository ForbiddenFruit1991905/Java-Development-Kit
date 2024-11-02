package Lection_2.animations.common;

import java.awt.*;

// Интерфейс слушателя событий канвы
public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
