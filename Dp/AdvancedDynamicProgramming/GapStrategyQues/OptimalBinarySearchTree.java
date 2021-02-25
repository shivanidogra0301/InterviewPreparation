package Dp.AdvancedDynamicProgramming.GapStrategyQues;

import java.util.Scanner;

public class OptimalBinarySearchTree {
    private static void optimalbst(int[] keys, int[] frequency, int n) {
        int[][] dp = new int[n][n];
        int[] psa = new int[n];
        psa[0] = frequency[0];
        for (int i = 1; i < psa.length; i++) {
            psa[i] = frequency[i] + psa[i - 1];
        }
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = frequency[i];
                } else if (g == 1) {
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, 2 * f1 + f2);
                } else {
                    int min = Integer.MAX_VALUE;
                    int fta = psa[j] - ((i == 0) ? 0 : psa[i - 1]);
                    for (int k = i; k <= j; k++) {
                        int left = (k == i) ? 0 : dp[i][k - 1];
                        int right = (k == j) ? 0 : dp[k + 1][j];
                        int ans = left + right + fta;
                        if (ans < min) {
                            min = ans;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n - 1]);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        scn.close();
        optimalbst(keys, frequency, n);
    }
}