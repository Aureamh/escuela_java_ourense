/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Equipo 13
 */
public class ProbarGenericos { 

//    public ProbarGenericos() {

//    @Test
//    public void testearMetodosGenericos() {
//        ArrayList<Integer> listIn = new ArrayList<Integer>();
//        int tres = 3, cinco = 5;
////        insertarIntegerDuplicado(listIn, tres);
////        insertarIntegerDuplicado(listIn, cinco);
//        insertarDuplicado(listIn, tres);
//        insertarDuplicado(listIn, cinco);
//        System.out.println("Tres sigue siendo " + tres);
//
//        for (Integer integer : listIn) {
//            System.out.println(" - " + integer);
//        }
//   }
    
   @Test
    public void testearClaseAnidada() {
        // Las clases anidadas generan su propio fichero bytecodes
        ProbarClaseInterfazGenericaYAnidadas.ClasePequePos c;
        c = new ProbarClaseInterfazGenericaYAnidadas.ClasePequePos(1f, 2f);
    }
            
    @Test
    public void testearMetodosGenericos() {
        ArrayList<Integer> listIn = new ArrayList<Integer>();
        int tres = 3, cinco = 5;
        insertarDuplicado(listIn, tres);
        insertarDuplicado(listIn, cinco);
        System.out.println("Tres sigue siendo " + tres);
        for (Integer integer : listIn) {
            System.out.println(" - " + integer);
        }
            
        //Inferir: Infiere, deduce el tipo por su declaración.
        ArrayList<String> listStr = new ArrayList<>();
//        insertarStringDuplicado(listStr, "tres");
//        insertarStringDuplicado(listStr, "cinco");
        insertarDuplicado(listStr, "tres");
        insertarDuplicado(listStr, "cinco");

        for (String unString : listStr) {
            System.out.println(" ** " + unString);
        }
        
    //Ejercicio 1:  Método genérico que reciba un ArrayList de Coche.
        ArrayList<Coche> listCoche = new ArrayList<>();
        insertarDuplicado(listCoche, new Coche ("Seat"));
        insertarDuplicado(listCoche, new Coche ("BMW"));
        insertarDuplicado(listCoche, new Coche ("Ford"));
    
    //Ejercicio 2: Método genérico que reciba un ArrayList<Tipo>, que lo muestre
    //(foreach) y devuelva el último valor. 
    //(Otra forma más abajo)
        for (Coche miCoche : listCoche) {
            System.out.println(miCoche); //Así recorro lo que tengo en el ArrayList
        }
        
        System.out.println("Último valor = " + listCoche.get(listCoche.size()-1));
        //Ponemos -1 porque en los array empieza a enumerar en posición 0.
    
        Integer ultInt = mostrarYdevolverUltimo(listIn);
        String ultStr = mostrarYdevolverUltimo(listStr);
        Coche ultCoche = mostrarYdevolverUltimo(listCoche);
        assertEquals((int)ultInt, 5); //cambio Integer a int
        assertEquals(ultInt, (Integer)5); //cambio int a Integer
        //Sino da error porque Integer es un objeto e int una variable primitiva
        //entonces no se pueden comparar, por tanto, hay que cambiar uno a otro.
        assertEquals(ultStr, "cinco");
        assertEquals(ultCoche.getMarca(), "Ford");
    
    }
    
    
    //Entre < > ponemos el nombre del tipo genérico. Esto convierte el método
    //en un "método genérico".
    static <Tipo> void insertarDuplicado(ArrayList<Tipo> listaGenerica, Tipo i) {
        listaGenerica.add(i); //Así se añaden los datos al ArrayList
        listaGenerica.add(i);
        System.out.println(i + " añadido dos veces");
        //Esto no afecta fuera del método.
        listaGenerica = null;
    }
    
    //Otra forma de hacer el Ejercicio 2, hecho por el profesor.
    static<T> T mostrarYdevolverUltimo(ArrayList<T> lista) {
        
        for (T infusion : lista) {
            System.out.println(">> " + infusion.toString()); //Así recorro lo que tengo en el ArrayList
        }
        if (lista.size() > 0)
            return lista.get(lista.size()-1);
        else
            return null;  
    }

    /* Métodos NO genéricos */
//    static void insertarIntegerDuplicado(ArrayList<Integer> listaInt, int i) {
//        listaInt.add(i);
//        listaInt.add(i);
//        System.out.println(i + " añadido dos veces");
//        i = i + 10;
//    }
//
//    static void insertarStringDuplicado(ArrayList<String> listaString, String str) {
//
//        listaString.add(str);
//        listaString.add(str);
//        System.out.println(str + " añadido dos veces");
//        str = str + "10";
//    }

}
