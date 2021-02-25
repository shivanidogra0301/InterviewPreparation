package Dp.AdvancedDynamicProgramming.GapStrategyQues;

import java.util.Scanner;

public class RodCutting {
    public static int solution(int[] prices) {
        int[] np = new int[prices.length+1];
        for(int i = 1; i < np.length; i++){
            np[i] = prices[i-1];
        }
        
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        dp[1] = np[1];
        
        for(int i = 2; i < np.length; i++){
            dp[i] = np[i];
            int left = 1;
            int right = i-1;
            while(left <= right){
                if(dp[left]+dp[right] > dp[i]){
                dp[i] = dp[left]+dp[right];
                 }
                 
                 left++;
                 right--;
            }
            
        }
    
        return dp[dp.length-1];
      }
    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
          prices[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(prices));
      }
    
}
