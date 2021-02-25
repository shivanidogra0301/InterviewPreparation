package Stacks;
import java.io.*;
import java.util.*;
public class MinStack2 {
  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      if(size() == 0){
          data.push(val);
          min = val;
      }
      else{
          if(val >= min){
              data.push(val);
          }
          else{
              int enc = val + val - min; // encrypted value to know the place where min got updated i.e. where stack.peek() < min
              data.push(enc);
              min = val;
          }
      }
    }

    int pop() {
      if(data.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      if(data.peek() >= min){
          return data.pop();
      }
      else{
          int rem = min; //actual val that should have stored
          
          min = 2 * min - data.pop(); // 2 * v - (v+v-minp) = minp
          return rem;
      }
    }

    int top() {
      if(data.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      if(data.peek() >= min){
          return data.peek();
      }
      else{
          return min;
      }
    }

    int min() {
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}

