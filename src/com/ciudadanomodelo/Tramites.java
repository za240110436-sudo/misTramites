package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class Tramites extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel contenedorPrincipal = new JPanel(cardLayout);

    public Tramites() {
        setTitle("Ciudadano Modelo - Mapa General de la Ciudad");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Instanciar los paneles individuales
        JPanel panelMapa = new EscenaMapa(cardLayout, contenedorPrincipal);
        JPanel panelDNI = new EscenaDNI(cardLayout, contenedorPrincipal);
        JPanel panelImpuestos = new EscenaImpuestos(cardLayout, contenedorPrincipal);
        JPanel panelDenuncia = new EscenaDenuncia(cardLayout, contenedorPrincipal);

        // Añadirlos al gestor de escenas (CardLayout)
        contenedorPrincipal.add(panelMapa, "Mapa");
        contenedorPrincipal.add(panelDNI, "DNI");
        contenedorPrincipal.add(panelImpuestos, "Impuestos");
        contenedorPrincipal.add(panelDenuncia, "Denuncia");

        // Barra superior de navegación para poder regresar siempre al Menú de la Ciudad
        JPanel barraNavegacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        barraNavegacion.setBackground(Color.LIGHT_GRAY);
        
        JButton btnIrMapa = new JButton("🗺️ Ir al Mapa General");
        btnIrMapa.setFont(new Font("Arial", Font.BOLD, 12));
        btnIrMapa.addActionListener(e -> cardLayout.show(contenedorPrincipal, "Mapa"));
        
        barraNavegacion.add(btnIrMapa);

        getContentPane().add(barraNavegacion, BorderLayout.NORTH);
        getContentPane().add(contenedorPrincipal, BorderLayout.CENTER);

        // Forzar a que la escena inicial por defecto sea el Mapa Urbano
        cardLayout.show(contenedorPrincipal, "Mapa");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tramites().setVisible(true);
        });
    }
}