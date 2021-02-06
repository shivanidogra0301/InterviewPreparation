package Dp.AdvancedDynamicProgramming.PrintTypes;
import java.io.*;
import java.util.*;
public class MazePath {
    

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[][]dp = new int[n][m];
        dp[n-1][m-1] = arr[n-1][m-1];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == n-1){
                    dp[i][j] = arr[i][j]+ dp[i][j+1];
                }else  if(j == m-1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("",0,0));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            int curi = rem.i;
            int curj = rem.j;
            
            if(curi == n-1 && curj == m-1){
                System.out.println(rem.psf);
            }
            else if(curj == m-1){
                q.add(new Pair(rem.psf+"V",curi+1,curj));
            }
            else if(curi == n-1){
                q.add(new Pair(rem.psf+"H",curi,curj+1));
            }
            else {
                if(dp[curi+1][curj] == dp[curi][curj+1]){
                    q.add(new Pair(rem.psf+"V",curi+1,curj));
                    q.add(new Pair(rem.psf+"H",curi,curj+1));
                    
                }
                else if(dp[curi+1][curj] < dp[curi][curj+1]){
                    q.add(new Pair(rem.psf+"V",curi+1,curj));
                }
                else{
                    q.add(new Pair(rem.psf+"H",curi,curj+1));
                }
            }
            

        }

    }

}

