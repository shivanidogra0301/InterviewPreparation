package Dp.AdvancedDynamicProgramming.LongestCommon;

import java.util.Scanner;

class LongestCommonSubsequence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        String str2 = scn.next();
        scn.close();
        System.out.println(lcs(str1,str2));
    }

    public static int lcs(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //here dp[i][j] stores longest common subsequence of string upto i and upto j
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    char c1 = text1.charAt(i-1);
                    char c2 = text2.charAt(j-1);
                    
                    if(c1 == c2){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[text1.length() ][text2.length() ];
    }
}