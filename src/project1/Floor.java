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


public class Floor {
    
    public int number, numberOfRooms;
    public Room[] rooms;

    
    public Floor(int floorNumber, int numberOfRooms) {                          //constructor του ορόφου
        
        this.number = floorNumber;
        this.rooms = new Room[numberOfRooms];
    }
  
    
    public int roomIndexFromNumber(int roomNumber) {                            //επιστρέφει αναφορά σε κάποιο δωμάτιο αν υπάρχει
        if(roomNumber % 100 < 10)
            return roomNumber % 100 - 1;
        else if(roomNumber % 100 <= 10)
            return roomNumber % 10 - 1;
        
        System.out.println("Το δωμάτιο που επιθυμείτε δεν υπάρχει.");
        return -1;
    }
    
    public void setRoomData(int roomNumber, int numBeds, int type) {                        //βάζει στοιχεια στα δωμάτια
        rooms[roomNumber] = new Room(100 * (number + 1) + roomNumber + 1, numBeds, type);
    }
    
    public int searchRoom(int numBeds, int type) {                              //ψάχνει κάποιο δωμάτιο
        int x = 0;
        
        for(int i = 0; i < Project1.NUM_FLOOR_ROOMS; i++) {
            if(numBeds == rooms[i].numBeds && type == rooms[i].type) {
                x = i;
                //System.out.println("Υπάρχουν διαθέσιμα δωμάτια σύμφωνα με τα κριτήρια που δώσατε.");
                break;
            }    
            else {
                x = -1;
            }
        } 
        
        return x;
    }
    
    public void emptyRooms(int currentDay) {                                    //αδειάζει τα δωμάτια
        for(int i = 0; i < Project1.NUM_FLOOR_ROOMS; i++) {
            if(rooms[i].checkOutDate == currentDay) {
                System.out.println("Σήμερα αδειάζει το δωμάτιο " + rooms[i].number + ".");
                rooms[i].client = 0;
            }
        }
    }
    
    public void print() {
        for(int i = 0; i < Project1.NUM_FLOOR_ROOMS; i++) {
            rooms[i].print();
        }
    }
    
}
