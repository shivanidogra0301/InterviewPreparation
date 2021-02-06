package Recursion.RecursionIntro;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.print(powerLinear(x, n));
        scn.close();
    }
    public static int powerLinear(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * powerLinear(x, n - 1);
    }

    public static int powerLog(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            int ans = powerLog(x, n / 2);
            return ans * ans;

        } else {
            int ans = powerLog(x, n / 2);
            return ans * ans * x;
        }
    }
    
}
