package lections.Lection_2.animations.common;

public class MouseAdapter implements MouseListener {
    @Override
    public void mouseUp() {

    }

    @Override
    public void mouseDown() {

    }

    private static void addMouseListener(MouseListener l) {
        l.mouseDown();
        l.mouseUp();
    }

    // Способ использования API через именованный класс
    public static void main(String[] args) {
        // Возможные способы создания обработчиков событий
        MouseAdapter m = new MouseAdapter();
        addMouseListener(m);
        addMouseListener(new MouseAdapter());
        MouseListener l = new MouseListener() {
            @Override
            public void mouseUp() {
                
            }

            @Override
            public void mouseDown() {

            }
        };
        addMouseListener(l);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseUp() {
                
            }

            @Override
            public void mouseDown() {

            }
        });
    }
}
