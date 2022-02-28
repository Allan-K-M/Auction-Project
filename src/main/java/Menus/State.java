package Menus;

import model.UserManagement;

import java.util.Scanner;

public abstract class State {
    protected final UserManagement ADMIN = new UserManagement();

    public void display(String prompt) {
        System.out.println(prompt);
    }

    public String read() {
        System.out.println("Enter your option: ");
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();
        return option;
    }

    public String read(String prompt) {
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();
        return option;
    }
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();

        return Integer.parseInt(option);
    }
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();
        return Double.parseDouble(option);
    }



    public State start() {
        return new HomeMenuState();
    }
}
