package Virtual_Tablero;

public class vTablero
{
    private static vTablero Instance = null;
    private String[][] Matriz_Tablero;

    private vTablero() {
        Matriz_Tablero = new String[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) {
                Matriz_Tablero[i][j] = "";
            }
        }
    }

    public static vTablero getInstance() {
        if(Instance == null)
        {
            Instance = new vTablero();
        }
        return Instance;
    }

    public String[][] getMatriz_Tablero() {
        return Matriz_Tablero;
    }

    public boolean AgregarFicha(String Ficha, int fila, int columna){
        boolean retorno = false;
        if(Ficha.equalsIgnoreCase("Cruz") || Ficha.equalsIgnoreCase("Circulo"))
        {
            Matriz_Tablero[fila][columna] = Ficha;
            retorno = true;
        }

        return retorno;
    }

    public boolean MovimientoValido(int fila, int columna){
        boolean retorno = false;
        if(fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2)
        {
            if(Matriz_Tablero[fila][columna] == "" || Matriz_Tablero[fila][columna] == null)
            {
                retorno = true;
            }
        }

        return retorno;
    }

    public String WinCondition_Vertical()
    {
        String Ganador= "";
        int contadorCruz = 0;
        int contadorCirculo = 0;


        //Vertical
        for (int j = 0; j < 3; j++) //Recorrer columnas
        {
            contadorCruz = 0;
            contadorCirculo = 0;
            for (int i = 0; i < 3; i++) //Recorrer filas
            {
                if(!Matriz_Tablero[i][j].equalsIgnoreCase(""))
                {
                    if (Matriz_Tablero[i][j].equalsIgnoreCase("Cruz")) {
                        contadorCruz++;
                        contadorCirculo = 0;
                    } else if (Matriz_Tablero[i][j].equalsIgnoreCase("Circulo")) {
                        contadorCirculo++;
                        contadorCruz = 0;
                    }

                    if (contadorCruz >= 3) {
                        Ganador = "Cruz";
                        break;
                    } else if (contadorCirculo >= 3) {
                        Ganador = "Circulo";
                        break;
                    }
                }
                else
                {
                    contadorCruz = 0;
                    contadorCirculo = 0;
                    break;
                }
            }
            if (!Ganador.equals("")) {
                break;
            }
        }


        return Ganador;
    }

    public String WinCondition_Horizontal()
    {
        String Ganador= "";
        int contadorCruz = 0;
        int contadorCirculo = 0;


        //Vertical
        for (int i = 0; i < 3; i++) //Recorrer filas
        {
            contadorCruz = 0;
            contadorCirculo = 0;
            for (int j = 0; j < 3; j++) //Recorrer columnas
            {
                if(!Matriz_Tablero[i][j].equalsIgnoreCase("")) {
                    if (Matriz_Tablero[i][j].equalsIgnoreCase("Cruz")) {
                        contadorCruz++;
                        contadorCirculo = 0;
                    } else if (Matriz_Tablero[i][j].equalsIgnoreCase("Circulo")) {
                        contadorCirculo++;
                        contadorCruz = 0;
                    }

                    if (contadorCruz >= 3) {
                        Ganador = "Cruz";
                        break;
                    } else if (contadorCirculo >= 3) {
                        Ganador = "Circulo";
                        break;
                    }
                }
                else
                {
                    contadorCruz = 0;
                    contadorCirculo = 0;
                    break;
                }
            }
            if (!Ganador.equals("")) {
                break;
            }
        }


        return Ganador;
    }

    public String WinConditionDiagonal() {
        String Ganador = "";

        //Diagonal Desde Arriba a la izquierda, a Abajo a la derecha
        if(!Matriz_Tablero[0][0].equalsIgnoreCase("")) {
            if (Matriz_Tablero[0][0].equalsIgnoreCase("Cruz")
                && Matriz_Tablero[1][1].equalsIgnoreCase("Cruz")
                && Matriz_Tablero[2][2].equalsIgnoreCase("Cruz"))
            {
                Ganador = "Cruz";
            }
            else if (Matriz_Tablero[0][0].equalsIgnoreCase("Circulo")
                    && Matriz_Tablero[1][1].equalsIgnoreCase("Circulo")
                    && Matriz_Tablero[2][2].equalsIgnoreCase("Circulo"))
            {
                Ganador = "Circulo";
            }
        }

        //Diagonal Desde Abajo a la izquierda, a Arriba a la derecha
        if(!Matriz_Tablero[2][0].equalsIgnoreCase("")) {
            if (Matriz_Tablero[2][0].equalsIgnoreCase("Cruz")
                    && Matriz_Tablero[1][1].equalsIgnoreCase("Cruz")
                    && Matriz_Tablero[0][2].equalsIgnoreCase("Cruz"))
            {
                Ganador = "Cruz";
            }
            else if (Matriz_Tablero[2][0].equalsIgnoreCase("Circulo")
                    && Matriz_Tablero[1][1].equalsIgnoreCase("Circulo")
                    && Matriz_Tablero[0][2].equalsIgnoreCase("Circulo"))
            {
                Ganador = "Circulo";
            }
        }

        return Ganador;
    }

    public void ReiniciarMatriz()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) {
                Matriz_Tablero[i][j] = "";
            }
        }
    }

    public boolean CheckMatrizLlena(){
        boolean retorno = false;
        boolean salir = false;
        int contador = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(Matriz_Tablero[i][j] != "")
                {
                    contador++;
                }
                else{
                    salir = true;
                    break;
                }

                if(contador >= 9)
                {
                    retorno = true;
                    salir = true;
                    break;
                }
            }
            if(salir)
            {
                break;
            }
        }

        return retorno;
    }
}
