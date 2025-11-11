import java.util.Scanner;

public class SafeInput {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (console.hasNextInt()) {
                result = console.nextInt();
                if (result >= low && result <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Enter between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                console.next(); // clear invalid token
            }
        } while (!valid);
        return result;
    }
    public static boolean getYNConfirm(Scanner console, String prompt) {
    String response;
    while (true) {
        System.out.print(prompt);
        response = console.next().trim().toUpperCase();
        if (response.equals("Y"))
            return true;
        else if (response.equals("N"))
            return false;
        else
            System.out.println("Please enter Y or N.");
    }
  }
}