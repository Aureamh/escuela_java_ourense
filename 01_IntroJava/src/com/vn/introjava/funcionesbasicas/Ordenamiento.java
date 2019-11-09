/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author Equipo 13
 */
public class Ordenamiento {

    public static int[] ordenarArray(int[] arrayInt) {
        //Declarar array de enteros
        //Programar lo necesario para ordenarlo
        //int arrayInt[] = {3,-1,5,8,2};
        if (arrayInt == null) {
            return null;
        }
        for (int i = 0; i < arrayInt.length - 1; i++) {
            for (int j = i + 1; j < arrayInt.length; j++) {
                if (arrayInt[i] > arrayInt[j]) {
                    int SegundoNumero = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = SegundoNumero;
                }
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println(arrayInt[i]);
        }
        return arrayInt;
    }
    // CUIDADO QUE index ++ incrementa la VARIABLE
    // index + 1 sólo suma 1 a index, PERO LO DEJA COMO ESTABA
    // MEJOR INTENTA HACERLO POR TU CUENTA
    // BUSCA TU PROPIA LÓGICA E INTENTA PLASMARLA
    // SI NO PUEDES SIGUE COPIANDO :-D

    public static int[] insercionDirecta(int array[]) {
        int p, j;
        int aux;
        if (array == null) {
            return null;
        }
        for (p = 1; p < array.length; p++) { // desde el segundo elemento hasta
            aux = array[p]; // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < array[j])) { // mientras queden posiciones y el
                // valor de aux sea menor que los
                array[j + 1] = array[j];       // de la izquierda, se desplaza a
                j--;                   // la derecha
            }
            array[j + 1] = aux; // colocamos aux en su sitio
            
        }
        return array;
    }
}
