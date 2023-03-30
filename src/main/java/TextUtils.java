import java.util.Scanner;

public class TextUtils {

    static Scanner sc = new Scanner(System.in);

    // print console
    public void printConsole(String prompt) {
        System.out.println(prompt);
    }

    // user input from console
    public int askInt(String prompt, int Choices) {
        int input;

        do {
            System.out.print(prompt);

            try {
                input = Integer.parseInt(sc.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Unknown choice, please enter one of the proposals");
            }

        } while(input < 1 || input > Choices);

        return input;
    }

    // ask for String
    public String askStr(String prompt, boolean askForConfirmation) {
        String input;

        do {
            System.out.print(prompt);
            input = sc.next();

        } while (!askYesNo("Are you sure of your choice ? (y or n)\n--> ") || !askForConfirmation);

        return input;
    }


    // yes = true ; no = false
    public boolean askYesNo(String prompt) {
        String input;
        boolean yn;

        do {
            System.out.print(prompt);
            input = sc.next();

            try {
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("o")) {
                    yn = true;
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    yn = false;
                    break;
                } else {
                    throw new Exception("");
                }
            } catch (Exception e) {
                System.out.println("Unknown answer");
            }

        } while(true);

        return yn;
    }

    // simuler un clear de la console
    public void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // séparateur de longueur n
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // print un entête
    public void printHeading(String title) {
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    // give time to user to read or anything before continue
    public void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        sc.next();
    }
}
