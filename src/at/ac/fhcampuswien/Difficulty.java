package at.ac.fhcampuswien;

import java.util.Scanner;

public class Difficulty {

    //die folgenden drei Methoden (easyWords, normalWords & hardWords) wurden in Methoden unterteilt damit man sie in die Main Klasse returnen kann
    public static String[] easyWords(){
        final String[] easyWords = {"AFFE", "BANANE", "BAUM", "HAUS", "ZAUN", "AUTO", "STEIN", "HASE", "HUND", "KATZE", "VIDEO", "SPIEL", "KISTE", "BALL", "KUGEL", "HAND", "ARM", "BERG", "SCHNEE", "FLASCHE",
                "GLAS", "BIO", "BUCH", "STIFT", "MAPPE", "MAUS", "KABEL", "MASKE", "KURZ", "LOST", "HANDY", "LAPTOP"};
        return easyWords;
    }

    public static String[] normalWords(){
        final String[] normalWords = {"BILDSCHIRM", "TASTATUR", "PANDEMIE", "REGIERUNG", "LOCKDOWN", "COMPUTER", "AUFZEICHUNG", "UNIVERSITAET", "SEMESTER", "PRUEFUNG", "LEBENSMITTEL",
                "BOHRMASCHINE", "STAATSBUERGESCHAFT", "REGIONAL", "KOFFEIN", "BETREUUNG", "PINWAND", "INTERNET", "PROGRAMMIERUNG", "SCHOKOLADE", "NETZWERK", "BETRIEBSSYSTEM", "LINUX", "WINDOWS",
                "DISCORD", "VORLESUNG", "STUNDENPLAN", "MOODLEPRUEFUNG", "SEMIKOLON", "VERKNUEPFUNG"};
        return normalWords;
    }

    public static String[] hardWords(){
        final String[] hardWords = {"HANDGEMENGE", "PAPIERSCHNIPSELCHEN", "WEITSPUCKWETTBEWERB", "MASSENTOURISMUS", "ZYKLOP", "DAMPFSCHIFFFAHRTSGESELLSCHAFTKAPITAENSWITWE", "PORTEMONNAIE",
                "YETI", "KUDDELMUDDEL", "STRACCIATELLA", "DESINFEKTIONSMITTEL", "HIMBEERMARMELADENGLAS", "THANOS", "MAGERMILCHJOGUHRT", "DISQUALIFIKATION", "STEREOTYP", "TRIGONOMETRIE", "RHYTHMUS",
                "TSCHECHOSLOWAKEI", "DESOXYRIBONUKLEINSÄURE", "PAPPERLAPAPP", "MANGELERNAEHRUNG", "QUERSCHLAEGER", "SCHLAGANFALL"};
        return hardWords;
    }

    //fragt den User für den Schwierigkeitsgrad und sucht dazu random ein Lösungswort von der gewählten Stufe aus
    public static String chooseDifficulty(String[] easyWords, String[] normalWords, String[] hardWords) {

        Scanner sc = new Scanner(System.in);
        String solution = "";
        boolean input;

        do {
            System.out.println();
            System.out.println("Wähle die Schwierigkeit aus: 1 für leicht   (-, – )…zzzZZ");
            System.out.println("                             2 für normal   (ㆆ ᴗㆆ)");
            System.out.println("                             3 für schwer   (ノಠ益ಠ) ノ彡 ┻━┻");
            String numOfDifficulty = sc.nextLine();

            switch (numOfDifficulty) {
                case "1":
                    solution = randomWord(easyWords, easyWords.length);
                    input = false;
                    break;

                case "2":
                    solution = randomWord(normalWords, normalWords.length);
                    input = false;
                    break;

                case "3":
                    solution = randomWord(hardWords, hardWords.length);
                    input = false;
                    break;

                default:
                    input = true;
                    continue;
            }
        }while (input) ;
        return solution;
    }

    //sorgt für das zufälliges Aussuchen des Lösungswortes
    private static String randomWord(String[] words, int wordsArrayLength) {
        int min = 0;
        int max = wordsArrayLength - 1;
        int randomNumber = (int) (Math.random() * (max - min + 1) + min);
        return words[randomNumber];
    }
}
