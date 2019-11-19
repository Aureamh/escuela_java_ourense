/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

import java.util.function.Function;

/**
 *
 * @author Equipo 13
 */
public class OperarArrays {
    
    //Equivalente a decir que estructura tendrán las funciones Callback
    @FunctionalInterface
    public interface FunCallbackOperarArrays{
        //Solo podemos declarar(que luego implementar) un método
        double operar(double X, double Y);
    }
    
    public static double[] operarArrays(
            double[] arrX,
            double[] arrY,
            FunCallbackOperarArrays operarCallback){
        double[] arrayResultado = null;
        if (arrX.length == arrY.length){
            arrayResultado = new double[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResultado[i] = operarCallback.operar(arrX[i],arrY[i]);
            }
        }
        return arrayResultado;
    }
}