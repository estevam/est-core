
package com.est.threads.multi.server;

/**
 * When the server is running you can access it using an ordinary web browser. 
 * Use the address http://localhost:9000/
 * @author estevam
 */
public class Start {

    public static void main(String args[]) {

        MultiThreadedServer server = new MultiThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000000);
        } catch (InterruptedException e) {
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
