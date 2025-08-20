/*
Java Project: Hangman
    - A small CLI based hangman game with a word for every alphabet.
    - Methods have documentation regarding what they do for easy understanding.

    - Todo:
        * javax.swing.* (Swing) / javafx.* (JavaFX) : Create a UI to show the hangman character.
        * java.net.http: Generate random words (API calls).
*/

import java.util.Scanner;

public class Hangman
{
    static final String[] WORDS =
    {
        "Apple", "Bravo", "Candy", "Delta", "Eagle", "Flame",
        "Grape", "Honey", "Ivory", "Jelly", "Koala", "Lemon",
        "Mango", "Noble", "Ocean", "Pearl", "Queen", "Raven",
        "Sunny", "Tiger", "Umbra", "Vivid", "Whale", "Xenon",
        "Young", "Zebra"
    };

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        mainLoop: while (true)
        {
            System.out.println("\nWelcome to Hangman Java!");
            System.out.println("-----------------");
            System.out.println("1. Play Hangman");
            System.out.println("2. Display all words");
            System.out.println("3. Quit game");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    PlayGame(sc);
                    break;
                case 2:
                    System.out.println("\nAvailable words are:");
                    for (int i = 0; i < WORDS.length; i++)
                    {
                        System.out.print("\"" + WORDS[i] + "\"");

                        if (i < WORDS.length - 1)
                            System.out.print(", ");

                        if ((i + 1) % 6 == 0)
                            System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting game...");
                    break mainLoop; // breaks from switch as well as main loop
                default:
                    System.out.println("Invalid choice. Enter again");
            }
        }
        sc.close();
    }

    static void PlayGame(Scanner sc)
    {
        String word = WORDS[(int) (Math.random() * WORDS.length)];
        char[] guessedWord = InitGuessedWord(word.length());
        int attemptsLeft = 6;

        System.out.println("\nGuess the word!");

        while (attemptsLeft > 0)
        {
            ShowWordAndAttempts(guessedWord, attemptsLeft);

            System.out.print("Enter a character: ");
            char guessedChar = sc.next().toLowerCase().charAt(0);
            boolean isCorrect = UpdateGuessedWord(word, guessedWord, guessedChar);

            if (isCorrect)
            {
                System.out.println("Correct guess!");
            }
            else
            {
                System.out.println("Wrong guess!");
                attemptsLeft--;
            }

            if (IsWordGuessed(guessedWord))
            {
                System.out.println("\nCongratulations! You guessed it!");
                System.out.println("\"" + word + "\"");
                return;
            }
        }

        System.out.println("\nSorry! You are out of attempts!");
        System.out.println("The correct word was \"" + word + "\"!");
    }

    // Initializes word as _____
    static char[] InitGuessedWord(int length)
    {
        char[] arr = new char[length];
        for (int i = 0; i < length; i++)
            arr[i] = '_';
        return arr;
    }

    // Displays word (b_a_o) and attempts left
    static void ShowWordAndAttempts(char[] guessedWord, int attemptsLeft)
    {
        System.out.print("\nWord: ");
        for (char c : guessedWord)
            System.out.print(c + " ");
        System.out.println("\nAttempts left: " + attemptsLeft);
    }

    // Loops through each letter. Returns true if the guessed char is in the word (and not yet checked)
    static boolean UpdateGuessedWord(String word, char[] guessedWord, char guessedChar)
    {
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++)
        {
            if (word.toLowerCase().charAt(i) == guessedChar
                && guessedWord[i] == '_')
            {
                guessedWord[i] = word.charAt(i);
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    // Loops through each letter. If any letter is underscore, the word hasn't been guessed yet
    static boolean IsWordGuessed(char[] guessedWord)
    {
        for (char c : guessedWord)
            if (c == '_')
                return false;
        return true;
    }
}
