package Recursion.RecursionInArrays;

import java.util.Scanner;

public class IndicesinArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        System.out.println(firstIndex(arr, 0, x));
        scn.close();
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        } else {
            int fi = firstIndex(arr, idx + 1, x);
            return fi;
        }
    }
    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }
        int li = lastIndex(arr, idx + 1, x);
        if (arr[idx] == x) {
            if (li == -1) {
                return idx;
            } else {
                return li;
            }
        } else {
            return li;
        }
    }
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here
        if (idx == arr.length) {
            int[] ba = new int[fsf];
            return ba;
        }
        if (arr[idx] == x) {
            int[] ans = allIndices(arr, x, idx + 1, fsf + 1);
            ans[fsf] = idx;
            return ans;

        } else {
            int[] ans = allIndices(arr, x, idx + 1, fsf);
            return ans;
        }

    }
}
