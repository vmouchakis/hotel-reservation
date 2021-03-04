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

 



public class Room {
    
    
    public int number, numBeds, type, client, checkOutDate;
    
    public Room(int number, int numBeds, int type) {                            //constructor του δωματίου
        this.client = 0;
        this.number = number;
        this.numBeds = numBeds;
        this.type = type; 
        this.checkOutDate = 0;
    }
    
    public void setNumBeds(int numberOfBeds) {
        if(numberOfBeds == 3 || numberOfBeds == 2) {
            this.numBeds = numberOfBeds;
        }
    }
    
    public void setType(int roomType) {   
        if(roomType == 1 || roomType == 2) {
            this.type = roomType;
        }
    }
    
    public void checkIn() {
        this.client = Project1.c.getId();
    }
    
    public void checkOut() {
        this.client = 0;
    }
    
    public void isEmpty(){                                                      //ελέγχει αν κάποιο δωμάτιο είναι ελεύθερο
        if(this.client == 0) {
            System.out.println("Το δωμάτιο είναι διαθέσιμο.");
        }
        else if(this.client > 0) {
            System.out.println("Το δωμάτιο δεν είναι διαθέσιμο.");
        }
    }
    
    public void print() {
        if(number % 100 < 10)
            System.out.printf("%d ",number);
        else
            System.out.println(number);
    }
}
