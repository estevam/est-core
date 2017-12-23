package com.est.udp_socket;


import java.net.*;

/**
 For a class I am taking, we are testing out a simple UDP Server and UDP Client to demonstrate what each one does and how sockets work. The code size is very small and give you a good idea about how a UDP Server opens up a port, and then the UDP Client sends or receives data from that port.

To compile these, install Java JDK to your system. Then compile the program with javac UDPClient.java – this will create a UDPClient.class. Execute the file with java UDPClass – leave off the .class, or you will get the error: “Exception in thread “main” java.lang.NoClassDefFoundError”.

Here is sample code for a simple Java UCP Server and Client, originally from Computer Networking: A Top Down Approach, by Kurose and Ross:

 */

/**
 * @author estevam
 */
public class UDPServer {
	public static void main(String args[]) throws Exception {
		@SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
	}
}