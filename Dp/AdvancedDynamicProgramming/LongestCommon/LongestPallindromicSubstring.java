package Dp.AdvancedDynamicProgramming.LongestCommon;

import java.util.Scanner;

public class LongestPallindromicSubstring {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        scn.close();

        System.out.println(longestPalindromeSubstr(str1));
    }
    public static String longestPalindromeSubstr(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        String ans ="";
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; j++,i++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(c1 == c2){
                        dp[i][j] = true;
                    }
                }
                else{
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(c1 == c2 && dp[i+1][j-1]){ //middle part and extereme are same
                        dp[i][j] = true;
                    }
                    
                }
                if(dp[i][j] && g+1 > max){
                    max = g+1;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}
