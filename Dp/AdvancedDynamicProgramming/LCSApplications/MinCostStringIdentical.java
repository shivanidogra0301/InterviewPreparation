package Dp.AdvancedDynamicProgramming.LCSApplications;

import java.util.Scanner;

public class MinCostStringIdentical {
    public static int solution(String s1, String s2, int c1, int c2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < dp.length; i++){
		    for(int j = 0; j < dp[0].length; j++){
		        if(i == 0 || j == 0){
		            dp[i][j] = 0;
		        }
		        else{
		            if(s1.charAt(i-1) == s2.charAt(j-1)){
		                dp[i][j] = dp[i-1][j-1] + 1;
		            }
		            else{
		                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
		            }
		        }
		    }
		}
		int lcs = dp[dp.length-1][dp[0].length-1];
		int s1r = s1.length() - lcs;
		int sr2 = s2.length() - lcs;
		int cost = s1r * c1 + sr2 * c2;
		
		return cost;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
        scn.close();
		System.out.println(solution(s1, s2,x, y));
	}
}
