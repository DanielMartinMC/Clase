package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;

public class Ejercicio9 extends JFrame {

    public Ejercicio9() {

        setTitle("Formulario simple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lNombre = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(20);
        pNombre.add(lNombre);
        pNombre.add(nombreField);

        JPanel pEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lEdad = new JLabel("Edad:");
        JTextField nField = new JTextField(20);
        pEdad.add(lEdad);
        pEdad.add(nField);

        JPanel pBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton Boton = new JButton("Enviar");
        pBoton.add(Boton);

        panel.add(pNombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pEdad);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pBoton);

        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio9 formulario = new Ejercicio9();
            formulario.setVisible(true);
        });
    }
}
