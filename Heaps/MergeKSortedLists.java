package Heaps;
import java.io.*;
import java.util.*;
public class MergeKSortedLists {
        static class Pair implements Comparable<Pair>{
        int val;
        int row;
        int col;
        Pair(int val,int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
        
        public int compareTo(Pair o){
            return this.val- o.val;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
      for(int i = 0; i < lists.size(); i++){
          pq.add(new Pair(lists.get(i).get(0),i,0));
      }
      
      while(pq.size() > 0){
          Pair rem = pq.remove();
          rv.add(rem.val);
          int newrow = rem.row;
          int newcol = rem.col+1;
          
          if(newcol < lists.get(rem.row).size()){
              int newval = lists.get(rem.row).get(newcol);
              pq.add(new Pair(newval,newrow,newcol));
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}

