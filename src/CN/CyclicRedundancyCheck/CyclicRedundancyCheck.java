/*
CN Program 4:
    Java socket program to input data and generator
    to perform cyclic redundancy check (CRC) and verify the output.
*/

package CN.CyclicRedundancyCheck;

import java.util.Scanner;

public class CyclicRedundancyCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        String data = sc.nextLine();
        
        System.out.print("Enter generator: ");
        String gen = sc.nextLine();

        String code = gen;

        while (code.length() < (data.length() + gen.length() - 1))
            code += "0";

        code = data + div(code, gen);

        System.out.println();
        System.out.println("Transmitted code: " + code);
        System.out.println();

        System.out.print("Enter received code: ");
        String rec = sc.nextLine();

        System.out.println();
        if (Integer.parseInt(div(rec, gen)) == 0)
            System.out.println("Received code has no errors.");
        else
            System.out.println("Received code has errrors.");

        sc.close();
    }

    public static String div(String data, String gen) {
        int pointer = gen.length();
        String result = data.substring(0, pointer);
        String remainder = "";

        for (int i = 0; i < gen.length(); i++) {
            if (result.charAt(i) == gen.charAt(i))
                remainder += "0";
            else
                remainder += "1";
        }

        while (pointer < data.length()) {
            if (remainder.charAt(0) == '0') {
                remainder = remainder.substring(1, remainder.length());
                remainder += String.valueOf(data.charAt(pointer));
                pointer++;
            }

            result = remainder;
            remainder = "";

            for (int i = 0; i < gen.length(); i++) {
                if (result.charAt(i) == gen.charAt(i))
                    remainder += "0";
                else
                    remainder += "1";
            }
        }
        return remainder.substring(1, remainder.length());
    }
}
