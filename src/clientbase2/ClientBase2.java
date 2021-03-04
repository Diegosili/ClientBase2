/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientbase2;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Sviluppare un applicativo ClientServer che generi tanti Thread quanti dichiarati dall'utente attraverso un Thread a lui dedicato.
 * Ogni Thread sommerà a una variabile globale contenuta nel server il proprio valore incrementale assegnatogli dal Server da 1 a n, dove n è il numero dei Thread;
 * Il Server killerà ogni processo dopo aver svolto l'operazione, quando tutti i processi saranno killati il Server stamperà a console il risultato
 * 
 * @author siliprandi.diego
 */
public class ClientBase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertua connessione");
        
        try {
            Socket server = new Socket("127.0.0.1", 5500);

            PrintWriter scrittore = new PrintWriter(server.getOutputStream(), true);
            Scanner tastiera = new Scanner(System.in);
            int s = 0;
            
            System.out.println("Inserire numero di Thread da attivare:");
            s = tastiera.nextInt();
            scrittore.println(s);
            
            server.close();
            System.out.println("chiusura connessione");
            
        } catch (IOException ex) {
            Logger.getLogger(ClientBase2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
