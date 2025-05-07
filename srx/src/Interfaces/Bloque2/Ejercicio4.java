package Interfaces.Bloque2;

import javax.swing.*;
import java.awt.*;


public class Ejercicio4 {
    static class MiPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);
            g2d.fillRect(20, 50, 200, 65);
            g2d.setColor(Color.black);
            g2d.setFont(new Font("Times New Roman", Font.BOLD, 50));
            g2d.drawString("MiLogo", 20, 100);

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MiLogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.add(new MiPanel());
        frame.setVisible(true);
    }
}

