package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;

public class Ejercicio6 extends JFrame {

    public Ejercicio6() {
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Ventana dividida con BorderLayout");
        add(titulo, BorderLayout.NORTH);

        JTextArea texto = new JTextArea();
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        JScrollPane atexto = new JScrollPane(texto);
        atexto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(atexto, BorderLayout.CENTER);

        JPanel pBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBoton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton Boton = new JButton("Confirmar");
        pBoton.add(Boton);
        add(pBoton, BorderLayout.SOUTH);


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            Ejercicio6 ventana = new Ejercicio6();
            ventana.setVisible(true);
        });
    }


}
