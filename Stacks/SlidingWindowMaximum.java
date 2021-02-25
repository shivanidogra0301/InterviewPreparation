package Stacks;
import java.io.*;
import java.util.*;
public class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        maxSlidingWindow(a,k);
        
    }
    public static void maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        Arrays.fill(nge,nums.length);
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < nge.length; i++){
            while(st.size() > 0 && nums[i] >= nums[st.peek()] ){
                int idx = st.pop();
                nge[idx] = i;
            }
            
            st.push(i);
        }
        
        int j = 0;
        
        for(int i = 0; i <= nums.length - k; i++){
            if(j < i){
                j = i;
            }
            while(nge[j] < i+k){
                j = nge[j];
            }
            System.out.println(nums[j]);
        }
        
    }
}

