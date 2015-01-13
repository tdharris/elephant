package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;



public class Main {

   public static void main(String[] args) throws IOException {
      try 
      {
         ServerSocket server = new ServerSocket(6677);
         System.out.println("Waiting for clients...");
      
         // While the program is running, do this
         while (true)
         {  // Wait for client to connect                                  
            Socket s = server.accept();
            
            System.out.println("Client connected from " + s.getLocalAddress().getHostName());
            
            // Create Client with Socket parameter
            Client c = new Client(s);
            
            // Create/Start thread for Client c
            Thread t = new Thread(c);
            t.start();
         }
      } 
      catch (Exception e) 
      {
         System.out.println("An error occured.");
         e.printStackTrace();
      }
   }

}