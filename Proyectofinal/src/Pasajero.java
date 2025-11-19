package Proyectofinal;

public class Pasajero {
    private String nombre;
    private String apellidos;
    private String ID;
    private String email;
    private String nacionalidad;
    
    public Pasajero(String nombre,String apellidos, String ID, String email, String nacionalidad){
        this.nombre=nombre==null?"":nombre;
        this.apellidos=apellidos==null?"":apellidos;
        this.ID=ID==null?"":ID;
        this.email=email==null?"":email;
        this.nacionalidad=nacionalidad==null?"":nacionalidad;

    }
    public String getNombre(){return nombre;}
    public String getApellidos(){return apellidos;}
    public String getID(){return ID;}
    public String getEmail(){return email;}
    public String getNacionalidad(){return nacionalidad;}

    @Override
    public String toString(){
        return nombre+" "+apellidos+" ("+ID+")";
    }
}
