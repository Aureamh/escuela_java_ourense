/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.sistdeplaz;

import com.vn.introjava.poo.interfaces.Electrico;
import com.vn.introjava.poo.vehiculos.Coche;

/**
 *
 * @author Equipo 13
 */
public class CocheElectrico extends Coche implements Electrico {

    @Override
    public void cargarBateria(double voltios) {
        System.out.println("Carga bateria " + voltios + "voltios.");
        
    }
    
}
