package Test;

import GUI.InterfazGrafica;
import Usuarios.Jugador;
import Virtual_Tablero.vTablero;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TaTeTiTest
{
    /*
    @Test
    public void MovimientoValidoTest()
    {
        vTablero tablero_virtual = vTablero.getInstance();
        assertTrue(tablero_virtual.MovimientoValido(1,1));
        assertFalse(tablero_virtual.MovimientoValido(-1,-1));
        assertFalse(tablero_virtual.MovimientoValido(5,5));
    }

     */

    @Test
    public void testMovValido() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Jugador jugador1 = new Jugador("Alex", "Cruz");
        Jugador jugador2 = new Jugador("Matias", "Cruz");
        InterfazGrafica GUI = new InterfazGrafica(jugador1, jugador2,"Cruz");
        JButton btnActual = new JButton();

        Method metodoPrivado = GUI.getClass().getDeclaredMethod("MovValido", JButton.class);
        metodoPrivado.setAccessible(true);

        boolean resultado = (boolean) metodoPrivado.invoke(GUI, btnActual);
        assertEquals(false, resultado);
    }
}
