package password.manager.view;

import password.manager.generators.GeneratorType;
import password.manager.model.PasswordFacade;

import java.util.Scanner;

import static password.manager.view.MenuState.*;

public class Runner {

    private MenuState state = MAIN_MENU;
    private Scanner sc = new Scanner(System.in);
    private PasswordFacade passwordFacade = new PasswordFacade();
    private int choice = -1;
    private String siteName;
    private String login;

    public void run() {
        while (true) {
            printMenuAndGetChoices();
            handleUserChoice();
        }
    }

    private void printMenuAndGetChoices() {

        if (state == MAIN_MENU) {
            System.out.println("----------");
            System.out.println("1. Add entry");
            System.out.println("2. Display entries");
            System.out.println("3. Remove entry");
            System.out.println("----------");
            choice = sc.nextInt();
            sc.nextLine();
            return;
        }
        if (state == GENERATE_PASSWORD) {
            System.out.println("----------");
            System.out.println("Site:");
            siteName = sc.nextLine();
            System.out.println("Login:");
            login = sc.nextLine();
            System.out.println("----------");
            return;
        }
        if (state == REMOVE_ENTRY) {

        }
    }

    private void handleUserChoice() {
        if (state == MAIN_MENU) {
            if (choice == 1) {
                state = GENERATE_PASSWORD;
                return;
            }
            if (choice == 2) {
                state = REMOVE_ENTRY;
                return;
            }
        }
        if (state == GENERATE_PASSWORD) {
            passwordFacade.generatePassword(siteName, login, GeneratorType.UUID, 10);
            state = MAIN_MENU;
            return;
        }
    }
}
