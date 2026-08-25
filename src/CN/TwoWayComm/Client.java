/*
CN Program 2:
    Java socket program to perform bidirectional communcation between client and server.
    Client and server can send data to each other.
*/

package CN.TwoWayComm;

import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try (Socket client = new Socket("localhost", 9998)) {
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            OutputStreamWriter osr = new OutputStreamWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(isr);
            PrintWriter out = new PrintWriter(osr, true);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Enter client message: ");
                String clientMsg = sc.nextLine();

                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println();
                    System.out.println("Ending connection...");
                    break;
                }

                String serverResp = in.readLine();
                System.out.println("Server response: " + serverResp);
                System.out.println();
            }

            sc.close();
            out.close();
            in.close();
            osr.close();
            isr.close();
        } catch (IOException e) {
            System.out.println("Client not connected!");
            e.printStackTrace();
        }
    }
}

