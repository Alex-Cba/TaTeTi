package Usuarios;

public class Jugador {
    private String nombre;
    private int puntacion = 0;
    private String Ficha_Actual;
    private int partidas_ganadas =0;
    public String getNombre() {
        return nombre;
    }

    public int getPuntacion() {
        return puntacion;
    }

    public int getPartidas_ganadas() {
        return partidas_ganadas;
    }

    public void setPartidas_ganadas(int partidas_ganadas) {
        this.partidas_ganadas = partidas_ganadas;
    }

    public void setPuntacion(int puntacion) {
        this.puntacion = puntacion;
    }

    public String getFicha_Actual() {
        return Ficha_Actual;
    }
    public void setFicha_Actual(String ficha_Actual) {
        Ficha_Actual = ficha_Actual;
    }

    public Jugador(String nombre, String ficha) {
        this.nombre = nombre;
        this.Ficha_Actual = ficha;
    }
}
