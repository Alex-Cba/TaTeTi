package GUI;

import Controladores.Controlador_Turno;
import Cruz_Y_Circulo.Circulo;
import Cruz_Y_Circulo.Cruz;
import TodosSprites.All_Sprites;
import Usuarios.Jugador;
import Virtual_Tablero.vTablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame
{
    private Cruz _cruz = new Cruz();
    private Circulo _circulo = new Circulo();
    private JPanel panel_3x3 = new JPanel(new GridLayout(3,3));
    private All_Sprites _All_Sprites = All_Sprites.getInstance();
    private Controlador_Turno ctrl_turno;
    private vTablero Matriz_Tablero = vTablero.getInstance();
    private String Ganador = "";
    private String Perdedor = "";

    private int fila = -1;
    private int columna = 1;
    private String Comenzo = "";
    private Jugador J1;
    private Jugador J2;

    private JLabel labelJugadores = new JLabel("");
    private JLabel labelHistorialPartidas = new JLabel("");
    private Color colorBtn = new Color(238,238,238);
    public InterfazGrafica(Jugador J1, Jugador J2, String turno){
        this.J1 = J1;
        this.J2 = J2;
        ctrl_turno = Controlador_Turno.getInstance(turno);
        Comenzo = turno;

        //3ancho x 3largo
        JFrame ventana = this;
        ventana.setTitle("TaTeTi");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(612, 512);
        ventana.setLocationRelativeTo(null);

        //Label de partidas jugadas
        labelHistorialPartidas.setBounds(15, 450, 600, 20);
        labelHistorialPartidas.setForeground(Color.white);

        //Label de jugadores
        labelJugadores.setBounds(15, 5, 600, 20);
        labelJugadores.setForeground(Color.white);

        //Borde a todos los lados del panel
        panel_3x3.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel_3x3.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 9; i++) {

            JButton button = new JButton();
            button.setBackground(colorBtn);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton btn_actual = (JButton) e.getSource();

                    if(MovValido(btn_actual))
                    {

                        if (ctrl_turno.getTurnoActual().equalsIgnoreCase("Cruz"))
                        {
                            btn_actual.setIcon(_cruz.getSpr_cruz());

                            Matriz_Tablero.AgregarFicha("Cruz", fila, columna);

                            ctrl_turno.CambiarTurno();

                            EjecutarWinConditions();
                        }
                        else if (ctrl_turno.getTurnoActual().equalsIgnoreCase("Circulo"))
                        {
                            btn_actual.setIcon(_circulo.getSpr_circulo());

                            Matriz_Tablero.AgregarFicha("Circulo", fila, columna);

                            ctrl_turno.CambiarTurno();

                            EjecutarWinConditions();
                        }

                        if(Matriz_Tablero.CheckMatrizLlena())
                        {
                            Ganador = "Empate";
                            Perdedor = "Empate";
                            Puntajes();

                            JOptionPane.showMessageDialog(null, "El tablero se lleno por completo, sin un ganador." + "\n"
                                                                + "Esta ronda se declara Empate");

                            ReiniciarJuego();
                        }

                        if(!Ganador.equalsIgnoreCase(""))
                        {
                            Comenzo = ctrl_turno.getTurnoActual(); //Obtiene el turno del jugador que perdio la ronda

                            JOptionPane.showMessageDialog(null, "El ganador es: " + Ganador + "." +"\n"
                                                            + "El jugador " + Perdedor + " perdio ");
                            ReiniciarJuego();
                        }

                        ActualizaNombresLabel();
                        ActualizaHistorialPartidasLabel();

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La casilla ya contiene una ficha");
                    }
                }
            });

            panel_3x3.add(button);
        }

        ActualizaNombresLabel();
        ActualizaHistorialPartidasLabel();

        add(labelJugadores);
        add(labelHistorialPartidas);
        add(panel_3x3);
    }

    private boolean MovValido(JButton btn_Actual){
        boolean retorno = false;

        Component[] componentes = panel_3x3.getComponents();
        int lugar = -1;
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i].equals(btn_Actual)) {
                lugar = i;
                break;
            }
        }

        fila = lugar / 3;
        columna = lugar % 3;

        retorno = Matriz_Tablero.MovimientoValido(fila, columna);

        return  retorno;
    }

    private String EjecutarWinConditions()
    {
        if(Ganador.equals("")){
            Ganador = Matriz_Tablero.WinCondition_Vertical();
        }
        if (Ganador.equals("")) {
            Ganador=Matriz_Tablero.WinCondition_Horizontal();
        }
        if (Ganador.equals("")){
            Ganador=Matriz_Tablero.WinConditionDiagonal();
        }

        Puntajes();

        return Ganador;
    }

    private void Puntajes()
    {
        int resultado_ganador = 0;
        int resultado_perdedor = 0;
        int partida = 0;
        if(J1.getFicha_Actual().equalsIgnoreCase(Ganador))
        {
            if(J1.getFicha_Actual().equalsIgnoreCase(Comenzo))
            {
                resultado_ganador = J1.getPuntacion() + 3;
                resultado_perdedor = J2.getPuntacion() + 1;
            }
            else if(!J1.getFicha_Actual().equalsIgnoreCase(Comenzo))
            {
                resultado_ganador = J1.getPuntacion() + 4;
                resultado_perdedor = J2.getPuntacion() + 1;
            }

            J1.setPuntacion(resultado_ganador);
            J2.setPuntacion(resultado_perdedor);

            partida = J1.getPartidas_ganadas() +1;
            J1.setPartidas_ganadas(partida);
            Ganador = J1.getNombre();
            Perdedor = J2.getNombre();
        }
        else if (J2.getFicha_Actual().equalsIgnoreCase(Ganador))
        {
            if(J2.getFicha_Actual().equalsIgnoreCase(Comenzo))
            {
                resultado_ganador = J2.getPuntacion() + 3;
                resultado_perdedor = J1.getPuntacion() + 1;
            }
            else if(!J2.getFicha_Actual().equalsIgnoreCase(Comenzo))
            {
                resultado_ganador = J2.getPuntacion() + 4;
                resultado_perdedor = J1.getPuntacion() + 1;
            }

            J1.setPuntacion(resultado_perdedor);
            J2.setPuntacion(resultado_ganador);

            partida = J2.getPartidas_ganadas() +1;
            J2.setPartidas_ganadas(partida);
            Ganador = J2.getNombre();
            Perdedor = J1.getNombre();
        }
        else if(Ganador.equalsIgnoreCase("Empate") && Perdedor.equalsIgnoreCase("Empate"))
        {
            int resultado_empate = 0;

            if(J1.getFicha_Actual().equalsIgnoreCase(Comenzo))
            {
                resultado_empate = J1.getPuntacion() +1;
                J1.setPuntacion(resultado_empate);
                resultado_empate = J2.getPuntacion() +2;
                J2.setPuntacion(resultado_empate);
            }
            else if (J2.getFicha_Actual().equalsIgnoreCase(Comenzo)) {
                resultado_empate = J2.getPuntacion() +1;
                J2.setPuntacion(resultado_empate);
                resultado_empate = J1.getPuntacion() +2;
                J1.setPuntacion(resultado_empate);
            }

        }
    }

    private void ReiniciarJuego()
    {
        for (Component c : panel_3x3.getComponents())
        {
            if (c instanceof JButton) {
                c.setBackground(colorBtn);
                ((JButton) c).setIcon(null);
            }
        }
        Ganador="";
        Perdedor="";
        Matriz_Tablero.ReiniciarMatriz();
        fila = -1;
        columna = -1;
    }
    private void ActualizaNombresLabel(){

        if( J1 != null && J2 != null) {
            labelJugadores.setText(J1.getNombre() + ": " + J1.getPuntacion() + " | " + J2.getNombre() + ": " + J2.getPuntacion());
        }
    }

    private void ActualizaHistorialPartidasLabel(){

        if( J1 != null && J2 != null) {
            labelHistorialPartidas.setText(J1.getNombre() + ", partidas ganadas: " + J1.getPartidas_ganadas() + " | " + J2.getNombre() + ", partidas ganadas: " + J2.getPartidas_ganadas());
        }
    }
}
