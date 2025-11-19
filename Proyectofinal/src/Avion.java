package Proyectofinal;

 import java.util.ArrayList;
import java.util.List;

public class Avion{
    private String matricula;
    private String modelo;
    private int capacidadEjecutiva;
    private int capacidadEconomica;
    private int ocupadosEjecutiva;
    private int ocupadosEconomica;

    public Avion(String modelo){
        this(modelo,10,20);
    }
    public Avion(String modelo, int capacidadEjecutiva, int capacidadEconomica){
        this.modelo=modelo;
        this.matricula="AV-"+System.currentTimeMillis()%10000;
        this.capacidadEjecutiva=capacidadEjecutiva;
        this.capacidadEconomica=capacidadEconomica;
        this.ocupadosEjecutiva=0;
        this.ocupadosEconomica=0;
    }
    public String getModelo(){return modelo;}

    public List<String> getAsientosDisponible(String clase){
        List<String> res=new ArrayList<>();
        if("EJECUTIVA".equalsIgnoreCase(clase)){
            for(int i=ocupadosEjecutiva+1; i<=capacidadEjecutiva; i++){
                res.add("E"+i);
            }
        }else{
            for(int i=ocupadosEconomica + 1; i<=capacidadEconomica; i++){
                res.add("C"+i);
            }
        }
        return res;
    }
    public boolean haydisponibilidad(String clase){
        return haydisponibilidad(clase,1);
    }
    public boolean haydisponibilidad(String clase, int cantidad){
        if("EJECUTIVA".equalsIgnoreCase(clase)){
            return ocupadosEjecutiva+cantidad<=capacidadEjecutiva;
        }else{
            return ocupadosEconomica+cantidad<=capacidadEconomica;
        }
    }
    public boolean reservarAsientos(String clase, int cantidad){
        if(!haydisponibilidad(clase,cantidad))return false;
        if("EJECUTIVA".equalsIgnoreCase(clase)){
            ocupadosEjecutiva+=cantidad;
        }else{
            ocupadosEconomica+=cantidad;
        }
        return  true;
    }
    public int getDisponibles(String clase){
        if("EJECUTIVA".equalsIgnoreCase(clase)){
            return  capacidadEjecutiva-ocupadosEjecutiva;
        }
        return capacidadEconomica-ocupadosEconomica;
    }
    public String getMatricula(){return  matricula;}

    @Override
    public String toString(){
        return "Avion"+matricula+"("+modelo+")";
    }
    


}
