package Generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
    
        for(Node child: node.children){
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    
      public static void levelOrder(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size() > 0){
            Node rem = q.remove();
            System.out.print(rem.data+" ");
            for(Node n : rem.children){
                q.add(n);
            }
        }
        System.out.print(".");
      }
      public static void levelOrderLinewise(Node node){
        Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(q.size() > 0){
                int size = q.size();
                while(size-- > 0){
                    Node rem = q.remove();
                    System.out.print(rem.data+" ");
                    for(Node n : rem.children){
                    q.add(n);
                    }
                    
                }
                System.out.println();
                
            }
            
      }
      public static void levelOrderLinewiseZZ(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Stack<Node> st = new Stack<>();
        int i = 0;
            while(q.size() > 0){
                int size = q.size();
                if(i%2 == 0){
                    while(size > 0){
                        Node rem = q.remove();
                        System.out.print(rem.data+" ");
                        for(Node n : rem.children){
                        q.add(n);
                        }
                    size--;
                    }
                }
                else{
                    while(size > 0){
                        Node rem = q.remove();
                        st.push(rem);
                        for(Node n : rem.children){
                        q.add(n);
                        }
                    size--;
                    }
                    while(st.size() > 0){
                        System.out.print(st.pop().data+" ");
                    }
                    
                }
                i++;
                System.out.println();
                    
            }
      }
}
