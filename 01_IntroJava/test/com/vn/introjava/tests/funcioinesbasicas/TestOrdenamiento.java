/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.funcioinesbasicas;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.vn.introjava.funcionesbasicas.Ordenamiento;

/**
 *
 * @author Equipo 13
 */
public class TestOrdenamiento {
    
    public TestOrdenamiento() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    //@Test //las funciones que son invocadas no pueden llevar ekl test delante
     private void probarOrdenamientoSistemaHumano(int[] array, int[] arrayOrdenadoOk) {
//         int[] array = {4,2,3,1};
//         int[] arrayOrdenadoOk = {1,2,3,4}; //El resultado que nosotros esperamos, lo que está bien.
         int[] arrayOrdPorFuncion;
         arrayOrdPorFuncion = Ordenamiento.ordenarArray(array);
         assertArrayEquals(arrayOrdPorFuncion, arrayOrdenadoOk);   
     }
    
     
     @Test
     public void probarOrdenaSisHumConsecutivos() {
         int[] array = {4,2,3,1};
         int[] arrayOrdenadoOk = {1,2,3,4}; //El resultado que nosotros esperamos, lo que está bien.
         int[] arrayOrdPorFuncion;
         arrayOrdPorFuncion = Ordenamiento.ordenarArray(array);
         assertArrayEquals(arrayOrdPorFuncion, arrayOrdenadoOk);   
     }
     
     
     @Test
     public void probarOrdenaSisHumInvertido() {
         probarOrdenamientoSistemaHumano(
         new int[]{5,4,3,2,1},
         new int[] {1,2,3,4,5});
     }
     
      @Test
     public void probarOrdenaSisHumArrayLargo() {
         int[] array = {5,4,3,2,1,6,9,7,8};
         int[] arrayOrdenadoOk = {1,2,3,4,5,6,7,8,9}; //El resultado que nosotros esperamos, lo que está bien.
         int[] arrayOrdPorFuncion;
         arrayOrdPorFuncion = Ordenamiento.ordenarArray(array);
         assertArrayEquals(arrayOrdPorFuncion, arrayOrdenadoOk);
     }
     
     
     @Test
     public void probarOrdenaSisHumDosValores() {
         probarOrdenamientoSistemaHumano(
         new int[]{5,4},
         new int[] {4,5});
     }
     
      @Test
     public void probarOrdenaSisHumUnValor() {
         probarOrdenamientoSistemaHumano(
         new int[]{5},
         new int[] {5});
     }
     
     
      @Test
     public void probarOrdenaSisHumNegativos() {
         probarOrdenamientoSistemaHumano(
         new int[]{5,4,-3,2,1,6,-9,7,8},
         new int[] {-9,-3,1,2,4,5,6,7,8});
     }
     
     
      @Test
     public void probarOrdenaSisHumRepetidos() {
         probarOrdenamientoSistemaHumano(
         new int[]{2,4,-3,2,1,6,-9,2,8},
         new int[] {-9,-3,1,2,2,2,4,6,8});
     }
     
     
      @Test
     public void probarOrdenaSisHumVacio() {
         probarOrdenamientoSistemaHumano(
         new int[]{},
         new int[] {});
     }
     
      @Test
     public void probarOrdenaSisHumOrdenado() {
         probarOrdenamientoSistemaHumano(
         new int[]{1,3,5,6},
         new int[] {1,3,5,6});
     }
     
      @Test
     public void probarOrdenaSisHumMax() {
         probarOrdenamientoSistemaHumano(
         new int[]{4,3,2,1,Integer.MAX_VALUE},
         new int[] {1,2,3,4,Integer.MAX_VALUE});
     }
     
        @Test
     public void probarOrdenaSisHumMIN() {
         probarOrdenamientoSistemaHumano(
         new int[]{4,3,2,1,Integer.MIN_VALUE},
         new int[] {Integer.MIN_VALUE,1,2,3,4});
     }
      
             @Test
     public void probarOrdenaSisHumNull() {
         probarOrdenamientoSistemaHumano(
                 null, null);
         
     }
     
     
}
