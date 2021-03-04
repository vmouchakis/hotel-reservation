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



public class Hotel {

    Random rand = new Random();
    
    String name;    
        
    public Floor[] floors;
    
    public static Client c;
    
    public Hotel(String name, int numberOfFloors) {                             //constructor του ξενοδοχείου
        this.name = name;
        this.floors = new Floor[numberOfFloors];
    }
    
    
    public void setFloorRooms(int floorNumber) {                                //βάζει στοιχεία σε κάθε δωμάτιο κάθε ορόφου
        floors[floorNumber] = new Floor(floorNumber, Project1.NUM_FLOOR_ROOMS);
        
        int numBeds = rand.nextInt(2) + 2;
        int type = rand.nextInt(2) + 1;
        
        
        for(int j = 0; j < Project1.NUM_FLOOR_ROOMS; j++) {
            floors[floorNumber].setRoomData(j, numBeds, type);
        }
        
    }
    
    public int searchRoom(int numBeds, int type) {                              //search σε περίπτωση που ο πελάτης δε θέλει συγκεκριμένο όροφο
        int x;
        for(int i = 0; i < Project1.NUM_FLOORS; i++) {
            if(floors[i].searchRoom(numBeds, type) > -1) {
                x = floors[i].searchRoom(numBeds, type);
                return x++;                                                     //επιστρέφει το αριθμό του δωματίου, αν βρήκε
            }
        }
        return -1;                                                              //αλλιώς επιστρέφει -1
    }
    
    public int searchRoom(int floorNumber, int numBeds, int type) {             //search σε περίπτωση που ο πελάτης θέλει συγκεκριμένο όροφο
        int x = floors[floorNumber].searchRoom(numBeds, type);
        x++;
        if(x > 0)                                
            return x;                                                           //όπως και παραπάνω, επιστρέφει με ίδιο τρόπο 
        else
            return -1;
    }
    
    public void bookRoom(int room, int client, int checkOutDate) {              //κλείνει το δωμάτιο αν ταιριάζει με αυτό που ζητάει ο πελάτης
        int f = Project1.c.getFloor();                                          //το f είναι ο αριθμός ορόφου
        floors[f].rooms[room].checkIn();
        floors[f].rooms[room].checkOutDate = checkOutDate;
        System.out.println("Το δωμάτιό σας είναi το " + floors[f].rooms[room].number +  " και είναι έτοιμο. Σας ευχόμαστε καλή διαμονή.");
    } 
    
    public void emptyRooms(int currentDay) {                                    //αδειάζει τα δωμάτια
        for(int i = 0; i < Project1.NUM_FLOORS; i++) {
            floors[i].emptyRooms(currentDay);
        }
    }
    
    public void serviceClient() {                                               
        Project1.c.decideBooking(Project1.NUM_FLOORS - 1, 2);
        System.out.println("Θέλετε συγκεκριμένο όροφο;");
        int room, x = rand.nextInt(2) + 1;                                      //αν το x είναι 1 ο πελάτης θέλει συγκεκριμένο όροφο, αλλιώς όχι.
        if(x == 1) {
            System.out.println("Επιλέξατε τον όροφο: " + (Project1.c.floor + 1) + ".");
            room = searchRoom(Project1.c.floor, Project1.c.bedNumber, Project1.c.roomType);
        }    
        else {
            System.out.println("Δεν επιλέξατε όροφο.");
            room = searchRoom(Project1.c.bedNumber, Project1.c.roomType);
        }
        
        if(room == -1) {
            System.out.println("Δεν υπάρχουν διαθέσιμα δωμάτια σύμφωνα με τα κριτήρια που δώσατε.");
            System.out.println("Ευχαριστούμε που μας προτιμήσατε. Ελπίζουμε να σας ξαναδούμε.");
        }
        else {
            System.out.println("Υπάρχουν διαθέσιμα δωμάτια σύμφωνα με τα κριτήρια που δώσατε.");
            bookRoom(room + 1, Project1.c.getId(), Project1.COUNTER + Project1.c.getDays());
            Project1.c.printClientData();
        }
        
    }

    
    public void print() {
        for(int i = 0; i < Project1.NUM_FLOORS; i++) {
            i++;                                                                //το i αυξάνει προσωρινά για να τυπωθεί σωστά ο αριθμός του δωματίου
            System.out.println("Όροφος: " + i);
            i--;
            floors[i].print();
        }
    }
 
    public void printRooms() {
        for(int i = 0; i < Project1.NUM_FLOORS; i++) {
            for(int j = 0; j < Project1.NUM_FLOOR_ROOMS; j++) {
                System.out.println("Δωμάτιο: " + floors[i].rooms[j].number + ", αριθμός κρεβατιών: " + floors[i].rooms[j].numBeds + ", τύπος: " + floors[i].rooms[j].type);
            }
        }
    }
    
}
