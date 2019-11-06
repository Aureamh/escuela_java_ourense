/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.funcionesbasicas.DatosBasicos;
import com.vn.introjava.funcionesbasicas.EstructurasControl;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.ordenarArray;

/** Clase principal del proyecto
 * Ejemplos java
 * @author Equipo 13
 */
public class Main {

    /** Función que se ejecuta al arrancar el programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tipos de datos");
        
        DatosBasicos.mostrarTiposDatos();
        EstructurasControl.ejecutarBucles();     
        EstructurasControl.ejecutarCondiciones();
        DatosBasicos.probarOperadores();
        ordenarArray(new int[] {3,-1,5,8,2});
        }
    
   
              
}

