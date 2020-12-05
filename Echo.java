package client;

import java.io.*;
import java.net.*;

import rmi.EchoInt;

public class Echo {
	private static EchoInt ss;

  public static void main(String[] args) {

    if (args.length<2) {
  		System.out.println("Usage: Echo <host> <port#>");
  		System.exit(1);
  	}
    ss = new EchoObjectStub("localhost",7);
    //EJERCICIO: crear una instancia de EchoObject o EchoObjectStub		YA

    BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
    PrintWriter stdOut = new PrintWriter(System.out);
    String input,output;
    try {
       //EJERCICIO: el bucle infinito:
       //EJERCICIO: Leer de teclado
       //EJERCICIO: Invocar el stub		YA
       //EJERCICIO: Imprimir por pantalla
       while((input = stdIn.readLine()) != null) {
    	   output = input;
    	   ss.echo(output);
    	   stdOut.println(output);
       }
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host: "+ args[0]);
    } catch (IOException e) {
      System.err.println("I/O failed for connection to: "+args[0]);
    }
  }
}
