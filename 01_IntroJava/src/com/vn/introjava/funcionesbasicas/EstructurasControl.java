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
public class EstructurasControl {
     
    public static void ejecutarBucles() {
        char arrayChar[] = {'a','B','8','*'};
        int index = 0;
        while (index < arrayChar.length){
            System.out.println("Index = " +index +", char" + arrayChar[index]);
            index++; // index += 1; index = index +1;
        }
        for (/* ini */ index = 0 ;/* cond */ index < arrayChar.length ;/*inc */ index++ )
            System.out.println("Index = " +index + ", char = " + arrayChar[index]);
            
        
//        do {
//            System.out.println("Index = " +index + ", char = " + arrayChar[index]);
//            index++;
//        }while(index < arrayChar.length);
        for (char caracter : arrayChar) {
            System.out.println("char = " + caracter);
        }
 
    }
    
    public static void ejecutarCondiciones() {
        if ("Palabra".length() > 5) { //Condicional simple
            System.out.println("Palabra larga");
        }
        // Condicionales compuestos
        if ("Texto".length() >5) {
            //Por aqui no entra
        }else {
            System.out.println("Palabra corta");
        }
        
        if ("En un lugar de la mancha".contains("Lugar")) {
            // No entra por aqui
            System.out.println("Tiene Lugar");
        }
        else if ("En un lugar de la mancha...".contains("Mancha")) {
            // No entra por aqui
        } else if ("En un lugar de la mancha...".contains("Otro"))
            // No entra por aqui
            System.out.println("Tiene Otro");
        else {
            System.out.println("No tiene ninguno porque estan en mayusculas");
        }
        
        //SWITCH (puede ser una expresión no solo una variable)
        
        int numeroPeq = 0;
        switch (numeroPeq +5-5) {
            case 0: 
                System.out.println("Num peq vale cero. ");
                break;
            case 1:
                System.out.println("Num peq vale uno.");
                break;
            case 2:
            case 3:
            case 4:   
                System.out.println("Num peq vale dos, tres o cuatro.");
                break;
            default:
                System.out.println("Es otro número (<0 o >4).");
                break;
        }
    }
    
}
