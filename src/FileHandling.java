/*
Program 18:
    Create a menu based program to write to, read from and append to a file.
    Use FileWriter and FileReader from java.io.
*/

import java.io.*;
import java.util.Scanner;

public class FileHandling
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String filename = "sample.txt";

        System.out.println("Choose an option");
        System.out.println("1. Write to file (overwrite)");
        System.out.println("2. Read from file");
        System.out.println("3. Append to file");

        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch)
        {
            case 1: // Overwrite
                FileWriter w = new FileWriter(filename);
                w.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n");
                w.write("Maecenas quis mi nisl.\n");
                w.write("In hac habitasse platea dictumst.\n");
                w.write("Quisque facilisis diam vitae lectus bibendum, id iaculis turpis ornare.");
                w.close();
                System.out.println("Successfully written to " + filename);
                break;

            case 2: // Read
                FileReader r = new FileReader(filename);
                BufferedReader br = new BufferedReader(r);
                String line;
                System.out.println("Reading from " + filename + ":\n");
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();
                r.close();
                break;

            case 3: // Append
                FileWriter a = new FileWriter(filename, true); // append = true
                System.out.print("Enter text to append: ");
                String textToAppend = sc.nextLine(); // Praesent ut rhoncus. 
                a.write("\n" + textToAppend);
                a.close();
                System.out.println("Successfully appended to " + filename);
                break;

            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}