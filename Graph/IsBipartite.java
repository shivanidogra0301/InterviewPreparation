package Graph;
import java.io.*;
import java.util.*;
public class IsBipartite {
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
	      int[] visited =  new int[vtces];
	      Arrays.fill(visited, -1);
	      for(int v = 0; v < vtces; v++){
	          if(visited[v] == -1){
	              if(isbipartite(graph,visited,v) == false){
	                  System.out.println("false");
	                  return;
	              }
	          }
	      }
	      System.out.println("true");
	   }
	   
	   public static boolean isbipartite(ArrayList<Edge>[] graph,int[] visited,int v){
	       LinkedList<Pair> queue = new LinkedList<>();
	       queue.add(new Pair(v,0));
	       
	       while(!queue.isEmpty()){
	           Pair rp = queue.remove();
	           if(visited[rp.v] != -1){
	               if(visited[rp.v] != rp.level){
	                   return false;
	               }
	           }
	           visited[rp.v] = rp.level;
	           
	           for(Edge e : graph[rp.v]){
	               if(visited[e.nbr] == -1){
	                   queue.add(new Pair(e.nbr,rp.level+1));
	               }
	           }
	           
	       }
	       return true;
	   }
	   static class Pair{
	       int v;
	       int level;
	       Pair(int v, int level){
	           this.v = v;
	           this.level = level;
	       }
	   }
	
}
