package Recursion.RecursionInArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSS {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
        scn.close();
    }

    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            ArrayList < String > bs = new ArrayList < > ();
            bs.add("");
            return bs;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList < String > recresult = gss(ros);
        ArrayList < String > myresult = new ArrayList < > ();

        for (int i = 0; i < recresult.size(); i++) {
            myresult.add(recresult.get(i));

        }
        for (int i = 0; i < recresult.size(); i++) {
            myresult.add(ch + recresult.get(i));
        }

        return myresult;

    }
    
}
