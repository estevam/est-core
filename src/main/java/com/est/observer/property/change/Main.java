package com.est.observer.property.change;

public class Main {
		public static void main(String args[]) {
			Thread  test = new Thread(new ThreadTest());
			test.setName("estevam");
			test.start();	

			Observable observable = new Observable();
			Obeserver observer = new Obeserver(test);
			 
			observable.addPropertyChangeListener(observer);
			observable.setNews("news");
			 
			System.out.println("\n Fim");
		}
}
