package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class GraphRepresentations {
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
		// two representations one is adjacency matrix which is 2d array meaning there is a
		//if arr[i][j] = 1 means there is a edge between the graph
		
		// we will make an array of edges where index represent node 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		
		for(int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < vtces; i++) {
			String[] parts = br.readLine().split(" ");
			int u = Integer.parseInt(parts[0]);
			int v = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[u].add(new Edge(u,v,wt));
			graph[v].add(new Edge(v,u,wt));
		}

	}

}
