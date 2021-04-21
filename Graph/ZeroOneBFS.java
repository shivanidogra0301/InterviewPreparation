package Graph;
import java.io.*;
import java.util.*;
public class ZeroOneBFS {
    static class Edge{
        int nbr;
        
        int wt;
        Edge(int nbr, int wt){
            this.nbr = nbr;
          
            this.wt = wt;
        }
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str  = br.readLine().split(" ");
	    int vtces = Integer.parseInt(str[0]);
	    int m = Integer.parseInt(str[1]);
	    ArrayList<Edge>[] graph = new ArrayList[vtces];
	    for(int i = 0; i < vtces; i++){
	        graph[i] = new ArrayList<>();
	    }
	    for(int i = 0; i < m; i++){
	        String[] parts  = br.readLine().split(" ");
	        int u = Integer.parseInt(parts[0])-1;
	        int v = Integer.parseInt(parts[1])-1;
	        graph[u].add(new Edge(v,0));
	        graph[v].add(new Edge(u,1));
	    }
	    boolean[] visited = new boolean[vtces];
	    LinkedList<Pair> q = new LinkedList<>();
	    q.add(new Pair(0,0));
	    while(q.size() > 0){
	        Pair rem = q.removeFirst();
	        if(rem.vtx == vtces-1){
	            System.out.println(rem.wt);
	            return;
	        }
	        visited[rem.vtx] = true;
	        
	        for(Edge nbrs : graph[rem.vtx]){
	            if(visited[nbrs.nbr] == false){
	                if(nbrs.wt == 0){
	                    q.addFirst(new Pair(nbrs.nbr,nbrs.wt+0));
	                }
	                else{
	                    q.addLast(new Pair(nbrs.nbr,nbrs.wt+1));
	                }
	            }
	        }
	    }
	    System.out.println("-1");
	    
	}
	
    static	class Pair{
	    int vtx;
	    int wt;
	    Pair(int vtx,int wt){
	        this.vtx = vtx;
	        this.wt = wt;
	    }
	}
}

//Leetcode application

// static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
// public int minCost(int[][] grid) {
// 	int n = grid.length;
// 	int m = grid[0].length;
// 	LinkedList<Pair> q = new LinkedList<>();
// 	q.add(new Pair(0,0,0));
// 	boolean[][] visited = new boolean[n][m]; 
// 	while(q.size() > 0){
// 		Pair rem = q.removeFirst();
// 		// System.out.println(rem.x +" "+rem.y+" "+rem.cost);
// 		if(rem.x == n-1 && rem.y == m-1){
			
// 			return rem.cost;
// 		}
// 		visited[rem.x][rem.y] = true;
// 		for(int i = 0; i < 4; i++){
// 			int newx = rem.x + dir[i][0];
// 			int newy = rem.y + dir[i][1];
// 			if(newx < 0 || newx >= n || newy < 0 || newy >= m || visited[newx][newy] == true ){
// 				continue;
// 			}
// 			if(grid[rem.x][rem.y] == i+1){
// 				q.addFirst(new Pair(newx,newy,rem.cost+0));
// 			}
// 			else{
// 				q.addLast(new Pair(newx,newy,rem.cost+1));
// 			}
// 		}
		
// 	}
// 	return 0;
// }
// static class Pair{
// 	int x;
// 	int y;
// 	int cost;
// 	Pair(int x,int y,int cost){
// 		this.x = x;
// 		this.y = y;
// 		this.cost = cost;
// 	}
// }


