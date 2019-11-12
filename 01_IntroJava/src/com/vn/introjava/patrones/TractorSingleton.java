/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import java.util.Random;

/**
 *
 * @author Equipo 13
 */
public class TractorSingleton {
    
    private static TractorSingleton unicoTractorSingleton;
    private TractorSingleton() {
        //Ya nadie puede construir este tractor porque lo he puesto privado.
        super();
    }

    public static TractorSingleton getInstancia() throws Exception {

        if (TractorSingleton.unicoTractorSingleton == null) {
            TractorSingleton.unicoTractorSingleton = new TractorSingleton();

            TractorSingleton.unicoTractorSingleton.setMarca("Único tractor "
                    + (new Random()).nextInt());
        }
        return TractorSingleton.unicoTractorSingleton;

    }

    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception {
        //avisamos a quien invoca
        //que puede aparecer una excepcion
        if (marca != null && !"".equals(marca)) {
            this.marca = marca;
        } else {
            throw new IllegalArgumentException("Debes de asignar una marca.");
        }
    }

    public void mostrarEstado() {
        System.out.println(toString());
    }
}