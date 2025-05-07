package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio7 extends JFrame {
    private JPanel pColor;
    public Ejercicio7() {
        setTitle("Selector de Color");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel pColor = new JPanel();
        pColor.setBackground(Color.WHITE);
        pColor.setBorder(BorderFactory.createLineBorder(Color.BLACK,2 ));
        add(pColor, BorderLayout.CENTER);

        JPanel pBotones = new JPanel();

        JButton boton1 = crearBoton("Boton1", Color.RED);
        JButton boton2 = crearBoton("Boton2", Color.BLUE);
        JButton boton3 = crearBoton("Boton3", Color.GREEN);

        pBotones.add(boton1);
        pBotones.add(boton2);
        pBotones.add(boton3);

        add(pBotones);
    }
    private JButton crearBoton(String color, Color c) {
        JButton boton = new JButton(color);
        boton.setBackground(c);
        boton.setForeground(c);
        boton.setBorder(BorderFactory.createLineBorder(c, 2));
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pColor.setBackground(c);
            }
        });

        return boton;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           Ejercicio7 colores = new Ejercicio7();
           colores.setVisible(true);
        });
    }
}
