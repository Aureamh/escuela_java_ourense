/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author Equipo 13
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HilosSencillos hs =new HilosSencillos();
        
        long timeIni = System.currentTimeMillis();
        hs.ejecutarHilosRunABenSerie();
        String m1 = mostrarTiempo(timeIni, "Run en Serie ha tardado: "); 
                
        timeIni = System.currentTimeMillis();
        hs.ejecutarHilosStartABenParalelo();
        String m2 = mostrarTiempo(timeIni,"Start en Paralelo ha tardado: ");
        System.out.println(m1);
        System.out.println(m2);
    }
    
    static String mostrarTiempo(long timeInicial,String mensaje) {
        
        double tiempoTotal = (double)(System.currentTimeMillis()-timeInicial)/1000.0;
        //.0 para asegurarse de que es un double.
        String mensajeRet = mensaje + tiempoTotal;
        System.out.println(mensajeRet);
        return mensajeRet;
    }
    
}
