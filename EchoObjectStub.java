package client;

import java.net.*;

import rmi.EchoInt;

import java.io.*;

class EchoObjectStub implements EchoInt{

  private Socket echoSocket = null;
  private PrintWriter os = null;
  private BufferedReader is = null;
  private String host = "localhost";
  private int port=7;
  private String output = "Error";
  private boolean connected  = false;

  public EchoObjectStub(String host, int port) {
    this.host = host; this.port = port;
  }

  public String echo(String input) throws java.rmi.RemoteException {
    connect();
    if (echoSocket != null && os != null && is != null) {
       try {
             os.println(input);
             os.flush();
             output= is.readLine();
      } catch (IOException e) {
        System.err.println("I/O failed in reading/writing socket");
        throw new java.rmi.RemoteException("I/O failed in reading/writing socket");
      }
    }
    disconnect();
    return output;
  }

  private synchronized void connect() throws java.rmi.RemoteException {
    //EJERCICIO: Implemente el método connect		YA, creo...
	try {
		echoSocket = new Socket(host, port);
		is = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		os = new PrintWriter(echoSocket.getOutputStream());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		System.err.println("Don't know about host: "+host);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.err.println("Couldn't get I/O for connection to: "+host);
	}
	
  }

  private synchronized void disconnect(){
    //EJERCICIO: Implemente el método disconnect
	try {
		os.close();
		is.close();
		echoSocket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.err.println("I/O failed on connection to: "+host);
	}
  }
}
