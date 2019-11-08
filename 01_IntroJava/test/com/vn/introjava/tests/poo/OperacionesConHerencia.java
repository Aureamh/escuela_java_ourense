/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.TipoVehiculo;
import com.vn.introjava.poo.vehiculos.Tractor;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Equipo 13
 */
public class OperacionesConHerencia {
    
    static CocheRally supra;
    static Coche turismo;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        supra = new CocheRally();
        supra.setMarca("Toyota");
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
      public void testSobreEscrituraMetodos() throws Exception {
          
          supra.setRozamiento(7f);
          assertTrue(supra.getRozamiento() == 7f);
          //Usando T.D.D.
          assertTrue(supra.arrancar("arrancar"));
          assertTrue(supra.arrancar("ARRANcar"));
          assertTrue(supra.arrancar("Encender"));
          supra.mostrarEstado();
      }
    @Test      
     public void testPolimorfismo() {
     supra.setRozamiento(15f);
     turismo = supra;
     //En java todos los métodos son virtuales. Si un hijo tiene un método,
     //se invoca al del hijo.
     turismo.mostrarEstado();
     }
            
    @Test
     public void testEnumerado() {
         supra.setTipo(TipoVehiculo.RALLY);
         // Un enumerado es un int, limitado a lista de valores indicados.
         System.out.println("Tipo: " + supra.getTipo().toString());
         System.out.println("Valor tipo: " + supra.getTipo().ordinal());
         
         Tractor miTractorAmarillo = new Tractor();
         miTractorAmarillo.setTipo(TipoVehiculo.valueOf("TRACTOR"));
         System.out.println("Valor tipo desde int: " + miTractorAmarillo.getTipo());
         
         //Este es el más recomendado para utilizar.
         miTractorAmarillo.setTipo(TipoVehiculo.values()[1]);
         System.out.println("Tipo desde String: " + miTractorAmarillo.getTipo());   
     }
     
        @Test
         public void testClasesAbstractas() {
             //Vehiculo vehDesc = new Vehiculo(); //No se puede por ser abstracta
             Vehiculo vehDesc = new Coche("Dacia");
             Vehiculo subaru = new CocheRally("Subaru");
             Vehiculo miTrac = new Tractor();
             vehDesc.avanzar();
             miTrac.avanzar();
             //Mediante un casting explícito podemos invocar a sus métodos
             assertEquals(((CocheRally)subaru).getMarca(),"Subaru");
             
             Vehiculo[] misVehiculos = new Vehiculo[] {
                 vehDesc,
                 miTrac,
                 new Coche("Electrico"),
                 subaru
            };
             
             System.out.println("***LISTA DE VEHÍCULOS***");
             for (Vehiculo miVehiculo : misVehiculos) {
                 System.out.println("-" + miVehiculo.getTipo());
                 miVehiculo.avanzar();
                 miVehiculo.mostrarEstado();
            }
             System.out.println("***FIN DE LISTA***");

    }   
}