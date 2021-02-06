package Recursion.RecursionInArrays;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        displayArr(arr,0);
        scn.close();
    }

    public static void displayArr(int[] arr, int idx) {
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);
    }
    public static void displayArrReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }
    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int max = maxOfArray(arr, idx + 1);
        return Math.max(arr[idx], max);
    }

}
