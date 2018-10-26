package com.est.observer.property.change;

public class ThreadTest implements Runnable {
	Object test = new Object();

	@Override
	public void run() {
    try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generat
			System.out.print("acordado");
		}

    
		System.out.print(" estava dormindo mais acordei");
	}

}
