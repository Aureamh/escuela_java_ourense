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
public class DatosBasicos {
     public static void mostrarTiposDatos() {
        byte unByte =-128;
        int unEntero = 1000000000; //4 bytes
        long enteroLargo = 3000000000000000000L; // 8 bytes
        float unDecimal = 1.23456789f; //4 bytes (7 ó 8 cifras decimales mantisa)
        float otroDecimal = 1234567890123456789f; //4 bytes
        double decimalDoblePrecision = 1.2345678901234567890; // 8bytes (15 ó 16 cifras decimales para la mantisa)
        boolean condicion = true; //1 byte
        char unCaracter = 'A'; //2 bytes por el formato unicode
        char unCharentero = 97;
        String unTexto = "Que esto es un texto";
        
        System.out.println("Concatenado: " + unTexto.concat("Añadido"));
        System.out.println("En mayúsculas: " + unTexto.toUpperCase());
        System.out.println("Byte: " + unByte);
        System.out.println("Entero: " + unEntero);
        System.out.println("Entero largo: " + enteroLargo);
        System.out.println("Decimal: " + unDecimal);
        System.out.println("Decimal: " + otroDecimal);
        System.out.println("Double: " + decimalDoblePrecision);
        System.out.println("Boolean: " + condicion);
        System.out.println("Char: " + unCaracter);
        System.out.println("Char en nº: " + (int) unCaracter);
        System.out.println("Char en char: " + unCharentero);
        System.out.println("String: " + unTexto);
    }
    
    public static void probarOperadores() {
        //Operardores unarios:
        System.out.println("Negacion: " + ! true);
        System.out.println("Negativo: " + -(10+5));
        //Conversión explícita
        System.out.println("Casting: " + (float) 3.3434343434); //Convertir un double en un float
        int contador;
        contador = 10;
        System.out.println("Incremento: " + contador++);
        System.out.println("Incremento: " + ++contador); //Primero suma al contador y luego avanza
        
        //Operadores binarios: (dos operandos)
        //Parentesis, suma y conversión implícita
        System.out.println("Suma y mult: " + (6+5)/3); //Trunca los decimales
        System.out.println("Suma y mult: " + ((float)6+5)/3); //con convertir un número en float es suficiente para que realice la división bien.
        System.out.println("Resto y division entera: " + 11 % 3);
        
        //Operadores booleanos
        System.out.println("Es cierto?: " + ((true) && true)); //Operador AND
        System.out.println("Es cierto?: " +(true || false)); //Operador OR
        //Igualdad y similares:
        System.out.println("Es cierto?: " + ((5==5) || 5>9)); //Operador OR
        System.out.println("Es cierto?: " + ((5!=5) && 5<=9));//Operador distinto
        
        //Operadores bit a bit
        //00010101 = 21
        //00000111 = 7
        //00000101 = 5 AND (COMPARA LOS DOS PRIMEROS EN COLUMNA 1 Y 1 DA 1. 0 Y 1 DA 0.) 
        //00010111 = 23 OR (COMPARA LOS DOS PRIMEROS EN COLUMNA 1 Y 0 DA 1, 1 Y 1 DA 1, 0 Y 0 DA 0.)
        //00010010 = 18 XOR (COMPARA LOS DOS PRIMEROS EN COLUMNA SI LOS DOS NUM SON IGUALES SON 0 Y SI SON DISTINTOS SON.)
        System.out.println("Op.binario 21 AND 5 = " + (21 & 7) );
        System.out.println("Op.binario 21 OR 5 = " + (21 | 7) );
        System.out.println("Op.binario 21 XOR 5 = " + (21 ^ 7) );
    }
    
}
