package IF2000_2025.Proyecto_damaschinas;

public class Celda {
    //Atributos
    private int fila;
    private int columna;
    private Ficha ficha;

    //Constructor
    public Celda(int fila, int columna){
        this.fila=fila;
        this.columna=columna;
        this.ficha=null;
    }
    //Getters y Setters
    public void setFila(int fila){
        this.fila=fila;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int columna){
        this.columna=columna;
    }
    public int getColumna(){
        return columna;
    }
    public void setFicha(Ficha ficha){
        this.ficha=ficha;
    }
    public Ficha getFicha(){
        return ficha;
    }
    //metodos
    public boolean estaVacia(){
        return ficha==null;
    }
    @Override
    public String toString(){
        if(estaVacia()){
            // Representar celda vacía
            return"[]";
        }
        String color=ficha.getColor();
        if(color==null)return"?";
        if(color.equalsIgnoreCase("RED")) return"R";
        if(color.equalsIgnoreCase("BLACK")) return"B";

        return String.valueOf(Character.toUpperCase(color.charAt((0))));
    }



    
}
