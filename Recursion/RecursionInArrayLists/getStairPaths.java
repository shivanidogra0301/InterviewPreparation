package Recursion.RecursionInArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class getStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(GetStairPaths(n));
        scn.close();
    }

    public static ArrayList < String > GetStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > bs = new ArrayList < > ();
            bs.add("");
            return bs;
        }
        if (n < 0) {
            ArrayList < String > bs = new ArrayList < > ();

            return bs;
        }
        ArrayList < String > myresult = new ArrayList < > ();
        for (int i = 1; i <= 3; i++) {
            ArrayList < String > rres = GetStairPaths(n - i);
            for (String rstr: rres) {
                myresult.add(i + rstr);
            }
        }
        return myresult;
    }
}
