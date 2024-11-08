package lections.Lection_2.Example_of_implementation_and_Exceptional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exceptional extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private Exceptional(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        JButton btn = new JButton("Push me!");
        btn.addActionListener(this);
        add(btn);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new ArrayIndexOutOfBoundsException("something bad happened");
    }

    public static void main(String[] args) {
        // Статический метод, в который передаётся экземпляр
        // анонимного класса, реализующего интерфейс, и в
        // переопределяемом методе создаётся окно.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });
    }
    // Интерфейс содержит один метод – непойманное исключение,
    // который принимает на вход поток, в котором
    // произошло исключение и объект исключения, которое произошло.
    // Пример окна с исключением
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(),
                "Exception!", JOptionPane.ERROR_MESSAGE);
    }
}
