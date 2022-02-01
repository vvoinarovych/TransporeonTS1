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
        System.out.println("type name in format: XXXXYYY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9 ");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerNameValid(checking))
                System.out.println("Not good, try again: ");
        } while (validator.lockerNameValid(checking));
        return checking;
    }

    public String takeMenuChoice() {
        System.out.println("chose what you want: ");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.menuChoiceValid(checking))
                System.out.println("Pls type number in a 0-9 range");
        } while (validator.menuChoiceValid(checking));
        return checking;
    }

    public String takeLockerId() {
        System.out.println("provide locker id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerIdValid(checking))
                System.out.println("Pls type id in format: XXX-YY\nwhere:\nX = capital letter from A to Z\nY = number from 0 to 9");
        } while (validator.lockerIdValid(checking));
        return checking;
    }

    public String takeLockerAddress() {
        System.out.println("provide locker address in format: street, city, postal Code: ");
        return takeLockerAddressStreet() + ", " + takeLockerAddressCity() + ", " + takeLockerPostalCode();
    }

    private String takeLockerAddressStreet() {
        System.out.println("type name of Street:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerAddressStreetValid(checking))
                System.out.println("Try again: ");
        } while (validator.lockerAddressStreetValid(checking));
        return checking;
    }

    private String takeLockerAddressCity() {
        System.out.println("type name of City:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerAddressStreetValid(checking))
                System.out.println("Try again: ");
        } while (validator.lockerAddressStreetValid(checking));
        return checking;
    }

    private String takeLockerPostalCode() {
        System.out.println("type locker Postal Code in format XX-XXX\nwhere X = number from 0 to 9");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.lockerPostalCodeValid(checking))
                System.out.println("Try again: ");
        } while (validator.lockerPostalCodeValid(checking));
        return checking;
    }

    public double takeParcelWeight() {
        System.out.println("type parcel weight:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.parcelWeightValid(checking))
                System.out.println("Try again: ");
        } while (validator.parcelWeightValid(checking));
        return Double.parseDouble(checking);
    }

    public String takeName() {
        System.out.println("type name:");
        String checking;
        do {
            checking = input.nextLine();
            if (validator.nameValid(checking))
                System.out.println("Try again: ");
        } while (validator.nameValid(checking));
        return checking;
    }


    public Size takeParcelSize() {
        System.out.println("Type parcel size");
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
            if(result ==null)
                System.out.println("Try again");
        } while (result == null);
        return result;
    }
    public State takeParcelState() {
        System.out.println("Type parcel state");
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
            if(result ==null)
                System.out.println("Try again");
        } while (result == null);
        return result;
    }
}
