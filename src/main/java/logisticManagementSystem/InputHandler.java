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
        System.out.println("type your name: ");
        String checking;
        do {
            checking = input.next();
            if (!validator.lockerNameValid(checking))
                System.out.println("Not good, try again: ");
        } while (!validator.lockerNameValid(checking));
        return checking;
    }

    public String takeMenuChoice() {
        System.out.println("chose what you want: ");
        String checking;
        do {
            checking = input.next();
            if (!validator.menuChoiceValid(checking))
                System.out.println("Pls type number in a 0-9 range");
        } while (!validator.menuChoiceValid(checking));
        return checking;
    }
}
