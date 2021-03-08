package BinaryTree;

import java.util.Stack;

public class IterativePrePostIn {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }

      public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rpa = new Pair(node,1);
        st.push(rpa);
        String pre = "";
        String post = "";
        String in = "";
        while(st.size() > 0){
            Pair rem = st.peek();
            if(rem.state == 1){
                pre += rem.node.data+" ";
                rem.state = 2;
                if(rem.node.left != null)
                    st.push(new Pair(rem.node.left,1));
            }
            else if(rem.state == 2){
                in += rem.node.data+" ";
                rem.state = 3;
                if(rem.node.right != null)
                st.push(new Pair(rem.node.right,1));
            }
            else{
                post+= rem.node.data+" ";
                st.pop();
            }
        }
        System.out.println(pre);
        
        System.out.println(in);
        System.out.println(post);
      }

}