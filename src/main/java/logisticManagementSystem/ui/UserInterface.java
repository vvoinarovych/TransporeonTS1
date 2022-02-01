package logisticManagementSystem.ui;

import logisticManagementSystem.FormatValidator;
import logisticManagementSystem.InputHandler;
import logisticManagementSystem.LogisticManager;


import java.util.Scanner;


public class UserInterface {
    public static void main(String[] args) {
        LogisticManager manager = new LogisticManager();
        Scanner input = new Scanner(System.in);
        FormatValidator validator = new FormatValidator();
        InputHandler inputHandler = new InputHandler(new Scanner(System.in), validator );
        System.out.println("============= LockerManager menu =============");
        System.out.println("[1] Add Parcel Locker\n[2] Remove Parcel Locker\n[3] Display all Parcel Lockers\n[4] Display Parcel Lockers in specific city\n[5] Update Parcel Locker information\n[6] Add Parcel\n[7] Remove Parcel\n[8] Display Parcel in specific Parcel Locker\n[9] Update Parcel information\n[0] Exit");

        do {
            String choice = inputHandler.takeMenuChoice();

        } while (true);


    }


}
