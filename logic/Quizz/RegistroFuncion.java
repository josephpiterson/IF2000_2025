package logic.Quizz;

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
            System.out.println("2. Salir");
            System.out.print("Opcion:");

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
                String id=leerNoVacio(scanner,"ID");
                int edad = leerEnteroPositivo(scanner, "Edad: ");
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
            private int leerEnteroPositivo(Scanner sc, String prompt){
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
            private String leerEmailValido(Scanner sc, String prompt) {
        String email;
        do {
            System.out.print(prompt);
            email = sc.nextLine().trim();
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println("Correo inválido. Debe contener '@'. Intente de nuevo.");
                email = "";
            }
        } while (email.isEmpty());
        return email;
    }

    private String leerTelefonoValido(Scanner sc, String prompt) {
        String tel;
        do {
            System.out.print(prompt);
            tel = sc.nextLine().trim();
            if (!tel.matches("\\d{8,}")) {
                System.out.println("Teléfono inválido. Solo dígitos y al menos 8 caracteres. Intente de nuevo.");
                tel = "";
            }
        } while (tel.isEmpty());
        return tel;
    }

    // --- Merged file writer from RegistroArchivo ---
    private void guardarLinea(String linea) throws IOException {
        try (FileWriter fw = new FileWriter(ARCHIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(linea);
            bw.newLine();
        }
    }

        }
    
    

