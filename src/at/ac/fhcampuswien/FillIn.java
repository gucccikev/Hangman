package at.ac.fhcampuswien;

public class FillIn {


    //befüllt den solutionWord char Array mit dem Lösungswort
    public static char[] fillSolutionWord(String solution, char[] solutionWord){
        for(int i = 0; i < solution.length(); i++){
            solutionWord[i] = solution.charAt(i);
        }
        return solutionWord;
    }


    //befüllt das guessingTemplate char Array mit Unterstrichen entsprechend der Buchstabenanzahl des Lösungswortes
    public static char[] fillGuessingTemplate(String solution, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++) {
            guessingTemplate[i] = '_';
        }
        return guessingTemplate;
    }


    //überprüft ob der eingegebene Buchstabe im Lösungswort enthalten ist, wenn ja dann werden die entsprechenden Unterstriche im guessingTemplate char Array durch diesen Buchstaben ersetzt
    public static char[] fillInCorrectGuesses(char guess, String solution, char[] solutionWord, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++){
            if (guess == solutionWord[i])
                guessingTemplate[i] = guess;
        }
        return guessingTemplate;
    }


    //befüllt das wrongGuesses char Array mit den falsch eingegebenen Buchstaben
    public static char[] fillInFalseGuesses(char guess, char[] wrongGuesses, int counter){
        wrongGuesses[counter] = guess;
        return wrongGuesses;
    }
}
