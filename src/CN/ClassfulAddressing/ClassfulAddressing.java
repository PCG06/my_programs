/*
CN Program 5:
    Java socket program to input IP address and print the following:
    Class, Network ID, Host ID, Subnet Mask.
*/

package CN.ClassfulAddressing;

import java.util.Scanner;

public class ClassfulAddressing {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP address (XXX.XXX.XXX.XXX): ");
        String ip = sc.nextLine();

        sc.close();

        String[] octets = ip.split("\\.");

        if (octets.length != 4) {
            System.out.println("Invalid IP address!");
            return;
        }

        int firstOct = Integer.parseInt(octets[0]);

        System.out.println("---IP details---");
        if (firstOct >= 1 && firstOct <= 223) {
            printClassDetails(firstOct, octets);
        } else if (firstOct >= 224 && firstOct <= 239) {
            System.out.println("Class D: Multicasting");
        } else if (firstOct >= 240 && firstOct <= 255) {
            System.out.println("Class E: Reserved");
        } else {
            System.out.println("Invalid IP address");
        }
    }

    public static void printClassDetails(int firstOct, String[] octets) {
        String clas;
        String networkId;
        String hostId;
        String subnetMask;

        if (firstOct <= 126) {
            clas = "A";
            networkId = octets[0];
            hostId = octets[1] + "." + octets[2] + "." + octets[3];
            subnetMask = "255.0.0.0";
        }
        else if (firstOct <= 191) {
            clas = "D";
            networkId = octets[0] + "." + octets[1];
            hostId = octets[2] + "." + octets[3];
            subnetMask = "255.255.0.0";
        } else {
            clas = "C";
            networkId = octets[0] + "." + octets[1] + "." + octets[2];
            hostId = octets[3];
            subnetMask = "255.255.255.0";
        }

        System.out.println("Class " + clas);
        System.out.println("Network ID " + networkId);
        System.out.println("Host ID " + hostId);
        System.out.println("Subnet Mask " + subnetMask);
    }
}
