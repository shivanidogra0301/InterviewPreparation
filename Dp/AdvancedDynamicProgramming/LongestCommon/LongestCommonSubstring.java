package Dp.AdvancedDynamicProgramming.LongestCommon;

import java.util.Scanner;

public class LongestCommonSubstring {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        String str2 = scn.next();
        scn.close();
        System.out.println(solution(str1,str2));
    }

    public static int solution(String s1, String s2) {
    
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    continue;
                }
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
