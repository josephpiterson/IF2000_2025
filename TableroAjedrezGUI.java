import java.awt.*;
import javax.swing.*;

public class TableroAjedrezGUI extends JFrame {
    private JButton[][] casillas = new JButton[8][8];
    private String[][] piezas = new String[8][8];
    private int filaSeleccionada = -1, colSeleccionada = -1;
    private JPanel panelTablero;
    private JButton botonReiniciar;

    public TableroAjedrezGUI() {
        setTitle("Tablero de Ajedrez Movible");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 700);
        setLayout(new BorderLayout());

        panelTablero = new JPanel(new GridLayout(8, 8));
        inicializarPiezas();
        inicializarTablero();

        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(e -> reiniciarTablero());

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonReiniciar);

        add(panelTablero, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void inicializarPiezas() {
        // Piezas blancas
        piezas[0] = new String[]{"♜","♞","♝","♛","♚","♝","♞","♜"};
        piezas[1] = new String[]{"♟","♟","♟","♟","♟","♟","♟","♟"};
        // Vacío
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                piezas[i][j] = "";
            }
        }
        // Piezas negras
        piezas[6] = new String[]{"♙","♙","♙","♙","♙","♙","♙","♙"};
        piezas[7] = new String[]{"♖","♘","♗","♕","♔","♗","♘","♖"};
    }

    private void inicializarTablero() {
        panelTablero.removeAll();
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                JButton boton = new JButton(piezas[fila][col]);
                boton.setFont(new Font("Arial", Font.PLAIN, 32));
                boton.setBackground((fila + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                int f = fila, c = col;
                boton.addActionListener(e -> manejarClick(f, c));
                casillas[fila][col] = boton;
                panelTablero.add(boton);
            }
        }
        panelTablero.revalidate();
        panelTablero.repaint();
    }

    private void reiniciarTablero() {
        filaSeleccionada = -1;
        colSeleccionada = -1;
        inicializarPiezas();
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                casillas[fila][col].setText(piezas[fila][col]);
                casillas[fila][col].setBackground((fila + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
            }
        }
    }

    private void manejarClick(int fila, int col) {
        if (filaSeleccionada == -1 && !piezas[fila][col].equals("")) {
            filaSeleccionada = fila;
            colSeleccionada = col;
            casillas[fila][col].setBackground(Color.YELLOW);
        } else if (filaSeleccionada != -1) {
            piezas[fila][col] = piezas[filaSeleccionada][colSeleccionada];
            piezas[filaSeleccionada][colSeleccionada] = "";
            casillas[fila][col].setText(piezas[fila][col]);
            casillas[filaSeleccionada][colSeleccionada].setText("");
            casillas[filaSeleccionada][colSeleccionada].setBackground((filaSeleccionada + colSeleccionada) % 2 == 0 ? Color.WHITE : Color.GRAY);
            filaSeleccionada = -1;
            colSeleccionada = -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableroAjedrezGUI::new);
    }
}
