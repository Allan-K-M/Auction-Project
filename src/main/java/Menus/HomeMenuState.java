package Menus;

import java.util.Locale;
import java.util.Scanner;

public class HomeMenuState implements MenuStateInterface {

    public HomeMenuState() {
        System.out.println("===========================");
        System.out.println("1.Login (1)");
        System.out.println("2.Quit (Q)");
        System.out.println("===========================");
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Enter your option: ");
        String input=keyboard.nextLine();
        //var inputOptions= new Options();
        input.toUpperCase(Locale.ROOT);


        if(!input.equals("1")&&!input.equals("Q")){
            System.out.println("Enter a valid option!");
            new HomeMenuState();
        }

       // while (input.equals("2"))
    }

    @Override
    public void login() {

    }

    @Override
    public void quit() {

    }

    @Override
    public void manageUsers() {

    }

    @Override
    public void manageAuctions() {

    }

    @Override
    public void goBack() {

    }
}
