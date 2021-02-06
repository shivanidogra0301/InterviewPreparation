package Recursion.RecursionIntro;

import java.util.Scanner;
class Print_Dec_Inc{
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
        scn.close();
    }

    public static void printDecreasing(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n) {
        if (n < 1) {
            return;
        }

        printIncreasing(n - 1);
        System.out.println(n);
    }
    public static void pdi(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);

    }
}