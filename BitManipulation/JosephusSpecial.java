package BitManipulation;

import java.util.Scanner;

public class JosephusSpecial {
    public static int power(int n){
        int i = 1;
        while(i * 2 <= n){
            i = i * 2;
        }
        return i;
        
    }
    public static int solution(int n){
      int hpower = power(n);
      int l = n - hpower;
      
      return 2 * l + 1;
    }
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      scn.close();
      System.out.println(solution(n));
    }
}
