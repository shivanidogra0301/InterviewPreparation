package Stacks;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        Stack < Character > st = new Stack < > ();
        HashMap < Character, Character > map = new HashMap < > ();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.size() > 0 && map.get(ch) == st.peek()) {
                    st.pop();
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(st.size() == 0);

    }

}
