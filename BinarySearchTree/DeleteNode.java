package BinarySearchTree;

public class DeleteNode {
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
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null && root.right!= null){
                return root.right;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else{
                TreeNode temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
                
        }
        else{
            root.left = deleteNode(root.left,key);
                
            
        }
        return root;
        
    }
}
