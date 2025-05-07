package Interfaces.Bloque3;

import javax.swing.*;
import java.awt.*;

public class Ejercicio5 extends JFrame {

    public Ejercicio5() {

        setTitle("Formulario de Contacto");
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

        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lEmail= new JLabel("Email:");
        JTextField fEmail = new JTextField(20);
        pEmail.add(lEmail);
        pEmail.add(fEmail);

        JPanel pMensaje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lMensaje = new JLabel("Mensaje:");
        JTextArea aMensaje = new JTextArea(5, 20);
        aMensaje.setLineWrap(true);
        JScrollPane sPane = new JScrollPane(aMensaje);
        pMensaje.add(lMensaje);
        pMensaje.add(sPane);

        JPanel pBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton Boton = new JButton("Enviar");
        pBoton.add(Boton);

        panel.add(pNombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pEmail);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pMensaje);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(pBoton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio5 formulario = new Ejercicio5();
            formulario.setVisible(true);
        });
    }
}