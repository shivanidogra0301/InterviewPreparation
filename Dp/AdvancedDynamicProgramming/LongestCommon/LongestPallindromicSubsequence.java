package Dp.AdvancedDynamicProgramming.LongestCommon;

import java.util.Scanner;

public class LongestPallindromicSubsequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        scn.close();

        System.out.println(longestPalindromeSubseq(str1));
    }
    public static  int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; j++,i++){
                
                if(g == 0){
                    dp[i][j] = 1;
                }
                else if(g == 1){
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(c1 == c2)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 1;
                }
                else{
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(c1 == c2){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        
        return dp[0][s.length()-1];
    }
}
