package logic.Quizz30-10-25;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    private final String nombre;
    private final String id; 
    private final int edad;
    private final String correo;
    private final String telefono;
    private final LocalDateTime fechaRegistro;
    private static final DateTimeFormatter FORMATO=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Person(String nombre, String id, int edad, String correo, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaRegistro = LocalDateTime.now();
    }
    public String getNombre(){
        return nombre;
    }
    public String getId(){
        return id;
    }
    public int getEdad(){
        return edad;
    }
    public String getCorreo(){
        return correo;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getFechaRegistro(){
        return fechaRegistro.format(FORMATO);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaRegistro=" + fechaRegistro.format(FORMATO) +
                '}';
    }


    

}
