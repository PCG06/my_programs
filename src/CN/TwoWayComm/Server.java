/*
CN Program 2:
    Java socket program to perform bidirectional communication between client and server.
    Client and server can send data to each other.
*/

package CN.TwoWayComm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server is starting...");
        try (ServerSocket server = new ServerSocket(9998)) {
            System.out.println("Server is waiting for client connection.");

            Socket client = server.accept();
            System.out.println("Client connected!");

            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(isr);
            PrintWriter out = new PrintWriter(osw, true);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println();
                String clientMsg = in.readLine();

                if (clientMsg == null) {
                    System.out.println("Client interrupted.");
                    break;
                }

                System.out.println("Client message: " + clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client ended the communication.");
                    break;
                }

                System.out.print("Enter server response: ");
                String serverResp = sc.nextLine();

                out.println(serverResp);
            }

            sc.close();
            out.close();
            in.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Server not connected!");
            e.printStackTrace();
        }
    }
}
