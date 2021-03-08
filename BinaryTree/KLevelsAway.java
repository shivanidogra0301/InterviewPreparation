package BinaryTree;

import java.util.ArrayList;

public class KLevelsAway {
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
    public static void printKLevelsDown(Node node, int k,Node block){
        if(node == null||node == block){
            return;
        }
        if(k == 0 ){
            System.out.println(node.data);
            return;
        }
        printKLevelsDown(node.left,k-1,block);
        printKLevelsDown(node.right,k-1,block);
      }
      
     public static ArrayList<Node> nodeToRootPath(Node node, int data){
        if(node == null){
            ArrayList<Node> bl = new ArrayList<>();
            return bl;
        }
        if(node.data == data){
            ArrayList<Node> bl = new ArrayList<>();
            bl.add(node);
            return bl;
        }
        ArrayList<Node> ll = nodeToRootPath(node.left,data);
        if(ll.size() > 0){
            ll.add(node);
            return ll;
        }
        ArrayList<Node> rl = nodeToRootPath(node.right,data);
        if(rl.size() > 0){
            rl.add(node);
            return rl;
        }
        ArrayList<Node> bl = new ArrayList<>();
        return bl;
        
      }

      public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node.left == null && node.right == null){
            
            sum+= node.data;
            // System.out.println(sum);
            path += node.data;
            if(sum>= lo && sum <= hi)
                System.out.println(path);
            
        }
        else if(node.left == null){
            pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
        }
        else if(node.right == null){
            pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
        }
        else{
            pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
            pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
        }
        
        
      }

      public static void printSingleChildNodes(Node node){
        if(node.left != null && node.right == null){
            System.out.println(node.left.data);
        }
        else if(node.right != null && node.left == null){
            System.out.println(node.right.data);
        }
        else if(node.left!= null && node.right != null){
            printSingleChildNodes(node.left);
            printSingleChildNodes(node.right);
        }
        else{
            return;
        }
      }

  public static void printKNodesFar(Node node, int data, int k) {
    ArrayList<Node> list = nodeToRootPath(node,data);
    for(int i = 0; i < list.size(); i++){
        Node block = null;
        if(i >=1){
            block = list.get(i-1);
        }
        printKLevelsDown(list.get(i),k-i,block);
    }
    
  }

  public static Node removeLeaves(Node node){
    if(node == null){
        return null;
    }
    if(node.left == null && node.right == null){
        return null;
    }
    
    node.left = removeLeaves(node.left);
    node.right = removeLeaves(node.right);
    return node;
  }

  public static Node createLeftCloneTree(Node node){
    if(node == null){
        return node;
    }
    Node lc = createLeftCloneTree(node.left);
    Node rc = createLeftCloneTree(node.right);
    node.right = rc;
    Node nl = new Node(node.data,lc,null);
    node.left = nl;
    return node;
  }
}
