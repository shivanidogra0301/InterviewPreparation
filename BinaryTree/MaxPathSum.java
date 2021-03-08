package BinaryTree;

public class MaxPathSum {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumHelper(root);
        return maxSum;
            
    }
    /* here we have four cases for every node, taking only root node,
    taking only left+curnode or only right+curnode or taking all left+right+curnode. So here we can see that if left and right is not negative
    so our ans will always be last case. */
    public int maxSumHelper(TreeNode root){
        if (root == null) return 0; 
        int lmaxsum = Math.max(0,maxSumHelper(root.left));
        int rmaxsum = Math.max(0,maxSumHelper(root.right));
        
        maxSum = Math.max(maxSum,root.val+lmaxsum+rmaxsum);
        return Math.max(lmaxsum,rmaxsum)+root.val; // in recursion we want only a path that will include next root node
		
		
    }
    
}
