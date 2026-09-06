/*
CN Program 1:
    Java socket program to perform unidirectional communication between client and server.
    Client sends data to server.
*/

package CN.OneWayComm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server is starting...");
        try (ServerSocket server = new ServerSocket(9998)) {
            System.out.println("Server is waiting for client connection.");

            Socket client = server.accept();
            System.out.println("Client connected!");

            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader in = new BufferedReader(isr);

            System.out.println();
            System.out.println("Waiting for data from client...");
            System.out.println();

            String str;
            while ((str = in.readLine()) != null)
                System.out.println(str);
            System.out.println();

            System.out.println("Data received!");

            in.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Server not connected!");
            e.printStackTrace();
        }
    }
}
