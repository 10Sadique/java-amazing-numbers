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
        boolean gapful = false;
        boolean spy = false;


        /* Taking Input */
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();

        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;\n");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();

        for (int i = 0; ; i++) {
            System.out.print("Enter a request: ");
            String[] ip = sc.nextLine().split(" ");
            System.out.println();

            // extracting inputs
            long n;
            long m = 1;
            String p = null;
            
            n = Long.parseLong(ip[0]);
            if (ip.length > 1) {
                m = Long.parseLong(ip[1]);
            }

            if(ip.length > 2) {
                m = Long.parseLong(ip[1]);
                p = ip[2].toLowerCase();
            }


            // exit condition check
            if(n == 0) {
                System.out.println();
                System.out.println("Goodbye!");
                break;
            }

            if (n < 1) { // natural number check
                System.out.println("The first parameter should be a natural number or zero.\n");
            } else if (m <= 0) {
                System.out.println("The second parameter should be a natural number.\n");
            } else if (p != null && !(p.equals("even") || p.equals("odd") || p.equals("buzz") || p.equals("duck") || p.equals("palindromic") || p.equals("gapful") || p.equals("spy"))) {
                System.out.println("The property [" + p.toUpperCase() + "] is wrong.");
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
            } else {
                if (ip.length == 1) {
                    if (isEven(n)) {
                        even = true;
                        odd = false;
                    } else {
                        even = false;
                        odd = true;
                    }

                    /* buzz number */
                    if (isBuzz(n)) {
                        buzz = true;
                    }

                    /* duck number */
                    if (isDuck(n)) {
                        duck = true;
                    }

                    /* palindromic number */
                    if(isPalindromic(n)) {
                        palindromic = true;
                    }

                    /* Gapful numbers */
                    if(isGapful(n)) {
                        gapful = true;
                    }

                    /* Syp number */
                    if(isSpy(n)) {
                        spy = true;
                    } else spy = false;

                    /* Output */
                    System.out.println("Properties of "+ n);
                    System.out.println("        buzz: " + buzz);
                    System.out.println("        duck: " + duck);
                    System.out.println(" palindromic: " + palindromic);
                    System.out.println("      gapful: " + gapful);
                    System.out.println("         spy: " + spy);
                    System.out.println("        even: " + even);
                    System.out.println("         odd: " + odd);
                    System.out.println();

                    even = false;
                    odd = false;
                    buzz = false;
                    duck = false;
                    palindromic = false;
                    
                } else if (ip.length == 2) {
                    while (m > 0) {
                        StringJoiner sj = new StringJoiner(", ");
                        System.out.print(n + " is ");

                        if (isBuzz(n)) {
                            sj.add("buzz");
                        }

                        if (isDuck(n)) {
                            sj.add("duck");
                        }

                        if (isPalindromic(n)) {
                            sj.add("palindromic");
                        }

                        if (isGapful(n)) {
                            sj.add("gapful");
                        }

                        if (isSpy(n)) {
                            sj.add("spy");
                        }

                        if (isEven(n)) {
                            sj.add("even");
                        } else {
                            sj.add("odd");
                        }

                        System.out.println(sj);
                        n++;
                        m--;
                    }
                } else if (ip.length == 3){
                    while (m > 0) {
                        StringJoiner sj = new StringJoiner(", ");

                        switch (p) {
                            case "spy" -> {
                                if (isSpy(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("spy");
                                    if (isEven(n)) {
                                        sj.add("even");
                                    } else {
                                        sj.add("odd");
                                    }
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isDuck(n)) sj.add("duck");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "duck" -> {
                                if (isDuck(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("duck");
                                    if (isEven(n)) {
                                        sj.add("even");
                                    } else {
                                        sj.add("odd");
                                    }
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isSpy(n)) sj.add("spy");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "buzz" -> {
                                if (isBuzz(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("buzz");
                                    if (isEven(n)) {
                                        sj.add("even");
                                    } else {
                                        sj.add("odd");
                                    }
                                    if (isDuck(n)) sj.add("duck");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isSpy(n)) sj.add("spy");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "gapful" -> {
                                if (isGapful(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("gapful");
                                    if (isEven(n)) {
                                        sj.add("even");
                                    } else {
                                        sj.add("odd");
                                    }
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    if (isDuck(n)) sj.add("duck");
                                    if (isSpy(n)) sj.add("spy");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "palindromic" -> {
                                if (isPalindromic(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("palindromic");
                                    if (isEven(n)) {
                                        sj.add("even");
                                    } else {
                                        sj.add("odd");
                                    }
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isDuck(n)) sj.add("duck");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isSpy(n)) sj.add("spy");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "even" -> {
                                if (isEven(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("even");
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isDuck(n)) sj.add("duck");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isSpy(n)) sj.add("spy");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                            case "odd" -> {
                                if (!isEven(n)) {
                                    System.out.print(n + " is ");
                                    sj.add("odd");
                                    if (isBuzz(n)) sj.add("buzz");
                                    if (isDuck(n)) sj.add("duck");
                                    if (isGapful(n)) sj.add("gapful");
                                    if (isSpy(n)) sj.add("spy");
                                    if (isPalindromic(n)) sj.add("palindromic");
                                    m--;
                                    System.out.println(sj);
                                }
                            }
                        }
                        n++;
                    }
                }


            }
        }
    }

    public static boolean isEven (long n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBuzz (long n) {
        String buzzStr = n + "";
        long a = Long.parseLong(buzzStr);
        if (a % 7 == 0 && a % 10 == 7 || a % 7 == 0 || a % 10 == 7) {
            return true;
        } else return false;
    }

    public static boolean isDuck (long n) {
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
            return true;
        } else return false;
    }

    public static boolean isPalindromic (long n) {
        long original = n;
        long reversed = 0;

        while (n != 0) {
            long digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return original == reversed;
    }

    public static boolean isGapful (long n) {
        if(n < 100) {
            return false;
        }

        String gapStr = Long.toString(n);
        long first = Character.getNumericValue(gapStr.charAt(0));
        long last = Character.getNumericValue(gapStr.charAt(gapStr.length() - 1));
        long divisor = Long.parseLong(Long.toString(first) + Long.toString(last));

        return n % divisor == 0;
    }

    public static boolean isSpy (long n) {
        long sum = 0;
        long product = 1;

        while (n != 0) {
            long digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return sum == product;
    }
}
