package Dp.AdvancedDynamicProgramming.CatalanNumber;

import java.util.Scanner;

public class MinimumTriangulation {
    public static int minScoreTriangulation(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0, j = g; j < dp[0].length; i++,j++){
		        if(g == 0 || g == 1){
		            dp[i][j] = 0;
		        }
		        else if(g == 2){
		            dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
		        }
		        else{
		            int min = Integer.MAX_VALUE;
		            for(int k = i+1; k <= j - 1; k++){
		                int tri = arr[i] * arr[k] * arr[j];
		                int pre = dp[i][k];
		                int post = dp[k][j];
		                int ans = tri+pre+post;
		                if(ans < min){
		                    min = ans;
		                }
		            }
		            
		            dp[i][j] = min;
		        }
		        
		    }
		}
		
		
		return dp[0][arr.length-1];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
		for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(minScoreTriangulation(arr));
	}
}
