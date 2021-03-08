package BinaryTree;

public class isBsearchTree {
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
    static class  bstpair{
        boolean isbst;
        int min;
        int max;
        
    }
    public static bstpair isBST(Node node){ //postorder 
        if(node == null){
            bstpair bp = new bstpair();
              bp.isbst = true;
              bp.max = Integer.MIN_VALUE;
              bp.min = Integer.MAX_VALUE;
              return bp;
        }
        bstpair lp = isBST(node.left);
        bstpair rp = isBST(node.right);
        bstpair mp = new bstpair();
        mp.isbst = lp.isbst && rp.isbst && node.data >= lp.max && node.data <= rp.min;
        mp.min = Math.min(node.data,Math.min(lp.min,rp.min));
        mp.max = Math.max(node.data,Math.max(lp.max,rp.max));
        
        return mp;
        
        
    }

    // preorder or inorder
    static boolean fl = false;

    public static void isBST(Node node,int min,int max){
      if(node == null){
        return;
      }
      if(node.data < min || node.data > max){
        fl = true;
      }
      isBST(node.left,min,node.data-1);
      isBST(node.right,node.data+1,max);
      
    }

}
