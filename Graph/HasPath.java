package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
 * Input:
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6
 */

public class HasPath {
	static class Edge{
		int src;
		int nbr;
		int wt;
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces]; 
		
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int edges = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < edges; i++) {
			String[] part = br.readLine().split(" ");
			int v1 = Integer.parseInt(part[0]);
			int v2 = Integer.parseInt(part[1]);
			int wt = Integer.parseInt(part[2]);
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		
		int src = Integer.parseInt(br.readLine());
	    int dest = Integer.parseInt(br.readLine());
	    
	    boolean[] visited = new boolean[vtces];
	    System.out.println(hasPath(graph,src,dest,visited));


	}
	public static boolean hasPath(ArrayList<Edge>[] graph,int src,int des,boolean[] visited){
        if(src == des){
            return true;
        }
        
        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false && hasPath(graph,e.nbr,des,visited)){
                    return true;
            }
            
        }
        
        return false;
    }
	
	 public static void printpath(ArrayList<Edge>[] graph, int src,int dest,boolean[] visited,String psf){
	       if(src == dest){
	           System.out.println(psf);
	           return;
	       }
	       
	       visited[src] = true;
	       for(Edge e : graph[src]){
	           if(visited[e.nbr] == false)
	           printpath(graph,e.nbr,dest,visited,psf+e.nbr);
	       }
	       visited[src] = false;
	       
	    }

}
