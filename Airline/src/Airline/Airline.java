/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anita Way
 */
import java.io.*;
import java.util.*;
 
public class Airline {
 
    /**
     * The number of seats on the plane
     */
    static final int MAX_SEATS = 8;
 
    public static void main(String[] args) {
        Airline airline = new Airline();
    }
 
    public Airline() {
        boolean done = false;
 
        String[] seats = new String[MAX_SEATS]; // the passenger list
        initializeSeats(seats);
 
        do {
            printMainMenu();
            int choice = getMainMenuChoice(); // choice off of the main menu
 
            switch (choice) {
            case 1:
                makeReservation(seats);
                break;
            case 2:
                cancelReservation(seats);
                break;
            case 3:
                printSeatingChart(seats);
                break;
            case 4:
                done = true;
                break;
            }
 
        } while (!done);
 
    }
 
    void printMainMenu() {
        System.out.println("\nMain Menu\n");
        System.out.println("1. Make a reservation");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Print seating chart");
        System.out.println("4. Quit");
        System.out.println();
    }
 
    /**
     * Get the user's choice off the main menu
     */
    int getMainMenuChoice() {
        int choice; // choice entered
        boolean valid = false; // is choice valid?
 
        do {
            System.out.print("===> ");
            choice = Console.readInt();
 
            if (choice >= 1 && choice <= 4) {
                valid = true;
            } else {
                System.out.println("Invalid choice.");
            }
        } while (!valid);
 
        return choice;
    }
 
    /**
     * Initialize each element of seats to the empty string
     */
    void initializeSeats(String[] seats) {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = "";
        }
    }
 
    /**
     * Make a reservation
     */
    void makeReservation(String[] seats) {
        int seatIndex = findEmptySeat(seats); // index of first empty seat
        if (seatIndex == seats.length) {
            System.out.println("All seats are full. Sorry.");
        } else {
            String name = getPassengerName(); // passenger's name
            seats[seatIndex] = name;
            System.out.println(name + " has been assigned seat #"
                    + (seatIndex + 1));
        }
    }
 
    /**
     * Cancel a reservation
     */
    void cancelReservation(String[] seats) {
        int seatIndex = getSeatToCancel(); // index of seat to cancel
                                            // reservation for
        if (isEmpty(seats, seatIndex)) {
            System.out.println("Seat #" + (seatIndex + 1)
                    + " has not been reserved for anyone");
        } else {
            seats[seatIndex] = "";
            System.out
                    .println("Seat #" + (seatIndex + 1) + " is now available");
        }
    }
 
    /**
     * Print the seating chart
     */
    void printSeatingChart(String[] seats) {
        System.out.println("\nSeating Chart\n");
        for (int i = 0; i < seats.length; i++) {
            System.out.println((i + 1) + ". " + seats[i]);
        }
    }
 
    /**
     * Find the index of the first empty seat on the plane. If there are no
     * empty seats, return seats.length
     */
    int findEmptySeat(String[] seats) {
        for (int i = 0; i < seats.length; i++) {
            if (isEmpty(seats, i)) {
                return i;
            }
        }
 
        return seats.length;
    }
 
    /**
     * Yield whether seats[seatIndex] is an empty seat.
     */
    boolean isEmpty(String[] seats, int seatIndex) {
        return seats[seatIndex].equals("");
    }
 
    /**
     * Input a passenger's name
     */
    String getPassengerName() {
        System.out.print("Enter the passenger's name: ");
        return Console.readString();
    }
 
    /**
     * Input the number of a seat to cancel, return the index of that seat.
     */
    int getSeatToCancel() {
        boolean valid = false; // is the seat number valid?
        int seat = 0; // seat number to cancel
 
        do {
            System.out.print("Enter the seat to cancel: ");
            seat = Console.readInt();
            if (1 <= seat && seat <= MAX_SEATS) {
                valid = true;
            } else {
                System.out.println("Invalid seat number");
            }
        } while (!valid);
 
        return seat - 1;
    }
 
}
