package at.ac.fhcampuswien;

public class FillIn extends Display{

    public static char[] fillSolutionWord(String solution, char[] solutionWord){
        for(int i = 0; i < solution.length(); i++){
            solutionWord[i] = solution.charAt(i);
        }
        return solutionWord;
    }

    public static char[] fillGuessingTemplate(String solution, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++) {
            guessingTemplate[i] = '_';
        }
        return guessingTemplate;
    }

    public static char[] fillInCorrectGuesses(char guess, String solution, char[] solutionWord, char[] guessingTemplate){
        for (int i = 0; i < solution.length(); i++){
            if (guess == solutionWord[i])
                guessingTemplate[i] = guess;
        }
        return guessingTemplate;
    }

    public static char[] fillInFalseGuesses(char guess, char[] wrongGuesses, int wrongGuessCounter){
        wrongGuesses[wrongGuessCounter] = guess;
        return wrongGuesses;
    }
}
