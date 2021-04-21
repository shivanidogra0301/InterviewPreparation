package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosaRajuAlgo {
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                dfs(adj,i,visited,st);
            }
        }
        ArrayList<ArrayList<Integer>> newgraph = transpose(V,adj);
        visited = new boolean[V];
        int count =0;
        while(st.size() > 0){
            int rem = st.pop();
            if(visited[rem] == false){
                dfs(newgraph,rem,visited);
                count++;
            }
        }
        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited,Stack<Integer> st ){
        visited[src] = true;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs] == false)
                dfs(adj,nbrs,visited,st);
        }
        st.push(src);
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited ){
        visited[src] = true;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs] == false)
                dfs(adj,nbrs,visited);
        }
        
    }
    
    

    
    public static ArrayList<ArrayList<Integer>> transpose(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i< V; i++){
            result.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            for(int nbr : adj.get(i)){
                result.get(nbr).add(i);
            }
        }
        return result;
    }
    
}
