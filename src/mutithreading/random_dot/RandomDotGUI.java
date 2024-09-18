package mutithreading.random_dot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomDotGUI extends JFrame implements ActionListener {
    private Dotty dotty;
    private JPanel controls = new JPanel();
    private JPanel canvas = new JPanel();
    private JButton draw = new JButton("Draw");
    private JButton clear = new JButton("Clear");
    private final int NDOTS = 1000;

    public RandomDotGUI() {
        getContentPane().setLayout(new BorderLayout());
        draw.addActionListener(this);
        clear.addActionListener(this);
        controls.add(draw);
        controls.add(clear);
        canvas.setBorder(BorderFactory.createTitledBorder("Drawing Canvas"));
        getContentPane().add("North", controls);
        getContentPane().add("Center", canvas);
        getContentPane().setSize(400, 400);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == draw) {
            dotty = new Dotty(canvas, NDOTS);
            Thread dottyThread = new Thread(dotty);
            dottyThread.start();
        } else {
            dotty.clear();
        }
    }

    public static void main(String args[]) {
        RandomDotGUI gui = new RandomDotGUI();
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
