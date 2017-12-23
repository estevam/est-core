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
public abstract class Funcionario {

    protected double salario = 2000;

    public double getBonificacao() {
        return this.salario * 1.2 + 1000;
    }
    
    protected abstract double setNewSalary();
}
