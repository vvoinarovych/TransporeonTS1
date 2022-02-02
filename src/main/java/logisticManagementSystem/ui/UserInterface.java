package logisticManagementSystem.ui;
import logisticManagementSystem.model.Address;
import logisticManagementSystem.services.FormatValidator;
import logisticManagementSystem.services.InputHandler;
import logisticManagementSystem.services.LogisticManager;

import java.util.Scanner;


public class UserInterface {
    public static void main(String[] args) {
        LogisticManager manager = new LogisticManager();
        boolean isRunning = true;
        FormatValidator validator = new FormatValidator();
        InputHandler inputHandler = new InputHandler(new Scanner(System.in), validator);
        String initMenu = "============= LockerManager menu =============\n[1] Add Parcel Locker\n[2] Remove Parcel Locker\n[3] Display all Parcel Lockers\n[4] Display Parcel Lockers in specific city\n[5] Update Parcel Locker information\n[6] Add Parcel\n[7] Remove Parcel\n[8] Display Parcel in specific Parcel Locker\n[9] Update Parcel information\n[0] Exit";

        do {
            System.out.println(initMenu);
            String choice = inputHandler.takeMenuChoice();
            switch (choice) {
                case "0" -> {
                    System.out.println("Closing the app. Have a nice day!");
                    isRunning = false;
                }
                case "1" -> {
                    System.out.println("You chose [1] Add Parcel Locker");
                    manager.addLocker(inputHandler.takeLockerId(), inputHandler.takeLockerName(), new Address(inputHandler.takeLockerAddress()));
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
                    manager.displayLockersByCity(inputHandler.takeLockerAddressCity());
                }
                case "5" -> {
                    System.out.println("You chose [5] Update Locker information");
                    manager.updateLockerInfo(inputHandler.takeLockerId(), inputHandler.takeLockerName(), inputHandler.takeLockerAddress());
                }
                case "6" -> {
                    System.out.println("You chose [6] Add Parcel");
                    manager.addParcel(inputHandler.takeParcelName(), inputHandler.takeParcelSize(), inputHandler.takeParcelWeight(), inputHandler.takeRecipientName(), inputHandler.takeSenderName(), inputHandler.takeSenderLockerId(), inputHandler.takeRecipientLockerId());
                }
                case "7" -> {
                    System.out.println("You chose [7] Remove Parcel");
                    manager.deleteParcel(inputHandler.takeParcelId());
                }
                case "8" -> {
                    System.out.println("You chose [8] Display Parcels in specific Parcel Locker");
                    manager.displayAllParcelsByLockerId(inputHandler.takeLockerId());
                }
                case "9" -> {
                    System.out.println("You chose [9] Update Parcel information");
                    manager.updateParcel(inputHandler.takeParcelId(), inputHandler.takeLockerName(), inputHandler.takeParcelSize(), inputHandler.takeParcelWeight(), inputHandler.takeRecipientName(), inputHandler.takeSenderName(), inputHandler.takeRecipientLockerId(), inputHandler.takeSenderLockerId(), inputHandler.takeParcelState());
                }
            }
        } while (isRunning);
    }
}
