package Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        // solve
        Stack<Integer> st = new Stack<>();
        int[] span = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                span[idx] = idx - i;
            }
            st.push(i);
            
        }
        
        while(st.size() > 0){
            int idx = st.pop();
            span[idx] = idx+1;
        }
        return span;
    }
}