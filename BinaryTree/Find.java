package BinaryTree;

import java.util.ArrayList;

public class Find {
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
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        boolean lans = find(node.left,data);
        if(lans){
            return true;
        }
        boolean rans = find(node.right,data);
        if(rans){
            return true;
        }
        return false;
      }
    
      public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node == null){
            ArrayList<Integer> bl = new ArrayList<>();
            return bl;
        }
        if(node.data == data){
            ArrayList<Integer> bl = new ArrayList<>();
            bl.add(data);
            return bl;
        }
        ArrayList<Integer> ll = nodeToRootPath(node.left,data);
        if(ll.size() > 0){
            ll.add(node.data);
            return ll;
        }
        ArrayList<Integer> rl = nodeToRootPath(node.right,data);
        if(rl.size() > 0){
            rl.add(node.data);
            return rl;
        }
        ArrayList<Integer> bl = new ArrayList<>();
        return bl;
        
      }
}
