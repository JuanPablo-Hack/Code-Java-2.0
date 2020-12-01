package client;

import java.net.*;
import java.io.*;

class EchoObjectStub2 implements EchoInt, Runnable {

  private Socket echoSocket = null;
  private PrintWriter os = null;
  private BufferedReader is = null;
  private String host = "localhost";
  private int port=7;
  private String output = "Error";
  private boolean connected  = false;

  private Thread reloj = new Thread(this, "reloj");
  private int timeout = 50;
  private boolean firstTime = true;

  public EchoObjectStub2(String host, int port) {
    this.host= host; this.port =port;
  }

  public String echo(String input)throws java.rmi.RemoteException {
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
    programDisconnection();
    return output;
  }

  private synchronized void connect() throws java.rmi.RemoteException {
    //EJERCICIO: lo mismo que en EchoObjectStub
  }

  private synchronized void disconnect(){
    //EJERCICIO: lo mismo que en EchoObjectStub
  }

  private synchronized void programDisconnection(){
    //EJERCICIO: programar un timeout para la cabo de 5 segundos

  }

   class Timeout {
     Timer timer;
     EchoObjectStub stub;
     int seconds;

     public Timeout (int seconds, EchoObjectStub stub) {
       this.seconds = seconds;
       this.stub = stub;
     }

     public void start() {
       //EJERCICIO
	 }

     public void cancel() {
        //EJERCICIO
     }

     class TimeoutTask extends TimerTask {
          //EJERCICIO
	 }

   }
}
