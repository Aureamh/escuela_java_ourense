package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El sistema de bloqueo tiene que gestionar el recurso compartido.
 *
 * @author Equipo 13
 */
public class Contenedor {

    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    //Semáforo: false no se puede usar el recurso y
    //true sí se puede usar.

    boolean hayDato = false;
    
    //synchronized prepara el método para el bloqueo.
    public synchronized int get() { //Esto es una manera de bloquear el recurso.

        while (hayDato == false) {
            //No pongo nada dentro para que el programa espere a que haya
            //algún dato, es decir, mientras no hay ningún recurso.
            try {
                this.wait(); //Le decimos al hilo que espere hasta que el 
                             //productor produzca el dato.
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        hayDato = false; //Deja de haber dato cuando se lee, es decir, cuando
                         // marcamos para bloquear el recurso.
        this.notifyAll(); //Indicar al hilo que avise a los demás hilos que
                          //el recurso ya ha sido consumido
        return dato; //Devolver el dato.
    }

    public synchronized void put(int valor) {

        while (hayDato) {
            //No pongo nada dentro para que el programa espere a que alguien
            //consuma el dato, es decir, para mientras no haya nadie que 
            //consuma el recurso.  
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dato = valor; //Almacenar el dato.
        hayDato = true; //Hay dato cuando se hace un put, es decir, cuando
                        //marcamos para desbloquear/liberar el recurso.
        this.notifyAll();
    }
}
