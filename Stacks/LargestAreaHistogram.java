package Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // code
        int[] rse = new int[arr.length]; //traverse from left
        Stack < Integer > st = new Stack < > ();
        Arrays.fill(rse, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                int idx = st.pop();
                rse[idx] = i;
            }
            st.push(i);
        }


        int[] lse = new int[arr.length];
        st = new Stack < > ();
        Arrays.fill(lse, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                lse[idx] = i;
            }
            st.push(i);
        }
        int omax = 0;
        for (int i = 0; i < arr.length; i++) {
            int breadth = rse[i] - lse[i] - 1;
            int height = arr[i];
            int area = height * breadth;
            if (area > omax) {
                omax = area;
            }
        }
        System.out.println(omax);

    }
}
