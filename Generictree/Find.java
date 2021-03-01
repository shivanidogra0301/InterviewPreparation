package Generictree;

import java.util.ArrayList;

public class Find {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
      public static boolean find(Node node, int data) {
        if(node.data == data){
            return true;
        }
        for(Node n: node.children){
            boolean ans = find(n,data);
            if(ans){
                return true;
            }
        }
        return false;
      }
      public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> bl = new ArrayList<>();
            bl.add(data);
            return bl;
        }
        
        for(Node n : node.children){
            ArrayList<Integer> reclist = nodeToRootPath(n,data);
            if(reclist.size() > 0){
                reclist.add(node.data);
                return reclist;
            }
            
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        return ans;
     }
    public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        
        for(int i = 0; i < n1.children.size(); i++){
                Node one = n1.children.get(i);
                Node two = n2.children.get(i);
                boolean ans = areSimilar(one,two);
                if(ans == false){
                    return false;
                }
            }
            return true;
        
        }
}
