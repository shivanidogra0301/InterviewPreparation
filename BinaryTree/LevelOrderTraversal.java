package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
              val = x;
        }
  }
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(q.size() > 0){
            
            int size = q.size();
            ArrayList<Integer> trav = new ArrayList<>();
            while(size > 0){
                
                TreeNode rem = q.remove();
                trav.add(rem.val);
                if(rem.left!=null && rem.left.val!= -1)
                  q.add(rem.left);
                if(rem.right!=null && rem.right.val!= -1)
                  q.add(rem.right);
                size--;
            }
            list.add(trav);
        }
        return list;
        
  }

}
