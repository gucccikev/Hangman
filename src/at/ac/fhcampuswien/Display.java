package at.ac.fhcampuswien;

public class Display {

    //printet in Folge: die Unterstriche; falls man falsche Buchstabe/n eingibt zuerst die wrongGuesses; dann auch die hangmanImage; am Ende wird nochmal für einen Großbuchstaben gefragt
    public static void mainDisplay(char[] guessingTemplate, char[] wrongGuesses, int counter){
        System.out.println(guessingTemplate);
        System.out.println(wrongGuesses);
        hangmanImage(counter);
        System.out.println("┍————-——-————-——ฅ^•ﻌ•^ฅ——-————-—————-┑");
        System.out.println("     Gib einen Großbuchstaben ein!");
        System.out.println("┕————————-—————-————-------———-————-—┙");
    }

    //ist die hangmanImage, die immer bei flaschen Eingaben schrittweise ausgeprinted wird
    public static void hangmanImage(int counter) {
        if (counter == 1) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (counter == 2) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
            System.out.println();
        }
        if (counter == 3) {
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
            System.out.println();
        }
        if (counter == 4) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        | x x |");
            System.out.println("   |         \\_⌒_/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
            System.out.println();
        }
        if (counter == 5) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        | x x |");
            System.out.println("   |         \\_⌒_/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
            System.out.println();
        }
        if (counter == 6) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        | x x |");
            System.out.println("   |         \\_⌒_/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

    }

    //wird ausgeprinted wenn man verliert bzw. wenn die ANzahl der Versuche 0 erreicht
    public static void youLostHangmanImage(int counter){
        if (counter == 7) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        | x x |");
            System.out.println("   |         \\_⌒_/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println();
        }
    }
}
