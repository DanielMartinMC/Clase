package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        FlatLaf();

        JFrame frame = new JFrame("Hola Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Centrar ventana

        JLabel label = new JLabel("Hola Mundo", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));

        frame.add(label);
        frame.setVisible(true);
    }

    private static void FlatLaf() {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Error: " + e.getMessage());
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}
