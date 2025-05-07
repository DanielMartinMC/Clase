package Interfaces.Bloque1;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;



public class Ejercicio2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            crearVentana("Metal", UIManager.getCrossPlatformLookAndFeelClassName(), 100, 100);
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                crearVentana("FlatLightLaf", null, 500, 100);
            } catch (Exception e) {
                System.err.println("Error");
                e.printStackTrace();
            }
        });
    }

    private static void crearVentana(String titulo, String lookAndFeelClassName, int x, int y) {
        try {
            if (lookAndFeelClassName != null) {
                UIManager.setLookAndFeel(lookAndFeelClassName);
            }

            JFrame frame = new JFrame(titulo);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 2, 10, 10));
            frame.setSize(300, 150);
            frame.setLocation(x, y);

            frame.add(new JLabel("Nombre:"));
            frame.add(new JTextField(10));
            frame.add(new JLabel("Email:"));
            frame.add(new JTextField(10));
            frame.add(new JButton("Enviar"));
            frame.add(new JButton("Cancelar"));

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
