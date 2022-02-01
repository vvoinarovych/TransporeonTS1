package logisticManagementSystem.ui;

import logisticManagementSystem.*;
import logisticManagementSystem.model.Address;
import logisticManagementSystem.model.Locker;


import java.util.Scanner;


public class UserInterface {
    public static void main(String[] args) {
        LogisticManager manager = new LogisticManager();
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        FormatValidator validator = new FormatValidator();
        InputHandler inputHandler = new InputHandler(new Scanner(System.in), validator);
        System.out.println("============= LockerManager menu =============");
        System.out.println("[1] Add Parcel Locker\n[2] Remove Parcel Locker\n[3] Display all Parcel Lockers\n[4] Display Parcel Lockers in specific city\n[5] Update Parcel Locker information\n[6] Add Parcel\n[7] Remove Parcel\n[8] Display Parcel in specific Parcel Locker\n[9] Update Parcel information\n[0] Exit");

        Locker l1 = new Locker("XXX-11", "locker1", new Address("street1", "Yityy", "PC1"));
        Locker l2 = new Locker("XXX-12", "locker2", new Address("street2", "Dityu", "PC1"));
        Locker l3 = new Locker("XXX-13", "locker3", new Address("street3", "Qity", "PC1"));
        Locker l4 = new Locker("XXX-14", "locker4", new Address("street4", "Tity", "PC1"));
        Locker l5 = new Locker("XXX-15", "locker5", new Address("street5", "Nity", "PC1"));
        manager.addLocker(l1, l2, l3, l4, l5);
        do {
            String choice = inputHandler.takeMenuChoice();
            switch (choice) {
                case "0" -> {
                    System.out.println("Closing the app. Have a nice day!");
                    isRunning = false;
                }
                case "1" -> {
                    System.out.println("You chose [1] Add Parcel Locker");
                    manager.addLocker(inputHandler.takeLockerId(), inputHandler.takeLockerName(), new Address(inputHandler.takeLockerAddress()));
                    System.out.println("Locker added\n");
                }
                case "2" -> {
                    System.out.println("You chose [2] Remove Parcel Locker");
                    manager.deleteLocker(inputHandler.takeLockerId());
                }
                case "3" -> {
                    System.out.println("You chose [3] Display all Lockers");
                    manager.displayAllLockers();
                }
                case "4" -> {
                    System.out.println("You chose [4] Display  all Lockers in a specific City");
                    manager.displayLockersByCity(inputHandler.takeLockerId());
                }
                case "5" -> {
                    System.out.println("You chose [5] Update Locker information");
                    manager.updateLockerInfo(inputHandler.takeLockerId(), inputHandler.takeLockerName(), inputHandler.takeLockerAddress());
                }
                case "6" -> {
                    System.out.println("You chose [6] Add Parcel");
                    String name = inputHandler.takeLockerName();
                    Size size = inputHandler.takeParcelSize();
                    double weight = inputHandler.takeParcelWeight();
                    String recipient = inputHandler.takeName();
                    String sender = inputHandler.takeName();
                    String senderLockerId = inputHandler.takeLockerId();
                    String recipientLockerId = inputHandler.takeLockerId();
                    State state = inputHandler.takeParcelState();
                    manager.addParcel(name, size, weight, recipient, sender, senderLockerId, recipientLockerId, state);
                }
            }

        } while (isRunning);


    }


}
