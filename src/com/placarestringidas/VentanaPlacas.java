package com.placarestringidas;

import java.util.Calendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaPlacas extends JFrame {
    private JLabel etiqueta1, etiqueta2;
    private JTextField campo;
    private JButton validaPlaca;
    private JDialog verificacion;

    public VentanaPlacas() throws HeadlessException {
        super("Verificacion de circulacion de Placas");// titulo de la ventana
        etiqueta1 = new JLabel("Ingrese Numero de Placa");
        campo = new JTextField(10);
        validaPlaca = new JButton("Verificar");

        verificacion = new JDialog(this);
        verificacion.setSize(400, 250);
        etiqueta2 = new JLabel(" ");

        FlowLayout diseño = new FlowLayout();
        setLayout(diseño);

        add(etiqueta1);
        add(campo);
        add(validaPlaca);

        verificacion.add(etiqueta2);

        validaPlaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarNumPlaca();
            }
        });

    }

    public void validarNumPlaca() {
        if (restriccion()) {
            etiqueta2.setText("La placa " + campo.getText() + " CIRCULA");
        } else
            etiqueta2.setText("La placa Num: "+campo.getText() +"NO circula");
        verificacion.setVisible(true);

    }


}



