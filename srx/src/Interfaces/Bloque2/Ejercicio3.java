package Interfaces.Bloque2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ejercicio3 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLUE);
        g2d.fillRect(20, 50, 100, 60);

        g2d.setColor(Color.RED);
        g2d.draw(new Ellipse2D.Double(150, 70, 80, 80));

        g2d.setColor(Color.GREEN);
        int[] x = {100,130,70};
        int[] y = {150,200,200};
        Polygon Triangulo = new Polygon(x,y,3);
        g2d.fillPolygon(Triangulo);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejercicio3");
        frame.add(new Ejercicio3());
        frame.setSize(300, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

