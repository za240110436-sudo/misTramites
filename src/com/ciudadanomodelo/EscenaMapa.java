package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class EscenaMapa extends JPanel {

    public EscenaMapa(CardLayout controlador, JPanel contenedorPrincipal) {
        // Usamos un BorderLayout como base para estructurar los elementos ordenadamente
        setLayout(new BorderLayout(15, 15));
       setBackground(new Color(245, 237, 214)); // Color beige crema corregido
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- ENCABEZADO ---
        JPanel panelHeader = new JPanel(new GridLayout(2, 1));
        panelHeader.setOpaque(false);
        
        JLabel lblTitulo = new JLabel("MIS TRÁMITES", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(44, 62, 80));
        
        JLabel lblSubtitulo = new JLabel("Aprende a realizar tus trámites en GDL", JLabel.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSubtitulo.setForeground(new Color(127, 140, 141));
        
        panelHeader.add(lblTitulo);
        panelHeader.add(lblSubtitulo);
        add(panelHeader, BorderLayout.NORTH);

        // --- PANEL CENTRAL CONTENEDOR DE SECCIONES ---
        JPanel panelCentral = new JPanel(new BorderLayout(15, 15));
        panelCentral.setOpaque(false);

        // 1. Zona Superior: Los 2 Botones Grandes Destacados
        JPanel panelGrandes = new JPanel(new GridLayout(1, 2, 15, 15));
        panelGrandes.setOpaque(false);

        JButton btnBiblioteca = new JButton("<html><center>⭐ <b>BIBLIOTECA DE GUÍAS</b></center></html>");
        btnBiblioteca.setBackground(new Color(46, 139, 87)); // Verde bosque
        btnBiblioteca.setForeground(Color.WHITE);
        btnBiblioteca.setFont(new Font("Arial", Font.BOLD, 14));
        // Aquí puedes vincular una escena futura de guías si lo requieren
        btnBiblioteca.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abriendo Biblioteca de Guías..."));

        JButton btnJuegos = new JButton("<html><center>🕒 <b>ZONA DE JUEGOS Y TUTORIALES</b></center></html>");
        btnJuegos.setBackground(new Color(41, 128, 185)); // Azul brillante
        btnJuegos.setForeground(Color.WHITE);
        btnJuegos.setFont(new Font("Arial", Font.BOLD, 14));
        btnJuegos.addActionListener(e -> controlador.show(contenedorPrincipal, "DNI")); // Envía al primer puzle

        panelGrandes.add(btnBiblioteca);
        panelGrandes.add(btnJuegos);
        panelCentral.add(panelGrandes, BorderLayout.NORTH);

        // 2. Zona Inferior: Los 4 Botones de Trámites Frecuentes
        JPanel panelTramites = new JPanel(new GridLayout(1, 4, 12, 12));
        panelTramites.setOpaque(false);

        // Botón 1: Tutorial RFC (Sintonizado con tu juego de Impuestos/Predial)
        JButton btnRFC = new JButton("<html><center>📄<br><br><b>Tutorial RFC</b></center></html>");
        btnRFC.setBackground(new Color(78, 134, 138));
        btnRFC.setForeground(Color.WHITE);
        btnRFC.setFont(new Font("Arial", Font.PLAIN, 13));
        btnRFC.addActionListener(e -> controlador.show(contenedorPrincipal, "Impuestos"));

        // Botón 2: Guía INE (Sintonizado con tu juego de DNI)
        JButton btnINE = new JButton("<html><center>🪪<br><br><b>Guía INE</b></center></html>");
        btnINE.setBackground(new Color(192, 57, 43));
        btnINE.setForeground(Color.WHITE);
        btnINE.setFont(new Font("Arial", Font.PLAIN, 13));
        btnINE.addActionListener(e -> controlador.show(contenedorPrincipal, "DNI"));

        // Botón 3: Solicitud Actas (Sintonizado con tu puzle de Denuncia/Conexiones)
        JButton btnActas = new JButton("<html><center>📜<br><br><b>Solicitud Actas</b></center></html>");
        btnActas.setBackground(new Color(39, 174, 96));
        btnActas.setForeground(Color.WHITE);
        btnActas.setFont(new Font("Arial", Font.PLAIN, 13));
        btnActas.addActionListener(e -> controlador.show(contenedorPrincipal, "Denuncia"));

        // Botón 4: Otros Trámites
        JButton btnOtros = new JButton("<html><center>📁<br><br><b>Otros Trámites</b></center></html>");
        btnOtros.setBackground(new Color(52, 152, 219));
        btnOtros.setForeground(Color.WHITE);
        btnOtros.setFont(new Font("Arial", Font.PLAIN, 13));
        btnOtros.addActionListener(e -> JOptionPane.showMessageDialog(this, "Módulo en desarrollo para la siguiente etapa cívica."));

        panelTramites.add(btnRFC);
        panelTramites.add(btnINE);
        panelTramites.add(btnActas);
        panelTramites.add(btnOtros);
        
        panelCentral.add(panelTramites, BorderLayout.CENTER);
        add(panelCentral, BorderLayout.CENTER);

        // --- BARRA INFERIOR DE CRÉDITOS / ENLACES ---
        JLabel lblFooter = new JLabel("Trámites Frecuentes | Guías | Contacto", JLabel.CENTER);
        lblFooter.setFont(new Font("Arial", Font.BOLD, 12));
        lblFooter.setForeground(new Color(52, 73, 94));
        add(lblFooter, BorderLayout.SOUTH);
    }
}