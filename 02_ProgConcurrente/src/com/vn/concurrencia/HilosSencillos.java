/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author Equipo 13
 */
public class HilosSencillos {
    //Cuando una clase está dentro de otra se llama ANIDADA.
    //Para ejecutar un hilo tenemos que implementar siempre RUNNABLE.
    
    static int contCompartido =0;
    
    HiloA hiloA1,hiloA2;
    HiloB hiloB1,hiloB2;

    public HilosSencillos() {
        this.hiloA1 = new HiloA();
        this.hiloA2 = new HiloA();
        this.hiloB1 = new HiloB();
        this.hiloB2 = new HiloB();
    }

    
    class HiloA implements Runnable{

        @Override
        public void run() {
            for(int i=0; i<500000;i++){
                contCompartido++;
                if(i % 10000 == 0){
                System.out.println("Instrucción A: " + i + "-contador = " + 
                        contCompartido);
                }
            }
        }
    }
    
    class HiloB implements Runnable{

        @Override
        public void run() {
            //El contador principal, j, en variable local.
            for(int j=0; j<800000;j++){
                contCompartido++;
                if(j % 10000 == 0){
                System.out.println("->Ins B: " + j + " ,c = " + contCompartido);
                }
            }
        }
    }
    
    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n***** THREAD - START *****\n");
        Thread threadHiloA1 = new Thread(hiloA1);
        Thread threadHiloA2 = new Thread(hiloA2);
        Thread threadHiloB1 = new Thread(hiloB1);
        Thread threadHiloB2 = new Thread(hiloB2);
        threadHiloA1.start();
        threadHiloB1.start(); 
        threadHiloA2.start();
        threadHiloB2.start();
        
        while(threadHiloA1.isAlive() || threadHiloA1.isAlive()||
                threadHiloB1.isAlive() || threadHiloB2.isAlive());
        
        System.out.println("\n***** END - START *****\n");
    }
    
    public void ejecutarHilosRunABenSerie() {
        System.out.println("\n----- THREAD - RUN -----\n");
        Thread threadHiloA1 = new Thread(hiloA1);
        Thread threadHiloA2 = new Thread(hiloA2);
        Thread threadHiloB1 = new Thread(hiloB1);
        Thread threadHiloB2 = new Thread(hiloB2);
        threadHiloA1.run();
        threadHiloB1.run(); 
        threadHiloA2.run();
        threadHiloB2.run();
        System.out.println("\n***** END - RUN *****\n");
        
    }
}
