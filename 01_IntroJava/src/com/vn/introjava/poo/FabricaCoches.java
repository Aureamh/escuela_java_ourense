/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author Equipo 13
 */
public class FabricaCoches {
    public static Coche crear(String marca) throws Exception{ /*preguntamos por la marca.*/ 
        Coche c = new Coche ();
        c.setMarca(marca);
        return c;    
    }
}
