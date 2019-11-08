/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.interfaces;

/** La forma en la que se comunican las clases que la implementan.
 * Es cómo una clase abstracta con sólo métodos abstractos.
 *
 * @author Equipo 13
 */
public interface Desplazable {
    
    //No se deben de usar variables miembro en las interfaces.
    //int propiedadNoApropiada = 4;
    
    //Únicamente declaración de métodos abstractos.
    //Solo permite métodos públicos porque una interface es una forma de 
    //comunicación, por tanto solo puede ser public void...
    
    //Lo comentamos porque es redundante porque las interfaces son siempre
    //abstractas y públicas.
    /*public abstract*/ void mover(float metros);
    
    
    //Cuando sobrecargamos métodos que devuelvan lo mismo.
//    public void mover(int metros);
            
            
//    public void detener();
    
    
    
}
