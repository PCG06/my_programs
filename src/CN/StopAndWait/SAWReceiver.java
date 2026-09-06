/*
CN Program 6:
    Java socket program to simulate stop and wait on a noisy channel.
*/

package CN.StopAndWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SAWReceiver {
    public static void main(String[] args) {
        try {
            SAWReceiver receiver = new SAWReceiver();
            receiver.run();
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
    }

    public void run() throws IOException {
        try (ServerSocket receiver = new ServerSocket(9999)) {
            String tmp = "any";
            String str = "exit";

            Socket sender = receiver.accept();

            InputStreamReader isr = new InputStreamReader(sender.getInputStream());
            OutputStream os = sender.getOutputStream();
            BufferedReader in = new BufferedReader(isr);
            PrintStream out = new PrintStream(os);

            while (!tmp.equals(str)) {
                Thread.sleep(1000);
                tmp = in.readLine();

                if (tmp.equals(str))
                    break;

                System.out.println("Frame " + tmp + " was received.");
                Thread.sleep(500);
                out.println("Received.");
            }

            System.out.println("All frames were received successfully.");

            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println("Receiver failed to connect.");
            e.printStackTrace();
        }
    }
}
