package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //hier kann man die Anzahl der Versuche einfach ändern
        int tries = 7;

        //sind Objekte um von den anderen Klassen implementieren zu können
        FillIn getFunction = new FillIn();
        Display getDisplay = new Display();
        Difficulty getSolution = new Difficulty();

        //von der Klasse Difficulty werden die drei Methoden (easyWords, normalWords, & hardWords) übernommen
        String[] easyEasy = getSolution.easyWords();
        String[] normalNormal = getSolution.normalWords();
        String[] hardHard = getSolution.hardWords();

        //die Methode fürs Aussuchen des Schwierigkeitsgrades wird ausgeführt
        String solution = getSolution.chooseDifficulty(easyEasy, normalNormal, hardHard);

        //die einzelnen Buchstaben des Lösungswortes wird als char gespeichert damit man sie einzelnd printen kann (zb ____ = __T_ = E_TE = ENTE)
        char[] solutionWord = new char[solution.length()];
        getFunction.fillSolutionWord(solution, solutionWord);
        char[] guessingTemplate = new char[solution.length()];
        getFunction.fillGuessingTemplate(solution, guessingTemplate);
        char[] wrongGuesses = new char[tries];
        //bei den Zeilen 28 & 30 wird die Funktionalitäten der Methoden in der Klasse FillIn aufgerufen


        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        //wird kurz die Regeln und ANzahl der Versuche ausgeprinted
        System.out.println();
        System.out.println("┍————-————-————-————-————-————- /ᐠ｡ꞈ｡ᐟ\\ ————-————-————-————-————-————-┑");
        System.out.println("                           Das Spiel startet.                          ");
        System.out.println("                          Du hast " + tries + " Versuche."                    );
        System.out.println(" Umlaute werden mit einem E nach dem entsprechenden Vokal dargestellt!");
        System.out.println("┕————————-————-————-————-————-(..)(..) ∫∫————-————-————-———————-————-┙");
        System.out.println();


        //solange die Anzahl der Versuche kleiner als tries ist, printe mir die Unterstriche und bei falsche Eingaben auch die wrongGuesses
        while (counter < tries) {
            getDisplay.mainDisplay(guessingTemplate, wrongGuesses, counter);

            //Usereingabe wird ins controlGuessString eingespeichert und wird dann überprüft ob es nur ein Großbuchstabe ist und in dem Lösungswort enthalten ist
            char guess = scanner.next().charAt(0);
            String controlGuessString = String.valueOf(guess);
            if (controlGuessString.matches("[A-Z]{1}") && controlGuessString.matches("[" + solution + "]")) {
                //System.out.println("DEBUG :: Richtiger Buchstabe enthalten!\n");
                int fails = tries - counter;
                System.out.println("Du hast " + fails + " Versuch/e übrig!");

                //wird vor der neuen Abfrage des neuen Großbuchstaben, die Unterstriche durch die korrekten Eingaben ersetzt
                getFunction.fillInCorrectGuesses(guess, solution, solutionWord, guessingTemplate);


            //Usereingabe wird überprüft ob es nur ein Großbuchstabe ist und in dem Lösungswort NICHT enthalten ist
            } else if (controlGuessString.matches("[A-Z]{1}") && !controlGuessString.matches("[" + solution + "]")) {
                //System.out.println("DEBUG :: Buchstabe nicht enthalten!\n");

                //wird vor der neuen Abfrage des neuen Großbuchstaben, die falsche Eingabe printet und die Anzahl der Versuche um 1 reduziert aber counter erhöht
                getFunction.fillInFalseGuesses(guess, wrongGuesses, counter);
                counter++;
                int fails = tries - counter;
                System.out.println();
                System.out.println("Du hast " + fails + " Versuch/e übrig!");
            } else {
                //System.out.println("DEBUG :: Falsches Eingabeformat!");
                continue;
            }

            //wenn die guesses gleich dem Lösungswort ist
            if (Arrays.equals(guessingTemplate, solutionWord)) {
                System.out.println();
                System.out.println("Gratulation, du hast gewonnen!");
                System.out.println("Das Lösungswort ist: " + solution);
                break;
            }

            //wenn Counter die Anzahl der Versuche erreicht, werden die folgenden Sachen ausgeprinted
            if (counter == tries) {
                getDisplay.youLostHangmanImage(counter);
                System.out.println();
                System.out.println("Du hast Verloren\n");
                System.out.println("Das Lösungswort war: " + solution);
                System.out.println("┻━━┻︵ヽ(`Д´)ﾉ︵ ┻━━┻");
            }
        }

    }


}

