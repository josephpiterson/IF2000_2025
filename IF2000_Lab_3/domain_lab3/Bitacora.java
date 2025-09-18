package IF2000_Lab_3.domain_lab3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bitacora {
    public static class Evento {
        private int id;
        private String tipo; // DEPOSITO, RETIRO, INTERES, TRANSFER
        private Date fecha;
        private Account cuenta;
        private double monto;

        public Evento(int id, String tipo, Date fecha, Account cuenta, double monto) {
            this.id = id;
            this.tipo = tipo;
            this.fecha = fecha;
            this.cuenta = cuenta;
            this.monto = monto;
        }

        @Override
        public String toString() {
            return "Evento{id=" + id + ", tipo='" + tipo + '\'' + ", fecha=" + fecha + ", cuenta=" + cuenta.getAccountNumber() + ", monto=" + monto + '}';
        }
    }

    private List<Evento> eventos = new ArrayList<>();
    private int nextId = 1;

    public void addEvent(String tipo, Account cuenta, double monto) {
        Evento e = new Evento(nextId++, tipo, new Date(), cuenta, monto);
        eventos.add(e);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Evento e : eventos) sb.append(e).append("\n");
        return sb.toString();
    }
}
