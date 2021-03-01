package Dp.AdvancedDynamicProgramming.LCSApplications;
import java.util.Scanner;

public class LongestRepeatingSubsequence {

// same as longest common subsequence but two char are considere same if they have diffrent indexs
    public static int solution(String str){
		int[][] dp = new int[str.length()+1][str.length()+1];
		for(int i = 0; i < dp.length; i++){
		    for(int j = 0; j < dp.length; j++){
		        if(i == 0 || j == 0){
		            dp[i][j] = 0;
		        }
		        else{
		            if(str.charAt(i-1) == str.charAt(j-1) && i!=j){
		                dp[i][j] = dp[i-1][j-1] + 1;
		            }
		            else{
		                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
		            }
		        }
		    }
		}

		return dp[str.length()][str.length()];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        scn.close();
		System.out.println(solution(str));
	}
}


