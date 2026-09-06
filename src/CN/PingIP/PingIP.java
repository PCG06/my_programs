/*
CN Program 7:
    Java socket program to input IP address of a URL and ping it
*/

package CN.PingIP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingIP {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter IP address: ");
            String ip = sc.nextLine();

            Runtime rt = Runtime.getRuntime();
            int wait = rt.exec("ping -c 1 " + ip).waitFor(); // Windows `ping -n 1 <ip>`

            if (wait == 0) {
                System.out.println("IP is reachable.");

                try {
                    Process proc = rt.exec("traceroute " + ip); // Windows `tracert <ip>`
                    InputStreamReader is = new InputStreamReader(proc.getInputStream());
                    BufferedReader in = new BufferedReader(is);

                    String line;
                    while ((line = in.readLine()) != null)
                        System.out.println(line);
                    

                    in.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            } else {
                System.out.println("IP is not reachable.");
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
