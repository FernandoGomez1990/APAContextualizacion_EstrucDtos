/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareacontextualizacion;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TareaContextualizacion {
    
    //Declaramos caracteristicas de la clase
    private static Scanner sc = new Scanner(System.in);    
    public static int numeroFamilias = 0;
    public static ServiciosPublicos sp = null;
    
    public static void main(String[] args) {                
        
        System.out.println("\t\t\t BIENVENIDO AL CENSO DE FAMILIAR DE SUBSIDIOS \n");        
        menu();
        
    }
    
    public static void menu(){
        
        //Variable que controla menú        
        int opcionMenu;        
        
        do{
            System.out.println("\t\t\t\t MENÚ PRINCIPLA \n");
            System.out.println("1. Registrar información en censo."
                    + "\n2. Consultar información de las familias."
                    + "\n3. Mostrar totales a pagar."
                    + "\n4. Salir del programa");
            
            opcionMenu = leerEnteros(sc,"Selecciona una opcion del menú: ");
                                        
            switch (opcionMenu) {
                case 1:                    
                    numeroFamilias = leerEnteros(sc,"\na continuación ingrese el numero de familias a censar: ");                                        
                    registrarInformacion(numeroFamilias);
                    break;
                case 2:
                    if(sp == null){
                        System.out.println("\n No existe informacion registrada en el censo");                                    
                    }else {
                        sp.consultarInformacion(sp,numeroFamilias);
                    }                                       
                    break;
                case 3:
                    if(sp == null){
                        System.out.println("\n No existe informacion registrada en el censo");                                    
                    }else {
                        sp.consultarInformacionPagar(sp,numeroFamilias);
                    }                                                           
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n Error: Opción no válida. Por favor, seleccione un número entre 1 y 4.\n");
                    break;
            }            
            
        }while(opcionMenu != 4);

    }
    
    public static int leerEnteros(Scanner scanner, String mensaje){
        int numero = 0;
        boolean entradaValida = false; 
        
        while (!entradaValida){
            System.out.print(mensaje);
            try{
                numero = scanner.nextInt();
                entradaValida = true;
            }catch(InputMismatchException e){
                System.out.println("Error, ingrese un numero entero");
                scanner.next();
            }
        }
        return numero;
    }
    
    public static void registrarInformacion(int numeroFamiliasP){
                
        sp = new ServiciosPublicos(numeroFamiliasP);

        for(int i = 0; i < numeroFamiliasP; i++){
            //Actualizamos estratos                        
            sp.estrato[i] = leerEnteros(sc,"Ingrese el estrato de la familia " + i+": ");
            //Actualizamos Agua                        
            sp.ServicioAgua[i] = leerEnteros(sc,"Ingrese el valor a pagar por Serv. de Agua Familia " + i+": ");
            sp.totalAgua = sp.totalAgua+sp.ServicioAgua[i];
            //Actualizamos Luz                        
            sp.ServicioLuz[i] = leerEnteros(sc,"Ingrese el valor a pagar por Serv. de Luz Familia " + i+": ");
            sp.totalLuz = sp.totalLuz+sp.ServicioLuz[i];
            //Actualizamos Gas                        
            sp.ServicioGas[i] = leerEnteros(sc,"Ingrese el valor a pagar por Serv. de Gas Familia " + i+": ");
            sp.totalGas = sp.totalGas+sp.ServicioGas[i];
        }
    }
                
}
