/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Equipo 13
 */
public class DaoCocheMap implements IDaoCoche{

    private int ultimoIndex;
    Map<String, Coche> mapaStr;
    Map<Integer, Coche> mapaInt;

    public DaoCocheMap() {
        mapaStr = new HashMap<>();
        mapaInt = new HashMap<>();
        ultimoIndex = 0;
        
        /*Si usamos un TreeMap funciona igual porque tanto HashMap como 
        TreeMap son heredados de Map, que es una interfaz, por tanto 
        funcionaría igual sin necesidad de modificar ningún código más. */
//        mapaStr = new TreeMap<>();
//        mapaInt = new TreeMap<>();
    }
    
    @Override
    public void crear(String marca) throws Exception {
        crear(FabricaCoches.crear(marca));
    }

    @Override
    public void crear(Coche coche) throws Exception {
        mapaStr.put(coche.getMarca(),coche);
        mapaInt.put(ultimoIndex, mapaStr.get(coche.getMarca()));
        ultimoIndex++;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaInt.get(index);
    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaStr.get(marca);

    }
    
    
}
