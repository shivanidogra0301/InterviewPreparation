package BinaryTree;

public class PrintKleveldown {
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
    public static void printKLevelsDown(Node node, int k){
        if(node == null){
            return;
        }
        if(k == 0){
            System.out.println(node.data);
            return;
        }
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
      }
}
