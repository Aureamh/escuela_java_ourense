/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

/** Clase CocheRally para controlar otras características específicas de los 
 * rallies.
 *
 * @author Equipo 13
 */
public class CocheRally extends Coche {
    
    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento = 5f;
        tipo = TipoVehiculo.RALLY;
    }
    
    /**
     * Constructor con parámetros
     * al implementar un constructor, el de por defecto 
     * deja de ser implementado por Java
     * @param marca 
     */
    
    public CocheRally(String marca) {
    super(marca);
    rozamiento = 5f;
    tipo = TipoVehiculo.RALLY;
    }
    
    /**
     * Obtener el valor de rozamiento
     *
     * @return the value of rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Establecer valor de rozamiento
     *
     * @param rozamiento new value of rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

    @Override //por defecto nos crea el método para invocar la forma del padre.
    public boolean arrancar(String orden) {
        if (super.arrancar(orden))
            return super.arrancado;
        else if ("arrancar".equalsIgnoreCase(orden))
            arrancado = true;
        else 
            this.arrancado = "encender".equals(orden.toLowerCase());
        return arrancado;
    }
    
    //Ejercicio 1: Sobreesscribir el método mostrarEstado para que
    //también muestre el rozamiento.
    
    //@Override //no es obligatorio ponerlo porque Java siempre sobreescribe los
    //métodos sin necesidad de poner Overrride. En este caso no puedo poner 
    //@Override porque al cambiar el nombre a "mostrarEstadoAntiguo" da error, 
    //porque entiende que no estoy sobreescribiendo nada por causa de cambiarle
    //el nombre.
    public void mostrarEstadoAntiguo() {
        super.mostrarEstado(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("-Rozamiento: " + getRozamiento());
    }
    
    //Ejercicio 2: El método anteior ya no vale, renombrar a mostrarEstadoAntiguo()
    //que indique que es un "Coche de rally: <marca>, rozamiento, arrancado".

//    @Override
//    public void mostrarEstado() {
//        System.out.println(toString());
//    }
   
    @Override
    public String toString() {
        return tipo + ":" + getMarca() + ", rozamiento = " +
                rozamiento +(isArrancado() ? "arrancado." : "apagado.");
    }
}
