package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tries = 7;

        final String[] wordList = {"BANANE", "MANGELERNAEHRUNG", "QUERSCHLAEGER", "HANDGEMENGE", "SCHLAGANFALL"};
        final String solution = randomWord(wordList, wordList.length);


        char[] solutionWord = new char[solution.length()];
        fillSolutionWord(solution, solutionWord);
        char[] guessingTemplate = new char[solution.length()];
        fillGuessingTemplate(solution, guessingTemplate);
        char[] wrongGuesses = new char[tries];


        //char guess = 'A';

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int wrongGuessCounter = 0;
        System.out.println("Das Spiel startet du hast " + tries + " Versuche");
        System.out.println("Umlaute werden mit einem E nach dem entsprechenden Vokal dargestellt!");

        while (counter < tries) {
            mainDisplay(guessingTemplate, wrongGuesses, counter);
            char guess = scanner.next().charAt(0);
            String controlGuessString = String.valueOf(guess);
            if (controlGuessString.matches("[A-Z]{1}") && controlGuessString.matches("[" + solution + "]")) {
                //System.out.println("DEBUG :: Richtiger Buchstabe enthalten!\n");
                int fails = tries - wrongGuessCounter;
                System.out.println("Du hast " + fails + " Versuch/e übrig!");

                fillInCorrectGuesses(guess, solution, solutionWord, guessingTemplate);


            } else if (controlGuessString.matches("[A-Z]{1}") && !controlGuessString.matches("[" + solution + "]")) {
                //System.out.println("DEBUG :: Buchstabe nicht enthalten!\n");

                fillInFalseGuesses(guess, wrongGuesses, wrongGuessCounter);
                wrongGuessCounter++;
                int fails = tries - wrongGuessCounter;
                System.out.println("Du hast " + fails + " Versuch/e übrig!");
                counter++;
            } else {
                //System.out.println("DEBUG :: Falsches Eingabeformat!");
                continue;
            }
            if (Arrays.equals(guessingTemplate, solutionWord)) {
                System.out.println("Gratulation, du hast gewonnen!\n");
                System.out.println("Das Lösungswort ist: " + solution);
                break;
            }
            if (counter == tries) {
                youLostHangmanImage(counter);
                System.out.println("Du hast Verloren\n");
                System.out.println("Das Lösungswort war: " + solution);
            }
        }

    }


    private static String randomWord(String[] words, int wordsArrayLength) {
        //liefer ein zufÃ¤lliges Wort aus der wordList
        int min = 0;
        int max = wordsArrayLength - 1;
        int randomNumber = (int) (Math.random() * (max - min + 1) + min);
        return words[randomNumber];
    }

    private static char[] fillSolutionWord(String solution, char[] solutionWord){
        for(int i = 0; i < solution.length(); i++){
            solutionWord[i] = solution.charAt(i);
        }
        return solutionWord;
    }

    private static char[] fillGuessingTemplate(String solution, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++) {
            guessingTemplate[i] = '_';
        }
        return guessingTemplate;
    }

    private static char[] fillInCorrectGuesses(char guess, String solution, char[] solutionWord, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++){
            if (guess == solutionWord[i])
                guessingTemplate[i] = guess;
        }
        return guessingTemplate;
    }

    private static char[] fillInFalseGuesses(char guess, char[] wrongGuesses, int wrongGuessCounter){
        wrongGuesses[wrongGuessCounter] = guess;
        return wrongGuesses;
    }

    private static void mainDisplay(char[] guessingTemplate, char[] wrongGuesses, int counter){
        System.out.println(guessingTemplate);
        System.out.println(wrongGuesses);
        hangmanImage(counter);
        System.out.println();
        System.out.println("Gib einen Großbuchstaben ein!");
    }

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
        }
        if (counter == 4) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (counter == 5) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (counter == 6) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (counter == 7) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }
    public static void youLostHangmanImage(int counter){
        if (counter == 7) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }
}

