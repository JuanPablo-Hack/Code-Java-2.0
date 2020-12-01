package server;

import java.net.*;
import java.io.*;

public class EchoMultiServer {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {

      try {
           serverSocket = new ServerSocket(7);
      } catch (IOException e) {
           System.out.println("EchoMultiServer: could not listen on port: 7, " + e.toString());
           System.exit(1);
      }
      System.out.println("EchoMultiServer listening on port: 7");

      boolean listening = true;
      while (listening) {
         //EJERCICIO: aceptar una nueva conexi�n
         //EJERCICIO: y crear un Thread para que la gestione
     }

     try {
          serverSocket.close();
     } catch (IOException e) {
          System.err.println("Could not close server socket." + e.getMessage());
     }
   }
}

//----------------------------------------------------------------------------
//  class EchoMultiServerThread
//----------------------------------------------------------------------------

class EchoMultiServerThread extends Thread {
    private static EchoObject eo = new EchoObject();
    private Socket clientSocket = null;
    private String myURL = "localhost";
    private BufferedReader is = null;
    private PrintWriter os = null;
    private String inputline = new String();

    EchoMultiServerThread(Socket socket) {
        super("EchoMultiServerThread");
        clientSocket = socket;
        try {
             is = new BufferedReader(new InputStreamReader( //EJERCICIO ... ));
             os = new PrintWriter( //EJERCICIO ... );
        } catch (IOException e) {
            System.err.println("Error sending/receiving" + e.getMessage());
            e.printStackTrace();
        }
        try {
           myURL=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
           System.out.println("Unknown Host :" + e.toString());
           System.exit(1);
       }
    }

    public void run() {
       try {
            while ((inputline = is.readLine()) != null) {
                 //EJERCICIO: Invocar el objeto
                 //EJERCICIO: y devolver la respuesta por el socket
            }

            os.close();
            is.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error sending/receiving" + e.getMessage());
            e.printStackTrace();
        }
    }
}