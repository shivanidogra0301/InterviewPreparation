package Dp.AdvancedDynamicProgramming.CatalanNumber;
import java.util.*;
public class CatalanNumber {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        
        System.out.println(dp[n]);
 }

}

/*
Other variations  given n (2*n) points are given ,find non intersecting chords in circle */


