package Generictree;

import java.util.ArrayList;

public class AreMirrors {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        int i = n1.children.size()-1;
        int j = 0;
        while(i >= 0){
            Node one = n1.children.get(i);
            Node two = n2.children.get(j);
            boolean ans = areMirror(one,two);
            if(ans == false){
                return false;
            }
            i--;
            j++;
        }
        return true;
      
    }
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
      }

      static Node predecessor;
  static Node successor;
  static int state;

  public static void predecessorAndSuccessor(Node node, int data) {
    if (state == 0) {
      if (node.data == data) {
        state = 1;
      } else {
        predecessor = node;
      }
    } else if (state == 1) {
      successor = node;
      state = 2;
    }
    for (Node child : node.children) {
      predecessorAndSuccessor(child, data);
    }
  }

  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
        if(node.data < ceil){
            ceil = node.data;
        }
    }
    if(node.data < data){
        if(node.data > floor){
            floor = node.data;
        }
    }
    
    for(Node child: node.children){
        ceilAndFloor(child,data);
    }
    
  }
  public static int kthLargest(Node node, int k){
    floor = Integer.MIN_VALUE;
    int factor = Integer.MAX_VALUE;
    for(int i = 0; i < k; i++){
        ceilAndFloor(node,factor);
        factor = floor;
        floor = Integer.MIN_VALUE;
    }
    return factor;
  }
}
