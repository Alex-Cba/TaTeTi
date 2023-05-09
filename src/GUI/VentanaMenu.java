package GUI;

import Usuarios.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenu extends JFrame implements ActionListener {
    private JButton jugarButton;
    private JButton salirButton;
    private JPanel PanelPrincipal;
    private InterfazGrafica tableroJuego;
    private Vent_Emergente vent_Emergente;

    public VentanaMenu()
    {
        setTitle("Ta Te Ti");
        setSize(756,500);
        setLocationRelativeTo(null);

        add(PanelPrincipal);

        //Colocar el cursor con forma de Mano
        jugarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jugarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jugarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jugarButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        salirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                salirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                salirButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        jugarButton.addActionListener(this);
        salirButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jugarButton) {

            JOptionPane.showMessageDialog(null, "Ingrese los nombre de los jugadores");

            vent_Emergente = new Vent_Emergente(this);

            if(vent_Emergente.isEstado()) {

                this.dispose();

                Jugador J1 = new Jugador(vent_Emergente.getJugador1Nombre(), vent_Emergente.getJugador1Eleccion());
                Jugador J2 = new Jugador(vent_Emergente.getJugador2Nombre(), vent_Emergente.getJugador2Eleccion());

                tableroJuego = new InterfazGrafica(J1, J2, vent_Emergente.getPrimerTurnoEleccion());
                SwingUtilities.invokeLater(new Runnable() {
                    @Override

                    public void run() {
                        tableroJuego.setVisible(true);
                    }
                });
            }
            else{
                JOptionPane.showMessageDialog(null, "Cancelando inicio de juego");
            }

        } else if (e.getSource() == salirButton) {

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro? Que desea salir de la aplicación", "", JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {

                System.exit(0);

            } else {
                //Vacio
            }

        }
    }
}
