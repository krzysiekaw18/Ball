import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 550;
    private static final int DEFAULT_HEIGHT = 350;
    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball b){
        balls.add(b);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics); //czyszczenie tła
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (Ball b : balls) {
            graphics2D.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}