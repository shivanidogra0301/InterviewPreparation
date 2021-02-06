package Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack < Integer > st = new Stack < > ();
        // code
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                st.push(count);
                count++;
            } else {
                st.push(count);
                count++;
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }

            }
        }
        st.push(count);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}
