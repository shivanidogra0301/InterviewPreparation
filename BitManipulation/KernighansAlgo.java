package BitManipulation;

import java.util.Scanner;
// to count no of "on" bits
public class KernighansAlgo {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        
        int count = 0;
        while(n != 0){
            int rsbm = n & -n;
            n = n - rsbm;
            count++;
            
        }
      
      System.out.println(count);
      }
}
