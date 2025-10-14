package logic;

/**
 * Modelo del tablero movible de ajedrez (implementación única y completa).
 * Provee métodos: construir tablero, reiniciar, seleccionar pieza, mover pieza,
 * soltar pieza, colocar pieza y getters necesarios para la GUI.
 */
public class Tablero_movible_de_ajedrez {
    private String[][] tablero;
    private int filas;
    private int columnas;
    private String piezaVacia = ".";

    // Estado de selección/movimiento
    private String piezaSeleccionada = null;
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private boolean piezaEnmano = false;

    public Tablero_movible_de_ajedrez(int filas, int columnas) {
        this(filas, columnas, ".");
    }

    public Tablero_movible_de_ajedrez(int filas, int columnas, String piezaVacia) {
        this.filas = Math.max(1, filas);
        this.columnas = Math.max(1, columnas);
        if (piezaVacia != null && !piezaVacia.isEmpty()) this.piezaVacia = piezaVacia;
        tablero = new String[this.filas][this.columnas];
        reiniciarTablero();
    }

    // Constructor que acepta una matriz inicial (la copia internamente)
    public Tablero_movible_de_ajedrez(String[][] inicial, int filas, int columnas, String piezaVacia,
                                      String piezaSeleccionada, int filaSeleccionada, boolean piezaEnmano) {
        if (inicial != null) {
            this.filas = inicial.length;
            this.columnas = (inicial.length > 0) ? inicial[0].length : columnas;
            tablero = new String[this.filas][this.columnas];
            for (int i = 0; i < this.filas; i++) {
                for (int j = 0; j < this.columnas; j++) {
                    tablero[i][j] = inicial[i][j];
                }
            }
        } else {
            this.filas = Math.max(1, filas);
            this.columnas = Math.max(1, columnas);
            tablero = new String[this.filas][this.columnas];
            reiniciarTablero();
        }
        if (piezaVacia != null && !piezaVacia.isEmpty()) this.piezaVacia = piezaVacia;
        this.piezaSeleccionada = piezaSeleccionada;
        this.filaSeleccionada = filaSeleccionada;
        this.piezaEnmano = piezaEnmano;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public String getPiezaVacia() {
        return piezaVacia;
    }

    public String getPiezaSeleccionada() {
        return piezaSeleccionada;
    }

    public int getFilaSeleccionada() {
        return filaSeleccionada;
    }

    public int getColumnaSeleccionada() {
        return columnaSeleccionada;
    }

    public boolean getPiezaEnmano() {
        return piezaEnmano;
    }

    // Reinicia el tablero llenándolo con la pieza vacía
    public void reiniciarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = piezaVacia;
            }
        }
        piezaSeleccionada = null;
        piezaEnmano = false;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
    }

    // Coloca una pieza en la posición si está libre
    public boolean colocarPieza(int fila, int columna, String pieza) {
        if (!validarIndices(fila, columna)) return false;
        if (pieza == null) return false;
        if (!tablero[fila][columna].equals(piezaVacia)) return false;
        tablero[fila][columna] = pieza;
        return true;
    }

    // Selecciona una pieza (quita la pieza de su casilla y la deja en mano)
    public boolean seleccionarPieza(int fila, int columna) {
        if (!validarIndices(fila, columna)) return false;
        if (piezaEnmano) return false; // ya hay una pieza en mano
        String p = tablero[fila][columna];
        if (p == null || p.equals(piezaVacia)) return false; // no hay pieza
        piezaSeleccionada = p;
        filaSeleccionada = fila;
        columnaSeleccionada = columna;
        piezaEnmano = true;
        tablero[fila][columna] = piezaVacia;
        return true;
    }

    // Mueve la pieza en mano a la casilla especificada (si está vacía)
    // Nombre adaptado: moverpieza para compatibilidad con código existente
    public boolean moverpieza(int fila, int columna) {
        return moverPieza(fila, columna);
    }

    public boolean moverPieza(int fila, int columna) {
        if (!validarIndices(fila, columna)) return false;
        if (!piezaEnmano) return false;
        if (!tablero[fila][columna].equals(piezaVacia)) return false;
        tablero[fila][columna] = piezaSeleccionada;
        piezaSeleccionada = null;
        piezaEnmano = false;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
        return true;
    }

    // Devuelve la pieza a su posición original si hay una seleccionada
    public boolean soltarPieza() {
        if (!piezaEnmano) return false;
        if (!validarIndices(filaSeleccionada, columnaSeleccionada)) return false;
        // si la casilla original quedó ocupada por alguna razón, busca la primera libre
        if (tablero[filaSeleccionada][columnaSeleccionada].equals(piezaVacia)) {
            tablero[filaSeleccionada][columnaSeleccionada] = piezaSeleccionada;
        } else {
            // buscar un lugar cercano (simple: primera casilla libre)
            boolean colocada = false;
            for (int i = 0; i < filas && !colocada; i++) {
                for (int j = 0; j < columnas && !colocada; j++) {
                    if (tablero[i][j].equals(piezaVacia)) {
                        tablero[i][j] = piezaSeleccionada;
                        colocada = true;
                    }
                }
            }
            if (!colocada) return false; // tablero lleno
        }
        piezaSeleccionada = null;
        piezaEnmano = false;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
        return true;
    }

    private boolean validarIndices(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }
}

