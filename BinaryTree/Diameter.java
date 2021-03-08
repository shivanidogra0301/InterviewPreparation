package BinaryTree;

public class Diameter {
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
    static int dia ;
    public static int diameter1(Node node) {
      dia = 0;
      diameter2(node);
      return dia;
    }
    
    public static int diameter2(Node node){
        if(node == null){
            return -1;
        }
        int lh = diameter2(node.left);
        int rh = diameter2(node.right);
        
        dia = Math.max(dia,rh + lh + 2);
        return Math.max(lh,rh)+1;
    }
    static int tilt = 0;
  public static int tilt(Node node){
    if(node == null){
        return 0;
    }
    int lsum = tilt(node.left);
    int rsum = tilt(node.right);
    
    tilt =tilt+Math.abs(lsum-rsum);
    
    return lsum+rsum+node.data;
  }
}
