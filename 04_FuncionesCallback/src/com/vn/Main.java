/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArrays;
import com.vn.liboperaarrays.OperarArrays.FunCallbackOperarArrays;
import java.io.PrintStream;

/**
 *
 * @author Equipo 13
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] arrayA = {1, 2, 3, 4, 5};
        double[] arrayB = {2, 3, 4, 5, 6};
        double[] arraySumaAB
                = OperarArrays.operarArrays(arrayA, arrayB, Main::suma);
        arrayEnTabla(System.out, arraySumaAB);
        FunCallbackOperarArrays divide = (double x, double y) -> {
            return x / y;};
        double[] arrayDividirAB
                = OperarArrays.operarArrays(arrayA, arrayB, divide);
        arrayEnTabla(System.out, arrayDividirAB);
        
        double[] arrayRestaAB
                = OperarArrays.operarArrays(arrayA, arrayB, (double x, double y) ->
                {return x-y;});
        arrayEnTabla(System.out, arrayRestaAB);

//        for (int i = 0; i < arraySumaAB.length; i++) {
//            System.out.println("El resultado de " + arrayA[i] + " + "
//                    + arrayB[i] + " es igual a " + arraySumaAB[i]);
//            
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(coordenadas(arrayA[i], arrayB[i]));
        }
    }

    public static double suma(double x, double y) {
        return x + y;
    }

    public static void arrayEnTabla(PrintStream salida, double[] array) {
        String tabla = "<table border=2><tr>\n";
        for (int i = 0; i < array.length; i++) {
            final double element = array[i];
            tabla += "<td>&nbsp;" + element + "&nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }

    public static Object coordenadas(double x, double y) {
        Object varDoubleX = new Double(x);
        Object varDoubleY = new Double(y);
        Object varStringXY = new String("(" + varDoubleX.toString() + ";"
                + varDoubleY.toString() + ")");
        return varStringXY.toString();
    }

}
