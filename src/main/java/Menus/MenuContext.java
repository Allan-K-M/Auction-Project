package Menus;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class MenuContext {

    public static class MenuOption {
        final String title;
        final Consumer<MenuContext> action;
        final boolean leave;
        private Predicate<MenuContext> isDisplayed;

        private MenuOption(String title, Consumer<MenuContext> action, Predicate<MenuContext> isDisplayed) {
            this(title, action, isDisplayed, false);
        }

        private MenuOption(String title, Consumer<MenuContext> action, Predicate<MenuContext> isDisplayed, boolean leave) {
            this.isDisplayed = isDisplayed;
            this.leave = leave;
            this.title = title;
            this.action = action;
        }
    }


    public void display(String wordsToDisplay){
        System.out.println(wordsToDisplay);

    }
    protected String userInput() {
        System.out.println("Enter your Option: ");
        Scanner keyboard=new  Scanner(System.in);
        String input=keyboard.nextLine();
        return input;
    }
    protected String userInput(String prompt) {
        System.out.println(prompt);
        Scanner keyboard=new  Scanner(System.in);
        String input=keyboard.nextLine();
        return input;
    }
}


