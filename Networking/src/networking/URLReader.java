/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class URLReader {
   public static void main(String[] args) throws Exception {
   URL google;
   String nombre;
   Scanner teclado = new Scanner(System.in);
   nombre = teclado.nextLine();
   google = new URL(nombre);
   System.out.println("protocol :" + google.getProtocol());
   System.out.println("authority :" + google.getAuthority());
   System.out.println("port :" + google.getPort());
   System.out.println("host :" + google.getHost());
   System.out.println("path :" + google.getPath());
   System.out.println("query :" + google.getQuery());
   System.out.println("file :" + google.getFile());
   System.out.println("ref :" + google.getRef());
   FileWriter file = new FileWriter("google.html");
   PrintWriter pw = new PrintWriter(file);

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
     String inputLine = null;
    while ((inputLine = reader.readLine()) != null) {
     pw.println(inputLine);
    }
    file.close();
   } catch (IOException x) {
    System.err.println(x);
    
   }
    
   }
  
}