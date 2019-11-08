/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

/**
 *
 * @author Equipo 13
 */
public class Tractor extends Vehiculo {

    public Tractor() {
        super ();
        tipo = TipoVehiculo.TRACTOR;
    }
    
    
    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego.");
    }
    
    public void mover(float f) {
        avanzar();
        System.out.println(f + " metros");
    }
    
//    @Override
//    public void mostrarEstado() {
//        System.out.println(toString());
//    }
    
    @Override
    public String toString() {
        return tipo.toString();
    }
    
    
    
    
}
