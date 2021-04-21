package Graph;
import java.util.*;
public class MotherVertex {
    static int count;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == false)
                dfs(adj,i,visited,st);
        }
        visited = new boolean[V];
        int src = st.pop();
        count = 0;
        dfs(adj,src,visited);
        if(count == V){
            return src;
        }
        else{
            return -1;
        }
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited,Stack<Integer> st){
        visited[src] = true;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs]== false){
                dfs(adj,nbrs,visited,st);
            }
        }
        st.push(src);
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited){
        visited[src] = true;
        count++;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs]== false){
                dfs(adj,nbrs,visited);
            }
        }
    }
}
