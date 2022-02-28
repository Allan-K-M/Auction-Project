package Menus;

public class ExitMenuState extends State{
    @Override
    public State start() {
        display("Good bye");
        return null;
    }
}
