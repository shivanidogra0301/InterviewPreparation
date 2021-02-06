package Recursion.PrintTypes;

import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        if (n < 0) {
            return;
        }
        printStairPaths(n - 1, ans + 1);
        printStairPaths(n - 2, ans + 2);
        printStairPaths(n - 3, ans + 3);
    }

}
