/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.reflection;

/**
 *
 * @author estevam
 */
public class AppTest{
 
	private int counter;
 
	public void printIt(){
		System.out.println("printIt() no param");
	}
 
	public void printItString(String temp){
		System.out.println("printIt() with param String : " + temp);
	}
 
	public void printItInt(int temp){
		System.out.println("printIt() with param int : " + temp);
	}
 
	public void setCounter(int counter){
		this.counter = counter;
		System.out.println("setCounter() set counter to : " + counter);
	}
 
	public void printCounter(){
		System.out.println("printCounter() : " + this.counter);
	}
}