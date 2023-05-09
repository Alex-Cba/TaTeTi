package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vent_Emergente extends JDialog implements ActionListener
{
    private JLabel jugador2Label;
    private JLabel jugador1Label;
    private JTextField jugador1TextField;
    private JTextField jugador2TextField;
    private JRadioButton circuloButton_J1;
    private JRadioButton cruzButton_J1;
    private JRadioButton circuloButton_J2;
    private JRadioButton cruzButton_J2;
    private JButton okButton;
    private JPanel PanelPrincipal;
    private JLabel primerTurnoLabel;
    private JRadioButton circuloPrimer;
    private JRadioButton cruzPrimer;
    private String jugador1Nombre;
    private String jugador2Nombre;
    private String jugador1Eleccion;
    private String jugador2Eleccion;
    private String PrimerTurnoEleccion;
    private boolean Estado = false;
    public Vent_Emergente(VentanaMenu parent) {
        super(parent, true);
        setTitle("Ingresar nombres");
        setSize(580,250);
        setLocationRelativeTo(parent);

        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                okButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        okButton.addActionListener(this);
        circuloPrimer.addActionListener(this);
        cruzPrimer.addActionListener(this);
        circuloButton_J1.addActionListener(this);
        cruzButton_J1.addActionListener(this);
        circuloButton_J2.addActionListener(this);
        cruzButton_J2.addActionListener(this);


        setContentPane(PanelPrincipal);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            if(!jugador1TextField.getText().isEmpty() && !jugador2TextField.getText().isEmpty()) {

                jugador1Nombre = jugador1TextField.getText();
                jugador2Nombre = jugador2TextField.getText();

                if(circuloButton_J1.isSelected() && cruzButton_J2.isSelected())
                {
                    if(circuloPrimer.isSelected()) {

                        jugador1Eleccion = "Circulo";
                        jugador2Eleccion = "Cruz";
                        PrimerTurnoEleccion = "Circulo";

                        //Todo ok
                        Estado = true;

                        dispose();
                    }
                    else if(cruzPrimer.isSelected()) {

                        jugador1Eleccion = "Circulo";
                        jugador2Eleccion = "Cruz";
                        PrimerTurnoEleccion = "Cruz";

                        //Todo ok
                        Estado = true;

                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Seleccione que pieza comenzara la partida");
                    }
                }
                else if(cruzButton_J1.isSelected() && circuloButton_J2.isSelected())
                {
                    if(circuloPrimer.isSelected()) {

                        jugador1Eleccion = "Cruz";
                        jugador2Eleccion = "Circulo";
                        PrimerTurnoEleccion = "Circulo";

                        //Todo ok
                        Estado = true;

                        dispose();
                    }
                    else if(cruzPrimer.isSelected()) {

                        jugador1Eleccion = "Cruz";
                        jugador2Eleccion = "Circulo";
                        PrimerTurnoEleccion = "Cruz";

                        //Todo ok
                        Estado = true;

                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Seleccione que pieza comenzara la partida");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Seleccione que jugador tendra cada ficha respectivamente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Alguno de los nombres esta vacio, ingrese un nombre porfavor");
            }
        }
        else if (e.getSource() == circuloButton_J1)
        {
            SeleccionRadioButtons(true);
        }
        else if (e.getSource()==cruzButton_J1)
        {
            SeleccionRadioButtons(false);
        }
        else if (e.getSource() == circuloButton_J2)
        {
            SeleccionRadioButtons(false);
        }
        else if (e.getSource()==cruzButton_J2)
        {
            SeleccionRadioButtons(true);
        }
        else if (e.getSource()==circuloPrimer)
        {
            circuloPrimer.setSelected(true);
            cruzPrimer.setSelected(false);
        }
        else if (e.getSource()==cruzPrimer)
        {
            circuloPrimer.setSelected(false);
            cruzPrimer.setSelected(true);
        }
    }

    public String getJugador1Nombre() {
        return jugador1Nombre;
    }

    public String getJugador2Nombre() {
        return jugador2Nombre;
    }

    public String getJugador1Eleccion() {
        return jugador1Eleccion;
    }

    public String getJugador2Eleccion() {
        return jugador2Eleccion;
    }

    public String getPrimerTurnoEleccion() {
        return PrimerTurnoEleccion;
    }

    public boolean isEstado() {
        return Estado;
    }

    private void SeleccionRadioButtons(boolean x)
    {
        circuloButton_J1.setSelected(x);
        cruzButton_J1.setSelected(!x);
        circuloButton_J2.setSelected(!x);
        cruzButton_J2.setSelected(x);
    }

}
