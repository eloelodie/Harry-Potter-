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
                System.out.println("Choix inconnu, merci d'entrer l'une des propositions");
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

        } while (!askYesNo("Êtes-vous sûr de votre choix ? (y ou n)\n-->") || !askForConfirmation);

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
                if (input.toLowerCase().equals("y") || input.toLowerCase().equals("o")) {
                    yn = true;
                    break;
                } else if (input.toLowerCase().equals("n")) {
                    yn = false;
                    break;
                } else {
                    throw new Exception("");
                }
            } catch (Exception e) {
                System.out.println("Réponse inconnue");
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
        System.out.println("\nEntrer n'importe quoi pour continuer...");
        sc.next();
    }
}