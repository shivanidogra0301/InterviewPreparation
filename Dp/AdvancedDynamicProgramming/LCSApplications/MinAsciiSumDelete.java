package Dp.AdvancedDynamicProgramming.LCSApplications;

import java.util.Scanner;

public class MinAsciiSumDelete {
    public static int solution(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length-1; j >= 0; j--){
		        if((i== dp.length - 1) && (j == dp[0].length - 1)){
		            dp[i][j] = 0;
		        }
		        else if(i == dp.length-1){
		            dp[i][j] = dp[i][j+1] + (int)s2.charAt(j);
		        }
		        else if(j == dp[0].length-1){
		            dp[i][j] = dp[i+1][j] + (int)s1.charAt(i);
		        }
		        else{
		            char c1 = s1.charAt(i);
		            char c2 = s2.charAt(j);
		            
		            if(c1 == c2){
		                dp[i][j] = dp[i+1][j+1];
		            }
		            else{
		                int c1r = (int)c1+ dp[i+1][j];
		                int c2r = (int)c2 + dp[i][j+1];
		                dp[i][j] = Math.min(c1r,c2r);
		            }
		        }
		    }
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
        scn.close();
		System.out.println(solution(s1, s2));
	}
}
