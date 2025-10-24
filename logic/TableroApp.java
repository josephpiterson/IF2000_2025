 package logic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * TableroApp: clase única que contiene el modelo y la GUI del tablero movible.
 */
public class TableroApp extends JFrame {
    private static final long serialVersionUID = 1L;

    // Modelo
    private final String[][] tablero;
    private final int filas = 8;
    private final int columnas = 8;
    private final String piezaVacia = ".";

    // Estado de selección
    private String piezaSeleccionada = null;
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private boolean piezaEnmano = false;

    // GUI
    private final JButton[][] botones;
    private final JLabel statusLabel = new JLabel("Listo");
    private final Color lightColor = new Color(250, 248, 239);
    private final Color darkColor = new Color(181, 136, 99);
    private final Border defaultBorder = new LineBorder(Color.DARK_GRAY, 1);
    private final Border selectionBorder = new LineBorder(Color.RED, 3);

    public TableroApp() {
        super("Tablero Movible - Integrado");
        botones = new JButton[filas][columnas];
        tablero = new String[filas][columnas];
        inicializarModelo();
        inicializarGUI();
    }

    private void inicializarModelo() {
        for (int r = 0; r < filas; r++)
            for (int c = 0; c < columnas; c++)
                tablero[r][c] = piezaVacia;
        colocarPiezasIniciales();
    }

    private void colocarPiezasIniciales() {
        // Ejemplo de piezas (puedes cambiarlo)
        for (int c = 0; c < columnas; c++) tablero[1][c] = "P";
        for (int c = 0; c < columnas; c++) tablero[6][c] = "p";
        tablero[0][0] = "T"; tablero[0][1] = "C"; tablero[0][2] = "A"; tablero[0][3] = "D";
        tablero[0][4] = "R"; tablero[0][5] = "A"; tablero[0][6] = "C"; tablero[0][7] = "T";
        tablero[7][0] = "t"; tablero[7][1] = "c"; tablero[7][2] = "a"; tablero[7][3] = "d";
        tablero[7][4] = "r"; tablero[7][5] = "a"; tablero[7][6] = "c"; tablero[7][7] = "t";
    }

    private boolean validarIndices(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    private boolean seleccionarPieza(int fila, int columna) {
        if (!validarIndices(fila, columna)) return false;
        if (piezaEnmano) return false;
        String p = tablero[fila][columna];
        if (p == null || p.equals(piezaVacia)) return false;
        piezaSeleccionada = p;
        filaSeleccionada = fila;
        columnaSeleccionada = columna;
        piezaEnmano = true;
        tablero[fila][columna] = piezaVacia;
        return true;
    }

    private boolean moverPieza(int fila, int columna) {
        if (!validarIndices(fila, columna)) return false;
        if (!piezaEnmano) return false;
        if (!tablero[fila][columna].equals(piezaVacia)) return false;
        // Permitir solo movimiento diagonal (misma distancia en filas y columnas)
        int df = Math.abs(fila - filaSeleccionada);
        int dc = Math.abs(columna - columnaSeleccionada);
        if (df == 0 || dc == 0 || df != dc) return false;

        tablero[fila][columna] = piezaSeleccionada;
        piezaSeleccionada = null;
        piezaEnmano = false;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
        return true;
    }

    private boolean soltarPieza() {
        if (!piezaEnmano) return false;
        if (!validarIndices(filaSeleccionada, columnaSeleccionada)) return false;
        if (tablero[filaSeleccionada][columnaSeleccionada].equals(piezaVacia)) {
            tablero[filaSeleccionada][columnaSeleccionada] = piezaSeleccionada;
        } else {
            // Buscar primera celda vacía
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tablero[i][j].equals(piezaVacia)) {
                        tablero[i][j] = piezaSeleccionada;
                        piezaSeleccionada = null;
                        piezaEnmano = false;
                        filaSeleccionada = -1;
                        columnaSeleccionada = -1;
                        return true;
                    }
                }
            }
            return false;
        }
        piezaSeleccionada = null;
        piezaEnmano = false;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
        return true;
    }

    private void inicializarGUI() {
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

    private JPanel crearGridConEncabezados() {
        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel grid = new JPanel(new GridLayout(filas + 1, columnas + 1, 0, 0));
        grid.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        Font headerFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font cellFont = new Font(Font.MONOSPACED, Font.BOLD, 20);

        grid.add(new JLabel());
        for (int c = 0; c < columnas; c++) {
            JLabel lbl = new JLabel(String.valueOf((char) ('A' + c)), SwingConstants.CENTER);
            lbl.setFont(headerFont);
            lbl.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            grid.add(lbl);
        }

        for (int r = 0; r < filas; r++) {
            JLabel rowLbl = new JLabel(String.valueOf(filas - r), SwingConstants.CENTER);
            rowLbl.setFont(headerFont);
            rowLbl.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            grid.add(rowLbl);

            for (int c = 0; c < columnas; c++) {
                JButton b = new JButton();
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
                b.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            soltarPieza();
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
            soltarPieza();
            refrescar();
        });
        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.addActionListener(e -> {
            inicializarModelo();
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
        if (!piezaEnmano) {
            String valor = tablero[fila][col];
            if (valor != null && !valor.equals(piezaVacia) && !valor.trim().isEmpty()) {
                seleccionarPieza(fila, col);
                statusLabel.setText("Seleccionada " + piezaSeleccionada + " en " + coordToLabel(fila, col));
            } else {
                statusLabel.setText("No hay pieza en " + coordToLabel(fila, col));
                Toolkit.getDefaultToolkit().beep();
            }
        } else {
            String destino = tablero[fila][col];
            if (destino != null && destino.equals(piezaVacia)) {
                moverPieza(fila, col);
                statusLabel.setText("Movido a " + coordToLabel(fila, col));
            } else {
                statusLabel.setText("Destino ocupado: " + coordToLabel(fila, col));
                Toolkit.getDefaultToolkit().beep();
            }
        }
        refrescar();
    }

    private void refrescar() {
        int selF = filaSeleccionada;
        int selC = columnaSeleccionada;
        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {
                JButton btn = botones[r][c];
                String texto = tablero[r][c];
                // Usar icono circular para las fichas
                btn.setIcon(matrizIcon(r, c));
                btn.setToolTipText(coordToLabel(r, c) + " - " + (texto == null ? "?" : texto));
                btn.setBorder(defaultBorder);
                btn.setBackground(((r + c) % 2 == 0) ? lightColor : darkColor);
                if (piezaEnmano && r == selF && c == selC) {
                    btn.setBorder(selectionBorder);
                }
            }
        }
        if (piezaEnmano) {
            setTitle("Tablero - Pieza en mano: " + piezaSeleccionada);
        } else {
            setTitle("Tablero - Sin pieza en mano");
        }
        repaint();
    }

    private String coordToLabel(int fila, int col) {
        char colLabel = (char) ('A' + col);
        int rowLabel = filas - fila;
        return "" + colLabel + rowLabel;
    }

    private String matrizText(int r, int c) {
        String t = tablero[r][c];
        return (t == null || t.equals(piezaVacia)) ? "" : t;
    }

    // Devuelve un Icon que pinta una ficha circular según el texto de la celda
    private Icon matrizIcon(int r, int c) {
        String t = tablero[r][c];
        if (t == null || t.equals(piezaVacia) || t.trim().isEmpty()) return null;
        // Determinar color: mayúscula -> roja, minúscula -> negra
        boolean upper = Character.isUpperCase(t.charAt(0));
        Color fill = upper ? new Color(200, 40, 40) : Color.BLACK;
        Color border = upper ? fill.darker() : Color.DARK_GRAY;
        return new PieceIcon(fill, border, 40);
    }

    // Icon personalizado para pintar una ficha circular con letra
    private static class PieceIcon implements Icon {
        private final Color fill;
        private final Color border;
        private final int size;

        PieceIcon(Color fill, Color border, int size) {
            this.fill = fill;
            this.border = border;
            this.size = size;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            try {
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Centrar el círculo en toda la superficie del componente (botón)
                int cx = (c.getWidth() - size) / 2;
                int cy = (c.getHeight() - size) / 2;
                // fondo circular
                g2.setColor(fill);
                g2.fillOval(cx, cy, size, size);
                // borde
                g2.setColor(border);
                g2.setStroke(new BasicStroke(2f));
                g2.drawOval(cx, cy, size, size);
                // No dibujar letra: ficha solo circular, centrada por el icono
            } finally {
                g2.dispose();
            }
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableroApp());
    }
}
