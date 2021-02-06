package Dp.AdvancedDynamicProgramming.PrintTypes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class MinJumps {
        static class  pair{
        int i;
        int v;
        int mj;
        String psf;
        pair(int i, int v, int mj,String psf){
            this.i = i;
            this.v = v;
            this.mj = mj;
            this.psf = psf;
        }
    }
    public static void Solution(int arr[]) {
        Integer[] dp = new Integer[arr.length];
        dp[arr.length-1] = 0;
        
        for(int i = arr.length-2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= arr[i]; j++){
                int fidx = i+j;
                if(fidx < arr.length &&dp[fidx]!=null && dp[fidx] < min){
                    min = dp[fidx];
                }
            }
            if(min != Integer.MAX_VALUE )
                dp[i] = min+1;
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,arr[0],dp[0],0+""));
        
        System.out.println(dp[0]);
        while(q.size() > 0){
            pair rem = q.remove();
            
            if(rem.i == arr.length-1){
                System.out.println(rem.psf+" .");
            }
            
            for(int j = 1; j <= rem.v; j++){
                int idx = rem.i+j;
                if(idx < dp.length && dp[idx]!= null &&dp[idx] == rem.mj-1){
                    q.add(new pair(idx,arr[idx],dp[idx],rem.psf+" -> "+idx));
                }
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}

