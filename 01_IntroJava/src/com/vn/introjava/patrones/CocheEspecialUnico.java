/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.Random;

/**
 *
 * @author Equipo 13
 */
public class CocheEspecialUnico extends Coche {

    private static CocheEspecialUnico Instancia;

    private CocheEspecialUnico() {
        //Ya nadie puede construir este coche porque lo he puesto privado.
        super();
    }

    public static CocheEspecialUnico getInstancia() throws Exception {

        if (CocheEspecialUnico.Instancia == null) {
            CocheEspecialUnico.Instancia = new CocheEspecialUnico();

            CocheEspecialUnico.Instancia.setMarca("Único coche "
                    + (new Random()).nextInt());
        }
        return CocheEspecialUnico.Instancia;

    }

}
