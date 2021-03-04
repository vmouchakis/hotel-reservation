/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;


/**
 *
 * @author vasilism
 */

import java.util.Random;


public class Project1 {
    
    
    public static final int NUM_FLOORS = 4;
    public static final int NUM_FLOOR_ROOMS = 99;
    public static int COUNTER = 1;                                              //μετρητής για τις μέρες λειτουργίας του ξενοδοχείου
    
    public static Hotel h1;
    public static Client c;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        createHotel();
        runSimulation();
    }
    
    public static void createHotel() {
        h1 = new Hotel("Tierra Patagonia Hotel & Spa", Project1.NUM_FLOORS);
        
        for(int i = 0; i < Project1.NUM_FLOORS; i++) {
            h1.setFloorRooms(i);            
        }
        
        System.out.println("Καλώς ήρθατε στο ξενοδοχείο " + h1.name + ".");
        
        h1.printRooms();                                                        //τυπώνει τις λεπτομέρειες κάθε δωματίου
        
        //h1.print();                                                           //τυπώνει τα δωμάτια του ξενοδοχείου σε μορφή πλέγματος
    }
    
    public static void runSimulation() {
        
        Random rand = new Random();
        
        int clientsSum = rand.nextInt(7) + 1;                                   //το πλήθος των πελατών την ημέρα δεν ξεπερνά τους 7
        
        while(COUNTER < 20) {
            System.out.println();
            System.out.println("----------Ημέρα " + COUNTER + "η.----------");
            System.out.println();
            for(int i = 1; i <= clientsSum; i++) {
                c = new Client();
                System.out.println("Καλώς ήρθατε πελάτη νο." + c.getId());
                System.out.println("Τι δωμάτιο θα θέλατε;");
                h1.serviceClient();
            }
           
            h1.emptyRooms(COUNTER);
            COUNTER++;
        }
        
        System.out.println("\n\nΤο ξενοδοχείο μας θα παραμέινει κλειστό μέχρι νεωτέρας λόγω ανακαίνισης. Φροντίζουμε να βελτιωνόμαστε για να μένετε ευχαριστημένοι. Ευχαριστούμε που μας επιλέξατε. \nΕκ της διευθύνσεως");
        
    }
    
}
