/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacontextualizacion;

public class ServiciosPublicos {        
    int[] estrato;
    int[] ServicioAgua;
    int[] ServicioLuz;
    int[] ServicioGas;
    
    public static double totalAgua =0, totalLuz=0, totalGas=0;    
    public static double totalAguaDes = 0, totalLuzDes = 0, totalGasDes = 0;    
           
    //Creamos el constructor con los parametros para tamaño de los vectores
    public ServiciosPublicos(int tamano){
        estrato = new int[tamano];
        ServicioAgua = new int[tamano];
        ServicioLuz = new int[tamano];
        ServicioGas = new int[tamano];
                
    }
    
    public static void consultarInformacion(ServiciosPublicos sp, int numeroFamilias){                
        System.out.println("\n==================================================");
        System.out.println("               CONSULTA DE CENSO FAMILIAS            ");
        System.out.println("==================================================");
                
        System.out.print("\nNro Familia");
        System.out.print("\tEstrato");
        System.out.print("\tVlr Agua");
        System.out.print("\tVlr Luz");
        System.out.println("\tVlr Gas");
                
        for(int i = 0; i < sp.estrato.length; i++){
            System.out.println(i+"\t\t"+sp.estrato[i]+"\t"+sp.ServicioAgua[i]
                    +"\t\t"+sp.ServicioLuz[i]+"\t"+sp.ServicioGas[i]);
        }
        System.out.println("==================================================");
        System.out.println("TOTALES\t\t\t"+totalAgua+"\t\t"+totalLuz+"\t"+totalGas);
        System.out.println("==================================================");
    }
    
    public static void consultarInformacionPagar(ServiciosPublicos sp, int numeroFamilias){
        
        //Inicializamos variables para que si se consulta varias veces no sumen 
        totalAguaDes = 0;
        totalLuzDes = 0; 
        totalGasDes = 0;
        
        System.out.println("\n==================================================");
        System.out.println("               CONSULTA VALORES A PAGAR             ");
        System.out.println("==================================================");
                
        System.out.print("\nNro Familia");
        System.out.print("\tEstrato");
        System.out.print("\tDescuento");        
        System.out.print("\tVlr Agua");        
        System.out.print("\tVlr a pagar Agua");        
        System.out.print("\tVlr Luz");
        System.out.print("\tVlr a pagar Luz");
        System.out.print("\t\tVlr Gas");
        System.out.println("\tVlr a pagar Gas");
                
        for(int i = 0; i < sp.estrato.length; i++){
                        
            //System.out.println("Estrato vale "+sp.estrato[i]+ " y i vale "+i+" length vale "+sp.estrato.length);
            switch (sp.estrato[i]){
                case 1:
                    System.out.println(i+"\t\t"+sp.estrato[i]+"\t20%"+"\t\t"+sp.ServicioAgua[i]
                            +"\t\t"+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*20/100))
                            +"\t\t\t"+sp.ServicioLuz[i]
                            +"\t\t"+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*20/100))
                            +"\t\t"+sp.ServicioGas[i]
                            +"\t\t"+(sp.ServicioGas[i]-(sp.ServicioGas[i]*20/100)));
                    totalAguaDes = totalAguaDes+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*20/100));
                    totalLuzDes = totalLuzDes+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*20/100));
                    totalGasDes = totalGasDes+(sp.ServicioGas[i]-(sp.ServicioGas[i]*20/100));
                break;
                case 2:
                    System.out.println(i+"\t\t"+sp.estrato[i]+"\t15%"+"\t\t"+sp.ServicioAgua[i]
                            +"\t\t"+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*15/100))
                            +"\t\t\t"+sp.ServicioLuz[i]
                            +"\t\t"+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*15/100))
                            +"\t\t"+sp.ServicioGas[i]
                            +"\t\t"+(sp.ServicioGas[i]-(sp.ServicioGas[i]*15/100)));
                    totalAguaDes = totalAguaDes+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*15/100));
                    totalLuzDes = totalLuzDes+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*15/100));
                    totalGasDes = totalGasDes+(sp.ServicioGas[i]-(sp.ServicioGas[i]*15/100));
                break;
                default:
                    System.out.println(i+"\t\t"+sp.estrato[i]+"\t9%"+"\t\t"+sp.ServicioAgua[i]
                            +"\t\t"+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*9/100))
                            +"\t\t\t"+sp.ServicioLuz[i]
                            +"\t\t"+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*9/100))
                            +"\t\t"+sp.ServicioGas[i]
                            +"\t\t"+(sp.ServicioGas[i]-(sp.ServicioGas[i]*9/100)));
                    totalAguaDes = totalAguaDes+(sp.ServicioAgua[i]-(sp.ServicioAgua[i]*9/100));
                    totalLuzDes = totalLuzDes+(sp.ServicioLuz[i]-(sp.ServicioLuz[i]*9/100));
                    totalGasDes = totalGasDes+(sp.ServicioGas[i]-(sp.ServicioGas[i]*9/100));
                break;
            }   
        }
        System.out.println("==================================================");
        System.out.println("TOTALES\t\t\t\t\t"+totalAgua+"\t\t"+totalAguaDes
                +"\t\t\t"+totalLuz+"\t\t"+totalLuzDes
                +"\t\t"+totalGas+"\t\t"+totalGasDes);
        System.out.println("==================================================");
    }
    
}
