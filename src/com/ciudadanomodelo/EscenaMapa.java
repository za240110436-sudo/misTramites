package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class EscenaMapa extends JPanel {

    public EscenaMapa(CardLayout controlador, JPanel contenedorPrincipal) {
        // Diseño de cuadrícula urbana (Grid de 2x2 para los edificios del mapa)
        setLayout(new GridLayout(2, 2, 20, 20));
        setBackground(new Color(135, 206, 235)); // Color azul cielo de fondo
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // --- Edificio 1: Registro Civil ---
        JButton btnRegistro = new JButton("<html><center><b>KIOSCO MUNICIPAL</b><br>Trámite de DNI</center></html>");
        btnRegistro.setBackground(new Color(144, 238, 144)); // Verde pasto
        btnRegistro.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRegistro.addActionListener(e -> controlador.show(contenedorPrincipal, "DNI"));

        // --- Edificio 2: Tesorería ---
        JButton btnTesoreria = new JButton("<html><center><b>TESORERÍA MUNICIPAL</b><br>Pago de Predial</center></html>");
        btnTesoreria.setBackground(new Color(255, 215, 0)); // Color Oro/Dinero
        btnTesoreria.setFont(new Font("Arial", Font.PLAIN, 14));
        btnTesoreria.addActionListener(e -> controlador.show(contenedorPrincipal, "Impuestos"));

        // --- Edificio 3: Obras Públicas ---
        JButton btnObras = new JButton("<html><center><b>OBRAS PÚBLICAS</b><br>Reportar un Bache</center></html>");
        btnObras.setBackground(new Color(255, 160, 122)); // Color Ladrillo/Alerta
        btnObras.setFont(new Font("Arial", Font.PLAIN, 14));
        btnObras.addActionListener(e -> controlador.show(contenedorPrincipal, "Denuncia"));

        // --- Casilla 4: Panel decorativo de Estado del Avatar ---
        JPanel panelAvatar = new JPanel(new GridLayout(2, 1));
        panelAvatar.setBackground(new Color(245, 245, 220));
        panelAvatar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        
        JLabel lblAvatar = new JLabel("Avatar: Ciudadano Activo", JLabel.CENTER);
        lblAvatar.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel lblMision = new JLabel("Misión: Selecciona un edificio", JLabel.CENTER);
        
        panelAvatar.add(lblAvatar);
        panelAvatar.add(lblMision);

        // Agregar los componentes en orden al mapa urbano
        add(btnRegistro);
        add(btnTesoreria);
        add(btnObras);
        add(panelAvatar);
    }
}