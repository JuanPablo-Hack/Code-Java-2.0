package client;

import java.net.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import rmi.EchoInt;

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
    //EJERCICIO: lo mismo que en EchoObjectStub		YA, creo...
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
    //EJERCICIO: lo mismo que en EchoObjectStub		YA
	  try {
			os.close();
			is.close();
			echoSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("I/O failed on connection to: "+host);
		}
  }

  private synchronized void programDisconnection(){
    //EJERCICIO: programar un timeout para la cabo de 5 segundos
	//Timeout uno = new Timeout(5).start();
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
    	 //EJERCICIO	YA
    	 Date h = new Date();
         System.out.println(DateFormat.getTimeInstance(3,Locale.FRANCE).format(h) + 
        		 	" Faltan " + seconds + " seg. para la alarma");
	 }

     public void cancel() {
        //EJERCICIO
     }
     
     class TimeoutTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
          //EJERCICIO
	 }

   }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
