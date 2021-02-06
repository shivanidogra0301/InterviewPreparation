package Recursion.PrintTypes;

import java.util.Scanner;

public class printSS {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        printSub(str, "");
    }

    public static void printSub(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSub(ros, ans + ch);
        printSub(ros, ans);
    }

}
