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

    public int getParteNumerica(String placa) {
        int res = 0;

        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res * 10 + Character.getNumericValue(c);
            }
        }
        return res % 10;
    }



    public void validarNumPlaca() {
        if (restriccion()) {
            etiqueta2.setText("La placa " + campo.getText() + " CIRCULA");
        } else
            etiqueta2.setText("La placa Num: "+campo.getText() +"NO circula");
        verificacion.setVisible(true);

    }

    public boolean restriccion() {

        boolean restiction = true;
        String numPlaca = campo.getText();//devuelve lo que tenemos en el campo en int
        int numero = getParteNumerica(numPlaca);

        if (numero == 0 || numero == 1) {
            if (Calendar.DAY_OF_WEEK == 0) {
                restiction = false;
            }
        }
        if (numero == 2 || numero == 3) {
            if (Calendar.DAY_OF_WEEK == 1) {
                restiction = false;
            }
        }
        if (numero == 4 || numero == 5) {
            if (Calendar.DAY_OF_WEEK == 2) {
                restiction = false;
            }
        }
        if (numero == 6 || numero == 7) {
            if (Calendar.DAY_OF_WEEK == 3) {
                restiction = false;
            }
        }
        if (numero == 8 || numero == 9) {
            if (Calendar.DAY_OF_WEEK == 4) {
                restiction = false;
            }
        }
        return restiction;
    }


}



