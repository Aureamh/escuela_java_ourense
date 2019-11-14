///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vn.concurrencia;
//
//import static com.vn.concurrencia.HilosSencillos.contCompartido;
//import java.util.ArrayList;
//
///**
// *
// * @author Equipo 13
// */
//public class SetDeHilos {
//    
//    ArrayList<HiloA> hilosA = new ArrayList<HiloA>();
//    ArrayList<HiloB> hilosB = new ArrayList<HiloB>();
//    ArrayList<Thread> thread = new ArrayList<Thread>();
//    
//    class HiloA implements Runnable{
//
//        @Override
//        public void run() {
//            for(int i=0; i<hilosA.size();i++){
//                contCompartido++;
//                System.out.println("Instrucción A: " + i + "-contador = " + 
//                        contCompartido);
//            }
//        }
//    }
// 
//    class HiloB implements Runnable{
//        @Override
//        public void run() {
//            for(int j=0; j<hilosB.size();j++){
//                contCompartido++;  
//                System.out.println("->Ins B: " + j + " ,c = " + contCompartido);  
//            }
//        }
//    }
    
//        public void ejecutarHilosStartABenParalelo() {
//        
//        System.out.println("\n***** THREAD - START *****\n");
//        
//            for (int i = 0; i < hilosA.size(); i++) {
//           
//                Thread threadHiloA = new Thread(hilosA);
//                threadHiloAi.start();
//
//                }
//
//            }
//        
//        while(threadHiloA1.isAlive() || threadHiloA1.isAlive()||
//                threadHiloB1.isAlive() || threadHiloB2.isAlive());
//        
//        System.out.println("\n***** END - START *****\n");
//        }
//    }

 
    
