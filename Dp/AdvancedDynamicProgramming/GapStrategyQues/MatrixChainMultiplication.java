package Dp.AdvancedDynamicProgramming.GapStrategyQues;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void mcm(int[] arr){
		int[][] dp = new int[arr.length-1][arr.length-1];
		int[][] br = new int[arr.length-1][arr.length-1];
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0,j = g; j < dp.length; j++,i++){
		        if(g == 0){
		            dp[i][j] = 0;
		        }
		        else if(g == 1){
		            dp[i][j] = arr[i] * arr[j] * arr[j+1];
		            br[i][j] = i;
		        }
		        else{
		            int min = Integer.MAX_VALUE; 
			    int mink = 0;	
		            for(int k = i; k < j; k++){
		                int left = dp[i][k];
		                int right = dp[k+1][j];
		                int mul = arr[i] * arr[k+1] * arr[j+1];
		                
		                int tc = left+right+mul;
		                
		                if(tc < min){
		                    min = tc;
				    mink = k;	
		                }
		            }
		            dp[i][j] = min; 
			    br[i][j] = mink;	
		        }
		    }
		}
		printBracket(0,br.length-1,br);

		
	}


    static char name;
    static String ans;
    public static void printBracket(int i, int j, int[][] br){
        if(i == j){
            ans+=name;
            name++;
            return;
        }
        ans+="(";
        printBracket(i,br[i][j],br); // print upto k
        printBracket(br[i][j] + 1,j,br);
        ans+=")";
        
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
		// System.out.println(mcm(arr));
		name = 'A';
       	ans ="";
		mcm(arr);
		System.out.println(ans);
	}

}
