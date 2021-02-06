package Graph;

import java.io.*;
import java.util.*;

public class DijikstraAlgo {

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
		System.out.println("Enter no of vertices ");
		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}
		System.out.println("Enter no of edges ");
		int edges = Integer.parseInt(br.readLine());
		System.out.println("Enter two vertices of all the edges and weight of that edge ");

		for (int i = 0; i < edges; i++) {

			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}
		System.out.println("Enter Source  vertex name ");
		int src = Integer.parseInt(br.readLine());
		// write your code here
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, src + "", 0));
		boolean[] visited = new boolean[vtces];

		while (pq.size() > 0) {
			Pair rp = pq.remove();
			if (visited[rp.v] == true) {
				continue;
			}
			visited[rp.v] = true;
			System.out.println("Vertex : "+ rp.v + " via path  " + rp.psf + " , weight " + rp.wsf);
			for (Edge e : graph[rp.v]) {
				if (visited[e.nbr] == false) {
					pq.add(new Pair(e.nbr, rp.psf + e.nbr, rp.wsf + e.wt));
				}
			}
		}

	}

	public static class Pair implements Comparable<Pair> {
		int v;
		String psf;
		int wsf;

		Pair(int v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

}
