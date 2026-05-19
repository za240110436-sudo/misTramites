package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscenaDNI extends JPanel {
    private JButton btnParte1, btnParte2;
    private JLabel lblEstado;
    private boolean parte1Lista = false;

    public EscenaDNI(CardLayout controlador, JPanel contenedorPrincipal) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        JLabel title = new JLabel("Trámite 1: Validación de Identidad (DNI)", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel puzlePanel = new JPanel(new GridLayout(1, 2, 10, 10));
        btnParte1 = new JButton("Firma Oficial [Clic para Vincular]");
        btnParte2 = new JButton("Fotografía Digital [Clic para Vincular]");

        btnParte1.addActionListener(e -> {
            parte1Lista = true;
            btnParte1.setEnabled(false);
            lblEstado.setText("Firma vinculada... ¡Falta la fotografía!");
        });

        btnParte2.addActionListener(e -> {
            if (parte1Lista) {
                lblEstado.setText("¡Trámite de DNI Completado con Éxito! +100 Puntos.");
                btnParte2.setEnabled(false);
                // Aquí puedes llamar al método para otorgar puntos cívicos
            } else {
                lblEstado.setText("¡Error! Debes vincular primero la Firma Oficial.");
            }
        });

        puzlePanel.add(btnParte1);
        puzlePanel.add(btnParte2);
        add(puzlePanel, BorderLayout.CENTER);

        lblEstado = new JLabel("Ordena el registro: Vincula primero la firma y luego la foto.", JLabel.CENTER);
        add(lblEstado, BorderLayout.SOUTH);
    }
}