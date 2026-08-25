/*
CN Program 3:
    Java socket to send file name from client to server,
    and receive file contents if it is present.
*/

package CN.FileReading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try (Socket client = new Socket("localhost", 12345)) {
                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                OutputStreamWriter osr = new OutputStreamWriter(client.getOutputStream());
                BufferedReader in = new BufferedReader(isr);
                PrintWriter out = new PrintWriter(osr, true);
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter file name: ");
                String filename = sc.nextLine();

                out.println(filename);

                String line;
                System.out.println();
                System.out.println("File data:");
                while ((line = in.readLine()) != null)
                    System.out.println(line);

                sc.close();
                out.close();
                in.close();
                osr.close();
                isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
