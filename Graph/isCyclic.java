package Graph;
import java.util.*;
import java.io.*;
public class isCyclic {
	
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

	      // write your code here
	      boolean[] visited = new boolean[vtces];
	      for(int v = 0; v < vtces; v++){
	          if(visited[v] == false){
	              boolean cycle = isCyclic(v,visited,graph);
	              if(cycle){
	                  System.out.println("true");
	                  return;
	              }
	          }
	      }
	      System.out.println("false");
	   }
	   public static boolean isCyclic(int v, boolean[] visited,ArrayList<Edge>[] graph){
	       LinkedList<Integer> queue = new LinkedList<>();
	       queue.add(v);
	       while(!queue.isEmpty()){
	           int rv = queue.remove();
	           if(visited[rv] == true){
	               return false;
	           }
	           visited[rv] = true;
	           for(Edge e : graph[rv]){
	               if(visited[e.nbr] == false){
	                   queue.add(e.nbr);
	               }
	           }
	       }
	       return false;
	   }
	
}
