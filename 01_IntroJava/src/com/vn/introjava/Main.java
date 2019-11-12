/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import com.vn.introjava.funcionesbasicas.DatosBasicos;
import com.vn.introjava.funcionesbasicas.EstructurasControl;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.ordenarArray;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.TransformException;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author Equipo 13
 */
public class Main {

    public static void main(String[] args) {
        
        /*Error no capturado, se detiene el programa
        while(args.length > -1)
            ((Object) null).equals(args);*/
        
        try {
            //Primer código con error.
            System.out.println("Tipos de datos");
            ordenarArray(new int[]{3, -1, 5, 8, 2});
            //Coche c = FabricaCoches.crear(null); //IllegalArgumentException
            //Coche c = FabricaCoches.crear("Un coche"); //RuntimeException
            //c.mostrarEstado();

            //Segundo código con error.
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
//            unObj.metodoPeligroso(); //RuntimeException
            
            throw new TransformException("Optimus prime se ha quedado sin batería");

            //Tercer código con error, NullPointerException
//            Object objNulo = null;
//            System.out.println("Fallará: " + objNulo.toString());
        } //Los catch se pueden anidar:
        catch (IllegalArgumentException ex) {
            //Captura cualquier IllegalArgumentException.
            System.out.println("ARGUMENTO INVÁLIDO. DESCRIBE AL USUARIO LO QUÉ: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException ex) {
            //Captura cualquier RuntimeException cuyo tipo sea el indicado en
            //el catch ó CUALQUIERA de sus clases hijas.
            System.out.println("Cualquier tipo de RunTimeException: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            //Captura cualquier Excepecion que no haya sido gestionada.
            System.out.println("Cualquier tipo de Exception: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally{ //Siempre se ejecuta, incluso antes que un return
            System.out.println(">>> FIN DEL TRY - CATCH");
        }
        System.out.println("***** FIN DEL PROGRAMA");
    }
        /**
         * Función que se ejecuta al arrancar el programa
         *
         * @param args the command line arguments
         */
    public static void mainTryCatchPorSeparado(String[] args) {
//        DatosBasicos.mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();     
//        EstructurasControl.ejecutarCondiciones();
//        DatosBasicos.probarOperadores();
        try {
            System.out.println("Tipos de datos");
            ordenarArray(new int[]{3, -1, 5, 8, 2});
            Coche c = FabricaCoches.crear("");
            c.mostrarEstado();
        } catch (Exception ex) {
            System.out.println(">>LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Excepcion " + ex);
            System.out.println("\nPila de llamadas "
                    + Arrays.toString(ex.getStackTrace()));
        }
        try {
            Object objNulo = null;
            System.out.println("Fallará: " + objNulo.toString());
        } catch (NullPointerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
