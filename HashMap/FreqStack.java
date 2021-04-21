package HashMap;

import java.util.HashMap;
import java.util.Stack;
/*
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

    FreqStack() constructs an empty frequency stack.
    void push(int val) pushes an integer val onto the top of the stack.
    int pop() removes and returns the most frequent element in the stack.
        If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

 */
public class FreqStack {
    HashMap<Integer,Stack> h1;
    HashMap<Integer,Integer> h2;
    int maxfreq;
    public FreqStack() {
        h1 = new HashMap<>();
        h2 = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int val) {
        
        if(!h2.containsKey(val)){
            h2.put(val,1);
        }
        else{
            h2.put(val,h2.get(val)+1);
        }
        int freq = h2.get(val);
        if(freq > maxfreq){
            maxfreq = freq;
        }
        
        if(!h1.containsKey(freq)){
            Stack<Integer> st = new Stack<>();
            st.push(val);
            h1.put(freq,st);
        }
        else{
            Stack<Integer> st = h1.get(freq);
            st.push(val);
            h1.put(freq,st);
        }
        
    }
    
    public int pop() {
        Stack<Integer> remst = h1.get(maxfreq);
        int val = remst.pop();
        if(remst.size() ==  0){
            h1.remove(maxfreq);
            maxfreq--;
        }
        h2.put(val,h2.get(val)-1);
        return val;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
