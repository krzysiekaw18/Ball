import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame {//ramka z componentem i przyciskami
    private BallComponent comp;
    public static final int STEPS = 10000;
    public static final int DELAY = 5;

    public BounceFrame() {//ramka z START i ZAMKNIJ oraz odbijającą się piłką
        setTitle("Crazy Ball");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "START", event -> addBall());
        addButton(buttonPanel, "ZAMKNIJ", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container container, String title, ActionListener listener) {//dodaje przyciski do kontenera
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable runnable = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.repaint();
//                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
