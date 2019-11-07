/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.CocheRally;
import com.vn.introjava.poo.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Equipo 13
 */
public class OperacionesBasicasObjetos {
   
     @Test
     public void creandoObjetos() {
         Coche miCoche = null;
         miCoche = new Coche (); //El new es el que reserva la memoria necesaria
         //para almacenar el objeto coche.
         System.out.println("Texto de coche: " + miCoche.toString());
         
         Coche miCocheFindes = new Coche ();
         assertNotNull (miCoche);
         assertNotNull (miCocheFindes);
         assertNotEquals (miCoche, miCocheFindes);
         
         try{
             //miCoche.marca ='...'; No compila
             miCoche.setMarca("Kia");
             miCocheFindes.setMarca("Hammer");
         } catch(Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null,ex);
       }
        System.out.println("miCoche.marca       = " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca = " 
                + miCocheFindes.getMarca());
        assertEquals(miCoche.getMarca(), "Kia");
        
        miCocheFindes = miCoche;
        assertEquals(miCoche, miCocheFindes);

         try {
             miCocheFindes.setMarca("Hammer Limusina");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }

         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCoche.marca = " +miCocheFindes.getMarca());
         
         assertEquals(miCoche.getMarca(),"Kia");
         
         miCocheFindes = miCoche;
         assertEquals(miCoche, miCocheFindes);
         
         try {
             miCoche.setMarca("Hammer Limusina");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         
         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCocheFindes = " + miCocheFindes.getMarca());
         
         //Le decimos al Rec. Basura que queremos borrar todos los objetos.
         
         //miCoche contador es 2, y el de miCocheFindes contador = 0. 
         //Entonces si quiero eliminar alguna referencia,haría lo siguiente:
         
//         miCoche = null; //Aquí el contador quedaría a 1.
//         miCocheFindes = null; //Aquí quedaría a 0.
        
         //Manera de llamar al colector de basura, aunque el se ejecutará cuando
         //él quiera (solo le sugerimos que limpie la app) pero lo hará solo si
         //lo ve conveniente.
         
         System.gc();
         
         //Introducción a los polimorfismos.
         
         Object refAmiCoche = miCoche;
         //No podemos acceder a marca (invocar a get.Marca()) porque no tiene la forma de coche
         //pero sí a los métodos que tienen todos los objetos.
         //System.out.println("miCoche.marca = " + refAmiCoche.getMarca());
         //Sí podemos...
         assertTrue(refAmiCoche.equals(miCoche));
         miCoche.arrancar();
         assertEquals(miCoche.getNumRuedas(), 4);
         
     }
     
     
     @Test
     public void probandoSobrecarga() {
         Coche nuevoCoche = new Coche();
         assertTrue(nuevoCoche.arrancar());
         
         for (int i = 1; i <=4 ;i++){
             if(i == 4){
                 assertTrue(nuevoCoche.arrancar(i));
             }else {
                 assertFalse(nuevoCoche.arrancar(i));
             }
         }
     }
     
     
     @Test (expected = IllegalArgumentException.class)
     public void gestionExcepciones() throws Exception {
         Coche c = FabricaCoches.crear("");
     }
     
    @Test // (expected = IllegalArgumentException.class)
    public void gestionExcepciones_2() {
        try {
            Coche c = FabricaCoches.crear("");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
             
      @Test 
      public void usandoConstructoresSobrecargados(){
          Coche c = new Coche ("Ferrari");
          assertEquals(c.getMarca(),"Ferrari");
      }
      
      @Test
      public void testSobreescrituraMostrarEstado() {
          CocheRally supra = new CocheRally();
          supra.mostrarEstadoAntiguo();
          supra.mostrarEstado();
      }


}             
        
         
         
     

