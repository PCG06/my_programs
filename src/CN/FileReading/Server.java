/*
CN Program 3:
    Java socket to send file name from client to server,
    and receive file contents if it is present.
*/

package CN.FileReading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server is starting...");
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server is waiting for client connection.");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected!");

                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                OutputStreamWriter osr = new OutputStreamWriter(client.getOutputStream());
                BufferedReader in = new BufferedReader(isr);
                PrintWriter out = new PrintWriter(osr, true);
                
                String filename = in.readLine();
                System.out.println("Client requested file: " + filename);
                String line = null;

                File file = new File(filename);
                if (file.exists()) {
                    BufferedReader fileReader = new BufferedReader(new FileReader(file));

                    System.out.println("Sending data to client...");

                    while ((line = fileReader.readLine()) != null)
                        out.println(line);

                    System.out.println("Data sent!");

                    fileReader.close();
                    System.out.println();
                } else {
                    out.println("File does not exist!");
                }

                out.close();
                in.close();
                osr.close();
                isr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
