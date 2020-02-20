package Class_4;

import java.util.Scanner;

public class WordCounter
{
    public static void main(String[] args)
    {
        String input;  // To hold keyboard input
        String output; // To hold the output
        Scanner keyboard = new Scanner(System.in);
        // Get input from the user.
        System.out.print("Please input a string: ");
        input = keyboard.nextLine();

        // Format the output.
        output = String.format("That string has %d word(s) in it.",
                wordCount(input));

        // Display the output.
        System.out.println(output);

    }

    /**
     The wordCount method counts the number of words in
     a string.
     @param str The string to count.
     @return The number of words.
     */

    public static int wordCount(String str)
    {
        
        String[] s = str.split(" ");
        return s.length;
    }

}