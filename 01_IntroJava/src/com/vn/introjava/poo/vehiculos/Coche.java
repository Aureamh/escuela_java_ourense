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
public class Coche extends Vehiculo {
    
    //Constructor por defecto
    
    private String marca;
    private int numRuedas = 4;
    protected boolean arrancado;
    
    //En el momento que creamos un constructor, el de por defecto
    //deja de ser implementado por Java.
    public Coche() {
        numRuedas = 4;
        marca = "Sin marca";
        this.arrancado = true;
        tipo = TipoVehiculo.TURISMO;
    }

    public Coche(String marca) {
        this.marca = marca;
        this.arrancado = false;
        tipo = TipoVehiculo.TURISMO;
    }

    @Override
    public boolean equals(Object otroCoche) {
        if(otroCoche instanceof Coche) {
            Coche c = (Coche) otroCoche;
            if(this.getMarca().equals(c.getMarca())){
                return true;
            }
        }
        return false;
    }
    
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca) throws Exception{
        //avisamos a quien invoca
        //que puede aparecer una excepcion
        if(marca!= null && ! "".equals(marca)) {
            this.marca = marca;
        } else {
            throw new IllegalArgumentException ("Debes de asignar una marca.");
          }
    }
    
    public int getNumRuedas(){
        return numRuedas;
    }
    
    public boolean arrancar() {
        System.out.println(this.marca + " ha arrancado.");
        arrancado = true;
        return arrancado;    
    }
    
    
    //Sobrecarga de método arrancar()
    //public void arrancar() no puedo llamar con el mismo nombre a dos funciones
    //porque sino el método no sabría a cual llamar.
    
    /** Si la posición de la llave es 4, el coche arranca.
     * No arranca en cualquier otro caso.
     * @param posicionLlave puede ser un nº del 1 al 4.
     * @return  Si se ha arrancado devuelve true.
     */
    
    
    public boolean arrancar(int posicionLlave) { //4pos, la 4º es la que arranca 
        if(posicionLlave < 1 || posicionLlave > 4)
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4.");
        arrancado = posicionLlave == 4 /*? true:false*/;
        //? true:false está comentado porque es redundante y no es necesario.
        //if(porsicionLLave == 4) arrancado = true; else arrancado = false;
        System.out.println(this.marca 
                +(arrancado ? " ha arrancado." 
                : " fallo al arrancar"));
        return arrancado;   
    }
    
    
    //CLEAN CODE: Las funciones no deben de tener más de 20 líneas de código.
    public boolean arrancar(String orden) { //4º posición, es la que arranca.
        arrancado = "arrancar".equals(orden);
        return arrancado;
    }
    
//    /**
//     * Simplemente muestra la marca y si está arrancado.
//     */
//    
//    public void mostrarEstado() {
//        System.out.println(toString());         
//    }
    
    public boolean isArrancado() {
        return arrancado;
    }
    
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco");
    }
    
    public void mover(float f) {
        avanzar();
        System.out.println(f + " metros");
    }
    
    @Override
    public String toString() {
        return tipo + ":" + getMarca()
                + (arrancado ? "arrancado." 
                             : "apagado.");
        
    }
    
}
