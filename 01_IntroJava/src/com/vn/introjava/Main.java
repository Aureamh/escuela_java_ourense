/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.funcionesbasicas.DatosBasicos;
import com.vn.introjava.funcionesbasicas.EstructurasControl;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.ordenarArray;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Clase principal del proyecto, MODIFICACIONS
 * Ejemplos java
 * @author Equipo 13
 */
public class Main {

    
    /** Función que se ejecuta al arrancar el programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        DatosBasicos.mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();     
//        EstructurasControl.ejecutarCondiciones();
//        DatosBasicos.probarOperadores();
        try{
            System.out.println("Tipos de datos");
            ordenarArray(new int[] {3,-1,5,8,2});
            Coche c = FabricaCoches.crear("");
            c.mostrarEstado();
        }catch (Exception ex) {
            System.out.println(">>LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }      
    }             
}

