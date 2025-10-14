package logic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Interfaz mejorada para Tablero_movible_de_ajedrez
 */
public class TableroGUI extends JFrame {
    private final int FILAS = 8;
    private final int COLUMNAS = 8;
    private final JButton[][] botones = new JButton[FILAS][COLUMNAS];
    private final Tablero_movible_de_ajedrez tablero;
    private final JLabel statusLabel = new JLabel("Listo");
    private final Color lightColor = new Color(250, 248, 239);
    private final Color darkColor = new Color(181, 136, 99);
    private final Color highlightColor = new Color(255, 235, 59);
    private final Border defaultBorder = new LineBorder(Color.DARK_GRAY, 1);
    private final Border selectionBorder = new LineBorder(Color.RED, 3);

    public TableroGUI() {
        // Crear matriz inicial y usar el constructor existente
        String[][] matriz = new String[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++)
                matriz[i][j] = ".";

        tablero = new Tablero_movible_de_ajedrez(matriz, FILAS, COLUMNAS, ".", null, -1, false);
        tablero.reiniciarTablero();

        // Colocación inicial de piezas (configuración clásica)
        colocarPiezasIniciales();

        setTitle("Tablero Movible - Interfaz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(6, 6));
        add(crearGridConEncabezados(), BorderLayout.CENTER);
        add(crearPanelControl(), BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        refrescar();
        setVisible(true);
    }

    private void colocarPiezasIniciales() {
        String[][] m = tablero.getTablero();
        // limpiar primero
        tablero.reiniciarTablero();

        // Fila 0: piezas "mayúsculas" (ej. lado A)
        m[0][0] = "T"; m[0][1] = "C"; m[0][2] = "A"; m[0][3] = "D";
        m[0][4] = "R"; m[0][5] = "A"; m[0][6] = "C"; m[0][7] = "T";
        // Fila 1: peones mayúsculos
        for (int c = 0; c < COLUMNAS; c++) m[1][c] = "P";

        // Fila 6: peones minúsculos
        for (int c = 0; c < COLUMNAS; c++) m[6][c] = "p";
        // Fila 7: piezas "minúsculas" (ej. lado B)
        m[7][0] = "t"; m[7][1] = "c"; m[7][2] = "a"; m[7][3] = "d";
        m[7][4] = "r"; m[7][5] = "a"; m[7][6] = "c"; m[7][7] = "t";
    }

    private JPanel crearGridConEncabezados() {
        // Panel con (FILAS+1) x (COLUMNAS+1) para encabezados
        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel grid = new JPanel(new GridLayout(FILAS + 1, COLUMNAS + 1, 0, 0));
        grid.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        Font headerFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font cellFont = new Font(Font.MONOSPACED, Font.BOLD, 20);

        // celda (0,0) vacía
        grid.add(new JLabel());

        // encabezados de columnas (A..H)
        for (int c = 0; c < COLUMNAS; c++) {
            JLabel lbl = new JLabel(String.valueOf((char) ('A' + c)), SwingConstants.CENTER);
            lbl.setFont(headerFont);
            lbl.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            grid.add(lbl);
        }

        // filas con encabezado y botones
        for (int r = 0; r < FILAS; r++) {
            // etiqueta de fila (8..1)
            JLabel rowLbl = new JLabel(String.valueOf(FILAS - r), SwingConstants.CENTER);
            rowLbl.setFont(headerFont);
            rowLbl.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            grid.add(rowLbl);

            for (int c = 0; c < COLUMNAS; c++) {
                JButton b = new JButton(matrizText(r, c));
                b.setFont(cellFont);
                b.setOpaque(true);
                b.setBorder(defaultBorder);
                b.setFocusPainted(false);
                b.setPreferredSize(new Dimension(64, 64));
                b.setBackground(((r + c) % 2 == 0) ? lightColor : darkColor);
                final int fr = r;
                final int fc = c;
                b.setToolTipText(coordToLabel(fr, fc));
                b.addActionListener(e -> onCeldaClick(fr, fc));
                // permitir botón derecho para cancelar selección (soltar)
                b.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            tablero.soltarPieza();
                            refrescar();
                        }
                    }
                });
                botones[r][c] = b;
                grid.add(b);
            }
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(grid, gbc);
        return container;
    }

    private JPanel crearPanelControl() {
        JPanel control = new JPanel(new BorderLayout(6, 6));
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        JButton soltar = new JButton("Soltar (click derecho también)");
        soltar.addActionListener(e -> {
            tablero.soltarPieza();
            refrescar();
        });
        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.addActionListener(e -> {
            colocarPiezasIniciales();
            refrescar();
        });
        botonesPanel.add(soltar);
        botonesPanel.add(reiniciar);

        statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        control.add(botonesPanel, BorderLayout.WEST);
        control.add(statusLabel, BorderLayout.CENTER);
        return control;
    }

    private void onCeldaClick(int fila, int col) {
        if (!tablero.getPiezaEnmano()) {
            String valor = tablero.getTablero()[fila][col];
            if (valor != null && !valor.equals(".") && !valor.trim().isEmpty()) {
                tablero.seleccionarPieza(fila, col);
                statusLabel.setText("Seleccionada " + tablero.getPiezaSeleccionada() + " en " + coordToLabel(fila, col));
            } else {
                statusLabel.setText("No hay pieza en " + coordToLabel(fila, col));
                Toolkit.getDefaultToolkit().beep();
            }
        } else {
            String destino = tablero.getTablero()[fila][col];
            if (destino != null && destino.equals(".")) {
                tablero.moverpieza(fila, col);
                statusLabel.setText("Movido a " + coordToLabel(fila, col));
            } else {
                statusLabel.setText("Destino ocupado: " + coordToLabel(fila, col));
                Toolkit.getDefaultToolkit().beep();
            }
        }
        refrescar();
    }

    private void refrescar() {
        String[][] m = tablero.getTablero();
        int selF = tablero.getFilaSeleccionada();
        int selC = tablero.getColumnaSeleccionada();
        for (int r = 0; r < FILAS; r++) {
            for (int c = 0; c < COLUMNAS; c++) {
                JButton btn = botones[r][c];
                String texto = m[r][c];
                // mostrar punto más legible si vacío
                btn.setText((texto == null || texto.equals(".")) ? "" : texto);
                btn.setToolTipText(coordToLabel(r, c) + " - " + (texto == null ? "?" : texto));
                // reset border & background
                btn.setBorder(defaultBorder);
                btn.setBackground(((r + c) % 2 == 0) ? lightColor : darkColor);
                // resaltar selección
                if (tablero.getPiezaEnmano() && r == selF && c == selC) {
                    btn.setBorder(selectionBorder);
                }
            }
        }
        // título indica pieza en mano
        if (tablero.getPiezaEnmano()) {
            setTitle("Tablero - Pieza en mano: " + tablero.getPiezaSeleccionada());
        } else {
            setTitle("Tablero - Sin pieza en mano");
        }
        repaint();
    }

    private String coordToLabel(int fila, int col) {
        char colLabel = (char) ('A' + col);
        int rowLabel = FILAS - fila;
        return "" + colLabel + rowLabel;
    }

    private String matrizText(int r, int c) {
        String t = tablero.getTablero()[r][c];
        return (t == null || t.equals(".")) ? "" : t;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableroGUI());
    }
}