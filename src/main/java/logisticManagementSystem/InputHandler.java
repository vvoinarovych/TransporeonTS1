package logisticManagementSystem;

import java.util.Scanner;

public class InputHandler {
    Scanner input;
    FormatValidator validator;

    public InputHandler(Scanner input, FormatValidator validator) {
        this.input = input;
        this.validator = validator;
    }

    public String takeLockerName() {
        System.out.println("Type Locker name in format: XXXXYYY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9 ");
        return takeObjectName();
    }

    public String takeParcelName() {
        System.out.println("Type Parcel name in format: XXXXYYY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9 ");
        return takeObjectName();
    }

    private String takeObjectName() {
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerNameValid(checking)) {
                System.out.println("Not good, try again: ");
            }
        } while (validator.lockerNameValid(checking));
        return checking;
    }

    public String takeMenuChoice() {
        System.out.println("Chose what do you want to do: ");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.menuChoiceValid(checking)) {
                System.out.println("Pls type number in a 0-9 range");
            }
        } while (validator.menuChoiceValid(checking));
        return checking;
    }

    private String takeLockerIdBase() {
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerIdValid(checking)) {
                System.out.println("Pls type id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
            }
        } while (validator.lockerIdValid(checking));
        return checking;
    }

    public String takeLockerId() {
        System.out.println("Provide locker id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
        return takeLockerIdBase();
    }

    public String takeRecipientLockerId() {
        System.out.println("Provide recipient locker id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
        return takeLockerIdBase();
    }

    public String takeSenderLockerId() {
        System.out.println("Provide sender locker id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
        return takeLockerIdBase();
    }

    public Address takeLockerAddress() {
        System.out.println("Provide locker address in format: street, city, postal Code: ");
        return new Address(takeLockerAddressStreet(),  takeLockerAddressCity(), takeLockerPostalCode());
    }

    private String takeLockerAddressStreet() {
        System.out.println("Type name of Street:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerAddressStreetValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.lockerAddressStreetValid(checking));
        return checking;
    }

    public String takeLockerAddressCity() {
        System.out.println("Type name of City:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerAddressStreetValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.lockerAddressStreetValid(checking));
        return checking;
    }

    private String takeLockerPostalCode() {
        System.out.println("Type locker Postal Code in format XX-XXX\nwhere X = number from 0 to 9");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerPostalCodeValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.lockerPostalCodeValid(checking));
        return checking;
    }

    public double takeParcelWeight() {
        System.out.println("Type parcel weight:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.parcelWeightValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.parcelWeightValid(checking));
        return Double.parseDouble(checking);
    }

    private String takeName() {
        String checking;
        do {
            checking = input.nextLine();
            if (validator.nameValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.nameValid(checking));
        return checking;
    }

    public String takeRecipientName() {
        System.out.println("Type Parsel's recipient name:");
        return takeName();
    }

    public String takeSenderName() {
        System.out.println("Type Parsel's sender name:");
        return takeName();
    }

    public Size takeParcelSize() {
        System.out.println("Chose parcel size from: S,L,XL,XXL,XXXL:");
        Size result = null;
        String checking;
        do {
            checking = input.nextLine();
            for (Size size : Size.values()) {
                if (size.name().equalsIgnoreCase(checking)) {
                    result = size;
                    break;
                }
            }
            if (result == null) {
                System.out.println("Try again");
            }
        } while (result == null);
        return result;
    }

    public State takeParcelState() {
        System.out.println("Chose parcel size from: RECEIVED,SENT,WAITING_FOR_PICKING_UP,DELIVERED:");
        State result = null;
        String checking;
        do {
            checking = input.nextLine();
            for (State state : State.values()) {
                if (state.name().equalsIgnoreCase(checking)) {
                    result = state;
                    break;
                }
            }
            if (result == null) {
                System.out.println("Try again");
            }
        } while (result == null);
        return result;
    }
    public String takeParcelId() {
        System.out.println("Type parcel Id:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.parcelIdValid(checking)) {
                System.out.println("Try again: ");
            }
        } while (validator.parcelIdValid(checking));
        return checking;
    }
}
