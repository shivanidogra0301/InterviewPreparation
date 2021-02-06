package Recursion.RecursionInArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class Keypad {
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

        System.out.println(getKPC(str));
        scn.close();
    }

    public static ArrayList < String > getKPC(String str) {
        if (str.length() == 0) {
            ArrayList < String > bs = new ArrayList < > ();
            bs.add("");
            return bs;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList < String > recres = getKPC(ros);
        ArrayList < String > myres = new ArrayList < > ();
        String kstr = keys[ch - '0'];
        for (int i = 0; i < kstr.length(); i++) {
            for (String rstr: recres) {
                myres.add(kstr.charAt(i) + rstr);
            }
        }
        return myres;
    }
}
