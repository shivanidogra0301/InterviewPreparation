package Graph;

/* 
 * You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
Input
7
5
0 1
2 3
4 5
5 6
4 6
output
16
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriend {

	static class Edge{
	       int src;
	       int nbr;
	       Edge(int src, int nbr){
	           this.src=src;
	           this.nbr=nbr;
	       }
	   }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int n = Integer.parseInt(br.readLine());
	      int k = Integer.parseInt(br.readLine());
	      
	      // write your code here
	      ArrayList<Edge>[] graph= new ArrayList[n];
	      for(int v = 0; v < n; v++){
	          graph[v] = new ArrayList<>();
	      }
	       
	       for( int i = 0; i < k; i++){
	          String[] parts = br.readLine().split(" ");
	          int v1 = Integer.parseInt(parts[0]);
	          int v2 = Integer.parseInt(parts[1]);
	          graph[v1].add(new Edge(v1,v2));
	          graph[v2].add(new Edge(v2,v1));
	          
	      }
	      boolean[] visited = new boolean[n];
	      ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
	      for(int i=0; i<n; i++){
	          ArrayList<Integer> comp = new ArrayList<>();
	          if(visited[i]==false){
	              drawtree(graph, i,comp,visited);
	              comps.add(comp);
	          }
	      }
	      int ways=0;
	      for(int i =0; i<comps.size();i++){
	          for(int j=i+1; j<comps.size(); j++){
	              ways+= comps.get(i).size()*comps.get(j).size();
	          }
	      }
	      System.out.println(ways);
	}
	
	public static void drawtree(ArrayList<Edge>[]graph,int src,ArrayList<Integer> comp, boolean[] visited){
	       visited[src]=true;
	       comp.add(src);
	       for(Edge e: graph[src]){
	           if(visited[e.nbr]==false){
	               drawtree(graph,e.nbr,comp,visited);
	           }
	       }
	   }

}
