package IF2000_2025.Proyecto_damaschinas;

import java.util.Scanner;

public class Juego {
    //Atributos
    private Tablero tablero;
    private String turnoactual;

    //Constructor
    public Juego(){
        tablero=new Tablero();
        turnoactual="RED";
    }
    //getters y setters
    public Tablero setTablero(Tablero tablero){
        this.tablero=tablero;
        return tablero;
    }
    public Tablero getTablero(){
        return tablero;
    }
    public void setTurnoactual(String turnoactual){
        this.turnoactual=turnoactual;
    }
    public String getTurnoactual(){
        return turnoactual;
    }
    //metodos
    public void cambiarTurno(){
        turnoactual=turnoactual.equalsIgnoreCase("RED")?"BLACK":"RED";

    }
    public void iniciar(){
        System.err.println("========DAMAS CHINAS========");
        try(Scanner sc=new Scanner(System.in)){
           while (true) {
                 tablero.imprimirTablero();
            System.out.println("Turno de:"+turnoactual);
            System.out.print("Mover ficha(ej: F0 E1 ó 5 0 4 1).Escribe 'q' para salir:");

            String line=null;
            if(sc.hasNextLine()){
                line=sc.nextLine().trim();

            }else{
                break;
            }
            if(line.equalsIgnoreCase("q")|| line.equalsIgnoreCase("quit")){
                System.err.println("Saliendo...");
                break;
            }

            //procesar movimiento
            String[] parts =line.split("\\s+");
            int fO,cO,fD,cD;
            try{
                if(parts.length==2){
                    // Formato con letras y números
                     fO=Integer.parseInt(parts[0]);
                     cO=Integer.parseInt(parts[1]);
                    fD=Integer.parseInt(parts[2]);
                    cD=Integer.parseInt(parts[3]);
                }else if(parts.length==2){
                    int[] src=parseCoord(parts[0]);
                    int[] dst=parseCoord(parts[1]);
                    if(src==null||dst==null){
                        System.err.println("Formato de coordenadas inválido. Usa F0 E1 o 5 0 4 1.");
                        continue;
                    }
                    fO=src[0]; cO=src[1]; fD=dst[0]; cD=dst[1];

                }else{
                    System.out.println("Entrada no reconocida. Usa 'F0 E1' o '5 0 4 1'.");
                    continue;
                }
            
           }catch(NumberFormatException e){
            System.err.println("Numero inválidos.");
            continue;
           }
           Celda origen = tablero.getCelda(fO, cO);
           Celda destino = tablero.getCelda(fD, cD);
           if(origen==null || destino==null){
            System.err.println("No hay ficha en la celda de origen");
            continue;
           }
           if(!origen.getFicha().getColor().equalsIgnoreCase(turnoactual)){
            System.err.println("Esa ficha no te pertenece.");
            continue;
           }if(destino==null){
            System.err.println("Destino fuera del tablero.");
            continue;
           }
           if(!destino.estaVacia()){
            System.err.println("La celda de destino no está vacía.");
            continue;
           }
           if(!esMOvimientoValido(origen,fD,cD)){
            System.err.println("Movimiento inválido para la ficha.");
            continue;
           }
           tablero.moverFicha(fO, cO, fD, cD);
           cambiarTurno();

        }
    }
}
    //verificar si el movimiento es valido
    private int[] parseCoord(String s){
        s=s.replace("->"," ").replace(",", " ").trim();
        if(s.length()>=2){
            char a=s.charAt(0);
            char b=s.charAt(1);
            if(Character.isLetter(a)&& Character.isDigit(b)){
                int row=Character.toUpperCase(a)-'A';
                int col;
                try{
                    col=Integer.parseInt(s.substring(1));

                }catch(NumberFormatException e){
                    return null;
                }
                if(row<0 || row>=8 || col<0 || col>=8)return null;
                return new int[]{row,col};

            }
        }
        return null;
    }
    private boolean esMOvimientoValido(Celda origen,int fD, int cD){
        Ficha f=origen.getFicha();
        if(f==null)return false;
        int fO= origen.getFila();
        int cO= origen.getColumna();
        int df=Math.abs(cD-cO);
        int dc=Math.abs(cD-cO);
        String color=f.getColor();
        if(color.equalsIgnoreCase("RED")){
            return df==-1;

        }else if(color.equalsIgnoreCase("BLACK")){
            return df==1;
        }
        return false;

    }

}