package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 
 Input 
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Output

[[0, 1], [2, 3], [4, 5, 6]]
 */

public class GetConnectedComponet {
	
	static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr, int wt) {
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for (int i = 0; i < vtces; i++) {
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for (int i = 0; i < edges; i++) {
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
	      
	    boolean[] visited = new boolean[vtces];
	        for(int vtx = 0; vtx < vtces; vtx++){
	            if(visited[vtx] == false){
	                ArrayList<Integer> comp = new ArrayList<>();
	                getconnected(graph,vtx,comp,visited);
	                comps.add(comp);
	            }
	        }

	      System.out.println(comps); //(print connected components)
	      // if we want to know if the graph is connected
	      
	      System.out.println(comps.size() == 1);

	}
	
	public static void getconnected(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited){
	       visited[src] = true;
	       comp.add(src);
	       for(Edge e: graph[src]){
	           if(visited[e.nbr] == false){
	               getconnected(graph,e.nbr,comp,visited);
	           }
	       }
	   }

}
