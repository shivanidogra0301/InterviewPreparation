package BinarySearchTree;

public class Lca {
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
    public static int lca(Node node, int d1, int d2) {
        if(node.data > d1 && node.data > d2){
            return lca(node.left,d1,d2);
        }
        else if(node.data < d1 && node.data < d2){
            return lca(node.right,d1,d2);
        }
        else{
            return node.data;
        }
      }
}
