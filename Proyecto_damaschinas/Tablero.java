package Proyecto_damaschinas;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private Celda[][] celdas;
    private final int TAM = 8;

    // lógica del tablero
    public Tablero() {
        celdas = new Celda[TAM][TAM];
        inicializarCeldas();
        colocarFichasIniciales();
    }

    // inicializar celdas
    private void inicializarCeldas() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                celdas[i][j] = new Celda(i, j);
            }
        }
    }

    // colocar fichas iniciales
    private void colocarFichasIniciales() {
        // fichas negras arriba (filas 0..2) en casillas oscuras
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < TAM; j++) {
                if ((i + j) % 2 == 1) {
                    celdas[i][j].setFicha(new Ficha("BLACK", i, j));
                }
            }
        }
        // fichas rojas abajo (filas 5..7) en casillas oscuras
        for (int i = 5; i <= 7; i++) {
            for (int j = 0; j < TAM; j++) {
                if ((i + j) % 2 == 1) {
                    celdas[i][j].setFicha(new Ficha("RED", i, j));
                }
            }
        }
    }

    public Celda getCelda(int fila, int columna) {
        if (fila < 0 || fila >= TAM || columna < 0 || columna >= TAM) {
            return null;
        }
        return celdas[fila][columna];
    }

    public void moverFicha(int fOrigen, int cOrigen, int fDestino, int cDestino) {
        Celda origen = getCelda(fOrigen, cOrigen);
        Celda destino = getCelda(fDestino, cDestino);
        if (origen == null || destino == null) return;
        Ficha f = origen.getFicha();
        if (f == null) return;
        destino.setFicha(f);
        f.setFila(fDestino);
        f.setColumna(cDestino);
        origen.setFicha(null);
    }

    // consultar todas las fichas de un color
    public List<Ficha> getFichasPorColor(String color) {
        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                Celda c = celdas[i][j];
                if (!c.estaVacia() && c.getFicha().getColor().equalsIgnoreCase(color)) {
                    fichas.add(c.getFicha());
                }
            }
        }
        return fichas;
    }

    public void imprimirTablero() {
        // imprimir encabezados de columnas (0..TAM-1)
        System.out.print("  ");
        for (int col = 0; col < TAM; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int i = 0; i < TAM; i++) {
            char rowLabel = (char) ('A' + i);
            System.out.print(rowLabel + " ");
            for (int j = 0; j < TAM; j++) {
                System.out.print(celdas[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
}
