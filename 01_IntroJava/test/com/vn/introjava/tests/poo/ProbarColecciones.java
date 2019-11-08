/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Equipo 13
 */
public class ProbarColecciones {
    
    public ProbarColecciones() {
    }
    
     @Test
     public void testArrayListNoGenerica() {
         ArrayList lista = new ArrayList();
         //Con el ArrayList podemos podemos mezclar churras con merinas.
         //
         lista.add(new Object());
         lista.add(new Coche("Coche"));
         lista.add("Texto cualquiera");
         lista.add(100);
         
         for (int i = 0; i < lista.size(); i++) {
             System.out.println("Elem [ " + i + "] = " + lista.get(i).toString());
         }
     }
     
     @Test
     public void testArrayListGenericosOK() {
         //< > para no mezlcar churras con merinas, solo cojo CocheRally.
         ArrayList<CocheRally> misCoches = new ArrayList<CocheRally>();
         misCoches.add(new CocheRally("Subaru Lunes"));
         misCoches.add(new CocheRally("Toyota Martes"));
         misCoches.add(new CocheRally("Hammer FIn de Semana"));
         
         misCoches.get(2).arrancar("encender");
         misCoches.get(2).mostrarEstado();
         
         for (CocheRally miCoche : misCoches) {
             miCoche.avanzar();
         }
     }
}
