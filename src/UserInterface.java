import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("");
        System.out.println("Enter command:");
        System.out.println("1) Show your task list");
        System.out.println("2) add task");
        System.out.println("3) mark as done");
        System.out.println("4) remove task");
        System.out.println("x) quit");
    }

    public String readInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int promptNumeric(String message) {
        System.out.println(message);
        int numberInput = 0;
        boolean isNumberValid = false;
        while (!isNumberValid) {
            String input = scanner.nextLine();
            try {
                numberInput = Integer.parseInt(input);
                isNumberValid= true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        return numberInput;
    }

}
