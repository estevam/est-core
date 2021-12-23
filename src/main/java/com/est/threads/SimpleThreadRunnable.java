
package com.est.threads;

/**
 *
 * @author estevam
 */
public class SimpleThreadRunnable implements Runnable {

	String palavra;
	long tempo;

	boolean isStatus =false;
	public SimpleThreadRunnable(String palavra, long tempo) {
		this.palavra = palavra;
		this.tempo = tempo;
		isStatus =false;
	}


	public void setStatus(boolean s) {
		isStatus =s;
	}
	
	public boolean getStatus() {
		return isStatus;
	}
	
	@Override
	public void run() {

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(palavra);
				Thread.sleep(tempo);
			
			}
		} catch (InterruptedException e) {
	
		}
		
		isStatus =true;
	}
	public static void main(String args[]) {

		SimpleThreadRunnable ping = new SimpleThreadRunnable("Ping", 1000);
		SimpleThreadRunnable pong = new SimpleThreadRunnable("Pong", 2000);
		System.out.println("Start Thread!");

		Thread t1 = new Thread(ping, "ping");
		t1.start();
		Thread t2 = new Thread(pong, "pong");
		t2.start();

		while(ping.getStatus()) {
			System.out.println(ping.getStatus());
		}
	}
}

