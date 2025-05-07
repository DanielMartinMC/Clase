package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;


public class Ejercicio10 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Diseño con BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JButton button = new JButton("NORTH");
        frame.add(button, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setText("CENTER");
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);


        JLabel label = new JLabel("SOUTH", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); // Espaciado
        frame.add(label, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}