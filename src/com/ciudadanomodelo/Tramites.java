package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class Tramites extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel contenedorPrincipal = new JPanel(cardLayout);

    public Tramites() {
        setTitle("Ciudadano Modelo - Módulo de Trámites e Interacción");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Instanciar los paneles individuales
        JPanel panelDNI = new EscenaDNI(cardLayout, contenedorPrincipal);
        JPanel panelImpuestos = new EscenaImpuestos(cardLayout, contenedorPrincipal);
        JPanel panelDenuncia = new EscenaDenuncia(cardLayout, contenedorPrincipal);

        // Añadirlos al gestor de escenas
        contenedorPrincipal.add(panelDNI, "DNI");
        contenedorPrincipal.add(panelImpuestos, "Impuestos");
        contenedorPrincipal.add(panelDenuncia, "Denuncia");

        // Botones superiores de navegación entre trámites
        JPanel barraNavegacion = new JPanel(new FlowLayout());
        JButton btnIrDNI = new JButton("Trámite DNI");
        JButton btnIrImpuestos = new JButton("Pago Predial");
        JButton btnIrDenuncia = new JButton("Reportar Bache");

        btnIrDNI.addActionListener(e -> cardLayout.show(contenedorPrincipal, "DNI"));
        btnIrImpuestos.addActionListener(e -> cardLayout.show(contenedorPrincipal, "Impuestos"));
        btnIrDenuncia.addActionListener(e -> cardLayout.show(contenedorPrincipal, "Denuncia"));

        barraNavegacion.add(btnIrDNI);
        barraNavegacion.add(btnIrImpuestos);
        barraNavegacion.add(btnIrDenuncia);

        getContentPane().add(barraNavegacion, BorderLayout.NORTH);
        getContentPane().add(contenedorPrincipal, BorderLayout.CENTER);
    }

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tramites().setVisible(true);
        });
    }
}