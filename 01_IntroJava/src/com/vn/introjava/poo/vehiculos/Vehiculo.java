/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

import com.vn.introjava.poo.interfaces.Desplazable;

/**Clase abastracta que no pupede ser instanciada
 *Por falta de sentido
 * @author Equipo 13
 */
public abstract class Vehiculo 
    extends Object
    implements Desplazable{
    
    protected TipoVehiculo tipo;

    public TipoVehiculo getTipo() {
        return tipo;
    }
    
    
    
    /**
     * Método declarado e implementado.
     * @param tipo 
     */
    public void setTipo(TipoVehiculo tipo) //Declaración
    {
        this.tipo = tipo; //Implementación (lo que está entre llaves)
    }
    
    public abstract void avanzar(); //Declaración

    public void mostrarEstado() {
        System.out.println(toString());
    }
    
}
