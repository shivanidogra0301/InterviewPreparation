package Dp.AdvancedDynamicProgramming.GapStrategyQues;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static int mcm(int[] arr){
		int[][] dp = new int[arr.length-1][arr.length-1];
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0,j = g; j < dp.length; j++,i++){
		        if(g == 0){
		            dp[i][j] = 0;
		        }
		        else if(g == 1){
		            dp[i][j] = arr[i] * arr[j] * arr[j+1];
		        }
		        else{
		            int min = Integer.MAX_VALUE; 
		            for(int k = i; k < j; k++){
		                int left = dp[i][k];
		                int right = dp[k+1][j];
		                int mul = arr[i] * arr[k+1] * arr[j+1];
		                
		                int tc = left+right+mul;
		                
		                if(tc < min){
		                    min = tc;
		                }
		            }
		            dp[i][j] = min; 
		        }
		    }
		}

		return dp[0][dp.length-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
		System.out.println(mcm(arr));
	}

}
