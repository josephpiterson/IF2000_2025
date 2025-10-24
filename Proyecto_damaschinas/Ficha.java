package Proyecto_damaschinas;

public class Ficha {
    //Atributos
    private String color;
    private int fila;
    private int columna;
    //Constructor
    public Ficha(String color, int fila, int columna){
        this.color=color;
        this.fila=fila;
        this.columna=columna;
    }
    //Getters y Setters
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
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
    @Override
    public String toString(){
        return "Ficha{"+"color='"+color+'\''+",fila="+fila+",columna="+columna+'}';
    }
}
