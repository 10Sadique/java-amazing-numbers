package numbers;

import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        boolean even = false;
        boolean odd = false;
        boolean buzz = false;
        boolean duck = false;
        boolean palindromic = false;


        /* Taking Input */
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();

        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println();

        for (int i = 0; ; i++) {
            System.out.print("Enter a request: ");
            long n = sc.nextLong();
            System.out.println();

            // exit condition check
            if(n == 0) {
                System.out.println();
                System.out.println("Goodbye!");
                break;
            }

            if(n < 1) { // natural number check
                System.out.println("The first parameter should be a natural number or zero.\n");
            } else {
                if (n % 2 == 0) {
                    even = true;
                    odd = false;
                } else {
                    even = false;
                    odd = true;
                }

                /* buzz number */
                String buzzStr = n + "";
                long a = Long.parseLong(buzzStr);
                if (a % 7 == 0 && a % 10 == 7 || a % 7 == 0 || a % 10 == 7) {
                    buzz = true;
                }

                /* duck number */
                String duckStr = n + "";
                int count = 0;
                boolean startWith0 = false;
                for (int j = 0; j < duckStr.length(); j++) {
                    if(duckStr.charAt(0) == '0') {
                        startWith0 = true;
                    }
                    if(duckStr.charAt(j) == '0') {
                        count++;
                    }
                }

                if (startWith0 && count>1 || count>=1) {
                    duck = true;
                }

                /* palindromic number */
                String palStr = n + "";
                String palOp = "";
                for (int k = palStr.length() - 1; k >= 0; k--) {
                    palOp += palStr.charAt(k);
                }

                if(Long.parseLong(palStr) == Long.parseLong(palOp)) {
                    palindromic = true;
                }

                /* Output */
                System.out.println("Properties of "+ n);
                System.out.println("        even: " + even);
                System.out.println("         odd: " + odd);
                System.out.println("        buzz: " + buzz);
                System.out.println("        duck: " + duck);
                System.out.println(" palindromic: " + palindromic);
                System.out.println();

                even = false;
                odd = false;
                buzz = false;
                duck = false;
                palindromic = false;
            }
        }


    }
}
