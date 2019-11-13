/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.HashMap;
import java.util.Map;

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
    public Coche crear(String marca) throws Exception {
        return crear(FabricaCoches.crear(marca));
    }

    @Override
    public Coche crear(Coche coche) throws Exception {
        mapaStr.put(coche.getMarca(),coche);
        mapaInt.put(ultimoIndex,coche); //Esto en el sitio de coche también
        //valdría: mapaStr.get(coche.getMarca()));
        ultimoIndex++;
        return coche;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaInt.get(index); 
    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaStr.get(marca);
    }

    @Override
    public Coche modificar(int index, Coche objConDatosNuevo) throws Exception {
        
        Coche c = obtenerPorIndice(index);
        mapaStr.remove(c.getMarca());
        mapaStr.put(objConDatosNuevo.getMarca(), c);
        
        c.setMarca(objConDatosNuevo.getMarca());
        c.setTipo(objConDatosNuevo.getTipo());
        c.arrancar(objConDatosNuevo.isArrancado()? 4 : 1);
        return c;
    }

    @Override
    public void eliminar(int index) {
        //Eliminamos por marca(String)
        Coche c = mapaInt.get(index);
        mapaStr.remove(c.getMarca());
        //Eliminamos por índice(Integer)
        mapaInt.remove(index);
        
    }

    @Override
    public void eliminar(Coche CocheAeliminar) {
        String keyMarca = CocheAeliminar.getMarca();
        mapaStr.remove(keyMarca);
        int keyIndex = -1; //Valor que no es válido para inicializar.
        if(mapaInt.containsValue(CocheAeliminar)) {
            for (Map.Entry<Integer,Coche> parIndexYcoche : mapaInt.entrySet()) {
                if(parIndexYcoche.getValue().equals(CocheAeliminar)){
                    keyIndex = parIndexYcoche.getKey();
                }
            }
        }
        mapaInt.remove(keyIndex);
    }
    


    
    
    
    
}
