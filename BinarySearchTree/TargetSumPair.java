package BinarySearchTree;

import java.util.ArrayList;

public class TargetSumPair {
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
      //complexity o(nh)
    public static void targetSumPair(Node root,int target,Node actualnode){
        if(root == null){
           return; 
        }
        
       
            targetSumPair(root.left,target,actualnode);
            int diff = target - root.data;
            if(diff > root.data){
                if(find(actualnode,diff)){
                      System.out.println(root.data+" "+ (diff));
                      
          }
            }
            
            targetSumPair(root.right,target,actualnode);
       
        
    }
    public static boolean find(Node node,int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        else if(node.data > data){
            boolean ans = find(node.left,data);
            return ans;
        }
        else{
            return find(node.right,data);
        }
    }
    // second approach o(n)
    static ArrayList<Integer> sorted ;
    public static void InOrder(Node root,ArrayList<Integer> sorted){
        if(root == null){
            return;
        }
        InOrder(root.left,sorted);
        sorted.add(root.data);
        InOrder(root.right,sorted);
    }

    public static void PrintTargetSum(Node root,int data){
        sorted = new ArrayList<>();
        InOrder(root,sorted);
        // System.out.println(sorted.size());
        int left = 0;
        int right = sorted.size()-1;
        
        while(left < right){
            int valleft = sorted.get(left);
            int valright = sorted.get(right);
            int sum = valleft +valright;
            if(sum == data){
                System.out.println(valleft+" "+valright);
                left++;
                right--;
            }
            else if(sum > data){
                right--;
            }
            else{
                left++;
            }
        }
        
      }
     
      
    
}
