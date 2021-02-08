package Dp.AdvancedDynamicProgramming.PrintTypes;
import java.io.*;
import java.util.*;
public class Knapsack {
    
    static class  Pair{
        int i;
        int j;
        String psf;
        Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][cap+1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i==0 || j== 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    
                    if(j >= wts[i-1] && values[i-1]+dp[i-1][j-wts[i-1]] > dp[i][j]){
                        dp[i][j] = values[i-1]+dp[i-1][j-wts[i-1]];
                    }
                }
            }
        }
        System.out.println(dp[n][cap]);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,cap,""));
        while(q.size() > 0){
            Pair rem = q.remove();
            if(rem.i == 0|| rem.j == 0){
                System.out.println(rem.psf);
            }
            else{
                if(rem.j >= wts[rem.i-1]){
                    int inc = dp[rem.i-1][rem.j-wts[rem.i-1]]+values[rem.i-1];
                    if(dp[rem.i][rem.j] == inc){
                        q.add(new Pair(rem.i-1,rem.j-wts[rem.i-1],(rem.i-1)+" "+rem.psf));
                    }
                }
                int exc = dp[rem.i-1][rem.j];
                if(dp[rem.i][rem.j] == exc){
                    q.add(new Pair(rem.i-1,rem.j,rem.psf));
                }
                
            }
        }
        

    }
}

