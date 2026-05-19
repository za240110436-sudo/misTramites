package com.ciudadanomodelo;

import javax.swing.*;
import java.awt.*;

public class EscenaImpuestos extends JPanel {
    private int saldoPendiente = 350;
    private JLabel lblSaldo;

    public EscenaImpuestos(CardLayout controlador, JPanel contenedorPrincipal) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 245, 238));

        JLabel lblTitulo = new JLabel("Trámite 2: Liquidación de Impuesto Predial");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo);

        lblSaldo = new JLabel("Saldo total pendiente de balancear: $" + saldoPendiente);
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblSaldo);

        JButton btnSubsidioA = new JButton("Aplicar Descuento por Sustentabilidad (-$200)");
        JButton btnSubsidioB = new JButton("Aplicar Subsidio de Inclusión Social (-$150)");
        
        btnSubsidioA.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubsidioB.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSubsidioA.addActionListener(e -> actualizarSaldo(200, btnSubsidioA));
        btnSubsidioB.addActionListener(e -> actualizarSaldo(150, btnSubsidioB));

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnSubsidioA);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnSubsidioB);
    }

    private void actualizarSaldo(int deduccion, JButton boton) {
        saldoPendiente -= deduccion;
        boton.setEnabled(false);
        if (saldoPendiente == 0) {
            lblSaldo.setText("¡Balance Perfecto! Impuestos pagados correctamente.");
        } else if (saldoPendiente < 0) {
            lblSaldo.setText("¡Error! Saldo negativo, balance incorrecto. Reinicia el trámite.");
        } else {
            lblSaldo.setText("Saldo restante: $" + saldoPendiente);
        }
    }
}