package com.cg.FlightManagement.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner scr = new Scanner(System.in);
    static public int returnInt(String message){
        boolean stayHere;
        int input = 0;
        do {
            stayHere = false;
            try {
                System.out.println(message);
                input = scr.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input in correct format. Example options cannot be alphabet");
                scr.next();// do not remove this
                stayHere = true;
            }
        }while (stayHere);
        return input;
    }

    static public long returnLong(String message){
        boolean stayHere;
        long input = 0;
        do {
            stayHere = false;
            try {
                System.out.println(message);
                input = scr.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Please input in correct format. Example options cannot be alphabet");
                scr.next();// do not remove this
                stayHere = true;
            }
        }while (stayHere);
        return input;
    }

    static public String returnStringAfterInt(String message){
        boolean stayHere;
        String input = "";
        do {
            stayHere = false;
            try {
                System.out.println(message);
                scr.nextLine();
                input = scr.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please input in correct format. Example options cannot be alphabet");
                scr.next();// do not remove this
                stayHere = true;
            }
        }while (stayHere);
        return input;
    }
    static public String returnString(String message){
        boolean stayHere;
        String input = "";
        do {
            stayHere = false;
            try {
                System.out.println(message);
                input = scr.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please input in correct format. Example options cannot be alphabet");
                scr.next();// do not remove this
                stayHere = true;
            }
        }while (stayHere);
        return input;
    }
}
