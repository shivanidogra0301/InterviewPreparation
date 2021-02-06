package Dp.AdvancedDynamicProgramming.LongestIncreasing;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class PrintAlllis {

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;
        
        for(int i = 0; i < arr.length; i++){
            int max = 0;
            for(int j = i; j >= 0; j--){
                if(arr[j] <= arr[i] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max+1;
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(dp[i] == omax){
                q.add(new Pair(omax,i,arr[i],arr[i]+""));
            }
        }
        System.out.println(omax);
        while(q.size() > 0){
            Pair rem = q.remove();
            
            if(rem.l == 1){
                System.out.println(rem.psf);
            }
            for(int j = rem.i-1; j >= 0; j--){
                if(dp[j] == rem.l - 1 && arr[j] <= rem.v){
                    q.add(new Pair(rem.l-1,j,arr[j],arr[j]+" -> "+rem.psf));
                }
            }
        }
        
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}