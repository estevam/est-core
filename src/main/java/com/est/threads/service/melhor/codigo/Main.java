/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.threads.service.melhor.codigo;

/**
 *
 * @author estevam
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.myTest();

    }

    public void myTest() {

        for (int i = 0; i < 100; i++) {
            Test test = new Test(i);
            test.setPriorityThread(Thread.NORM_PRIORITY);
            test.start();
        }

    }

    class Test extends ActivityService{

        public Test(int aThreadID) {
            super(aThreadID);
        }

        @Override
        public Object onAction() {
       
         return "Estevam";
        }
    }
    
}
