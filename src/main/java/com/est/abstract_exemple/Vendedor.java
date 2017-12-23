/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.abstract_exemple;

/**
 *
 * @author estevam
 */
public class Vendedor extends Funcionario {

//    @Override
//    public double getBonificacao() {
//        return this.salario * 2.0 + 1000;
//    }
    
    
    public static void main(String args[]){
     
          Vendedor v = new Vendedor();
          System.out.println(v.getBonificacao());
    }

    @Override
    protected double setNewSalary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
