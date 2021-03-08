package BinaryTree;

public class bstTogreatersum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
             val = x;
        }
   }
    public static TreeNode bstToGst(TreeNode root) {
        bsttosum(root);
        return root;
        
   }
   static int sum = 0;
   public static void bsttosum(TreeNode node){
       if(node == null){
           return ;
       }
       bsttosum(node.right);
       sum += node.val;
       if(node.val < sum){
           node.val = sum;
       }
       bsttosum(node.left);
       
     }

    static int s = 0;
  public static void rwsol(TreeNode node){ //replace with max sum
    if(node == null){
        return;
    }
    rwsol(node.right);
    int temp = node.val;
    node.val = s;
    s = s+temp;
    rwsol(node.left);
  }
}
