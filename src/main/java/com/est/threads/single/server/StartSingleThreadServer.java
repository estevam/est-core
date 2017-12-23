/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.threads.single.server;

/**
 *`
 * @author estevam
 *
 *  hen the server is running you can access it using an ordinary web browser. 
 *  Use the address http://localhost:9000/
 */
public class StartSingleThreadServer {
    
    public static void main(String args[]) {
        SingleThreadedServer server = new SingleThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(10 * 100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
 
}
