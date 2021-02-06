package Recursion.PrintTypes;

import java.util.Scanner;

public class printKeypad {
    static String[] keys = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "");
        scn.close();

    }

    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        String kstr = keys[ch - '0'];


        for (int i = 0; i < kstr.length(); i++) {
            printKPC(ros, ans + kstr.charAt(i));
        }




    }

    
}
