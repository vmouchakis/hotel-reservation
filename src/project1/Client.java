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



public class Client {

    Random rand = new Random();

    
    private static int id = 0;
    public int bedNumber, roomType, floor, days;
    
   
                
    public Client() {                                                           //constructor του πελάτη
        id++;
    }
    
    public void decideBooking(int floorsNumber, int roomsType) {                //δημιουργεί με τυχαίο τρόπο την κράτηση του κάθε πελάτη
        setType(roomsType);
        setBeds();
        setDays();
        int x = rand.nextInt(2) + 1;
        if(x == 1) {                                                            //αν το x είναι 1, ο πελάτης θέλει συγκεκριμένο όροφο, αλλιώς όχι
            setFloor(floorsNumber);
            System.out.println("Επιλέξατε δωμάτιο τύπου " + this.roomType + ", με " + this.bedNumber + " κρεβάτια, στον όροφο " + this.floor + ".");
        } else
            System.out.println("Επιλέξατε δωμάτιο τύπου " + this.roomType + ", με " + this.bedNumber + " κρεβάτια.");
        
    }
    
    public void setType(int roomsType) {
        this.roomType = rand.nextInt(roomsType) + 1;
    }
    
    public void setBeds() {
        this.bedNumber = rand.nextInt(2) + 2;
    }
    
    public void setDays() {
        this.days = rand.nextInt(4) + 1;
    }
    
    public void setFloor(int floorsNumber) {
        this.floor = rand.nextInt(floorsNumber) + 1;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getBedNumber() {
        return bedNumber;
    }
    
    public int getRoomType() {
        return roomType;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public int getDays() {
        return this.days;
    }
    
    public void printClientData() {
        System.out.println("Ο πελάτης "+ getId() + " έχει δωμάτιο τύπου " + getRoomType() + " με " + getBedNumber() + " κρεβάτια " + " μέχρι τη μέρα " + (getDays() + Project1.COUNTER) + ".");
    }
    
}
