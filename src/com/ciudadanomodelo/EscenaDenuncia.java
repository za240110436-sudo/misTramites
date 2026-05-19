package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class EscenaDenuncia extends JPanel {
    private JComboBox<String> comboProblema;
    private JComboBox<String> comboDependencia;
    private JLabel lblResultado;

    public EscenaDenuncia(CardLayout controlador, JPanel contenedorPrincipal) {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBackground(new Color(245, 255, 250));

        add(new JLabel("Trámite 3: Sistema de Reporte Ciudadano (Baches e Infraestructura)", JLabel.CENTER));

        String[] problemas = {"Selecciona problema...", "Bache en Avenida", "Fuga de Agua Crítica"};
        String[] dependencias = {"Selecciona oficina...", "Atención del Agua", "Obras Públicas e Infraestructura"};

        comboProblema = new JComboBox<>(problemas);
        comboDependencia = new JComboBox<>(dependencias);
        JButton btnReportar = new JButton("Enviar Denuncia");

        JPanel selectores = new JPanel(new FlowLayout());
        selectores.add(comboProblema);
        selectores.add(new JLabel(" canalizar a "));
        selectores.add(comboDependencia);
        add(selectores);

        lblResultado = new JLabel("Conecta correctamente el reporte con la oficina responsable.", JLabel.CENTER);
        add(lblResultado);

        btnReportar.addActionListener(e -> {
            int pIdx = comboProblema.getSelectedIndex();
            int dIdx = comboDependencia.getSelectedIndex();

            if ((pIdx == 1 && dIdx == 2) || (pIdx == 2 && dIdx == 1)) {
                lblResultado.setText("¡Denuncia canalizada con éxito! El bache/fuga será atendido.");
            } else {
                lblResultado.setText("¡Fallo de enrutamiento! La oficina seleccionada rechazó el reporte.");
            }
        });
        add(btnReportar);
    }
}