package logic.Quizz30-10-25;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistroFuncion {
    private static final String ARCHIVO="personas.txt";

    public void run(){
         Scanner scanner = new Scanner(System.in);
    try{
        while (true) { 
            System.out.println("\n======REGISTRO DE PERSONAS=====");
            System.out.println("1. Registrar persona");
            System.out.println("Opcion:");

            int opcion;
            try {
                String line=scanner.nextLine();
                opcion=Integer.parseInt(line.trim());
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Opcion invalida. Intente de nuevo.");
                continue;
            }
            if(opcion==1){
                registrarPersona(scanner);
            }else if(opcion==2){
                System.out.println("Saliendo del programa...");
                break;
            }else{
                System.err.println("Opción inválida");
            }
            }

             }finally{
                scanner.close();
            }
            }
            private void registrarPersona(Scanner scanner){
                String nombre=leerNoVacio(scanner,"Nombre:");
                String id=leerNoVacio(scanner,"");
                int edad=leerEnteroPositivo(scanner,"Edad:");
                String correo=leerEmailValido(scanner,"Correo:");
                String telefono=leerTelefonoValido(scanner,"Telefono:");

                Person persona = new Person(nombre, id, edad, correo, telefono);

                try {
                    guardarLinea(persona.toLine());
                    System.out.println("Persona registrada exitosamente.");
                } catch (IOException e) {
                    System.err.println("Error al guardar la persona: " + e.getMessage());
                }


            }
            private String leerNoVacio(Scanner scanner, String prompt){
                String s;
                do{
                    System.err.print(prompt);
                    s=scanner.nextLine().trim();
                    if(s.isEmpty()){
                        System.err.println("Error: El campo no puede estar vacio. Intente de nuevo.");
                    }
                }while(s.isEmpty());
                return s;

            }
            private String leerEnteroPositivo(Scanner sc, String prompt){
                int val=-1;
                do {
                    System.out.print(prompt);
                    String line=sc.nextLine().trim();
                    try{
                        val=Integer.parseInt(line);
                        if(val<=0){
                            System.err.println("Error: El valor debe ser un entero positivo. Intente de nuevo.");
                        }
                    }catch(NumberFormatException e){
                        System.err.println("Error: Entrada invalida. Intente de nuevo.");
                    }
                }while(val<=0);
                return val;
            }

        }
    
    

