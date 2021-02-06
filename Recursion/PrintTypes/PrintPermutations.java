package Recursion.PrintTypes;

import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        printPermutations(str,"");
    }

    public static void printPermutations(String str, String psf) {
        if(str.length() == 0){
            System.out.println(psf);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            printPermutations(ros,psf+ch);
        }

    }
}
