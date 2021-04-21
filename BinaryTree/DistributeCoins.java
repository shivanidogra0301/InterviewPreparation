package BinaryTree;

public class DistributeCoins {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int data, TreeNode left, TreeNode right) {
          this.val = data;
          this.left = left;
          this.right = right;
        }
      }
    static int move ;
    public static int distributeCoins(TreeNode root) {
        move = 0;
        distribute(root);
        return move;
    }
    
    public static int  distribute(TreeNode root){
        if(root == null){
            return 0;
        }
        int d1 = distribute(root.left);
        int d2 = distribute(root.right);
        move = move+Math.abs(d1)+Math.abs(d2);
        return root.val - 1 +d1 + d2;
        }
}
