package BitManipulation;

import java.util.Scanner;

public class RightMostSetBitMask {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        scn.close();
        int rsbmask = (n & -n);
        System.out.println(Integer.toBinaryString(rsbmask));
      }
}
