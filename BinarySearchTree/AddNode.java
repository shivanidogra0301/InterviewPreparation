package BinarySearchTree;

public class AddNode {
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
    public static Node add(Node node, int data) {
        if(node == null){
            Node n = new Node(data,null,null);
            return n;
        }
        if(node.data > data){
            node.left =add(node.left,data);
            
        }
        else if(node.data < data){
           node.right = add(node.right,data);
        }
        return node;
      }
}
