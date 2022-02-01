package logisticManagementSystem.ui;

import logisticManagementSystem.FormatValidator;
import logisticManagementSystem.InputHandler;
import logisticManagementSystem.LogisticManager;

import java.util.Scanner;


public class UserInterface {
    public static void main(String[] args) {
        LogisticManager manager = new LogisticManager();
        InputHandler input = new InputHandler(new Scanner(System.in));
        FormatValidator validator = new FormatValidator();
    }
}
