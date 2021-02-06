package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        scn.close();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ')'){
                if(st.peek() == '('){
                    System.out.println(true);
                    return;
                }
                else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push(str.charAt(i));
            }
        }
        System.out.println(false);

    }
}
