package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/*  A hamiltonian path is such which visits all vertices without visiting any twice. 
 * A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Input:
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Output
0123456.
0123465.
0125643*
0346521*
 */

public class HamiltonianPathCycles {
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
	       int src = Integer.parseInt(br.readLine());
	       HashSet<Integer> visited = new HashSet<>();
	        printHamiltonian(graph,src,visited,""+src,src);
	}
	 public static void printHamiltonian(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited,String psf,int osrc){
	       if(visited.size() == graph.length-1){
	           System.out.print(psf);
	           boolean iscycle = false;
	           for(Edge e : graph[src]){
	               if(e.nbr == osrc){
	                   iscycle = true;
	                   break;
	               }
	           }
	           if(iscycle){
	               System.out.println("*");
	           }
	           else{
	               System.out.println(".");
	           }
	       }
	       visited.add(src);
	       for(Edge e : graph[src]){
	           if(visited.contains(e.nbr) == false){
	               printHamiltonian(graph,e.nbr,visited,psf+e.nbr,osrc);
	           }
	       }
	       visited.remove(src);
	   }

}
