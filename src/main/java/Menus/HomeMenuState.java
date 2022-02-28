package Menus;

public class HomeMenuState extends State {


    @Override
    public State start() {
        display("=====================");
        display("1. Login");
        display("2.Quit");
        String option = read();
        while (!option.equals("1") && !option.equals("2")) {
            option = read();
        }
        if (option.equals("1")) {
            return MenuData.loginMenuState.start();
        }
        return MenuData.exitMenuState.start();
    }
}
