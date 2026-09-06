/*
CN Program 1:
    Java socket program to perform unidirectional communication between client and server.
    Client sends data to server.
*/

package CN.OneWayComm;

import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("localhost", 9998)) {
            OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
            PrintWriter out = new PrintWriter(osw, true);

            System.out.println("Sending data to server...");
            out.println("Name: PCG");
            out.println("Course: BCA");
            out.println("Country: India");

            System.out.println("Data sent!");

            out.close();
        } catch (Exception e) {
            System.out.println("Client not connected!");
            e.printStackTrace();
        }
    }
}
