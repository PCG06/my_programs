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
import java.net.Socket;
import java.util.Scanner;

public class SAWSender {
    public static void main(String[] args) {
        try {
            SAWSender sender = new SAWSender();
            sender.run();
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }
    }

    public void run() throws IOException {
        try (Socket sender = new Socket("localhost", 9999)) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter no. of frames to be sent: ");
            int n = sc.nextInt();

            InputStreamReader isr = new InputStreamReader(sender.getInputStream());
            OutputStream os = sender.getOutputStream();
            BufferedReader in = new BufferedReader(isr);
            PrintStream out = new PrintStream(os);

            int i = 0;
            while (i <= n) {
                if (i == n) {
                    out.println("exit");
                    break;
                }

                out.println(i);
                System.out.println("Frame no " + i + " sent.");
                
                String ack = in.readLine();

                if (ack != null) {
                    System.out.println("Received acknowledgement from receiver.");
                    i++;
                    Thread.sleep(1000);
                } else {
                    out.println(i);
                }
            }

            in.close();
            out.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Sender failed to connect.");
            e.printStackTrace();
        }
    }
}
