package Controladores;

import Usuarios.Jugador;

public class Controlador_Turno
{
    private static Controlador_Turno Instance = null;
    private String turnoActual = "";
    private String turnoEmpezo = "";
    private Jugador jugador1;
    private Jugador jugador2;
    public String getTurnoActual() {
        return turnoActual;
    }

    public String getTurnoEmpezo() {
        return turnoEmpezo;
    }

    public void setTurnoEmpezo(String turnoEmpezo) {
        this.turnoEmpezo = turnoEmpezo;
    }

    private Controlador_Turno(String turnoActual) {

        this.turnoActual = turnoActual;
    }

    //Singleton
    public static Controlador_Turno getInstance(String _turnoActual){
        if(_turnoActual.equalsIgnoreCase("Cruz") || _turnoActual.equalsIgnoreCase("Circulo")) {
            if (Instance == null) {
                Instance = new Controlador_Turno(_turnoActual);
            }
        }

        return Instance;
    }

    public void CambiarTurno(){

        if(turnoActual.equalsIgnoreCase("Cruz")){
            turnoActual = "Circulo";
        } else if (turnoActual.equalsIgnoreCase("Circulo")) {
            turnoActual = "Cruz";
        }
    }
}
