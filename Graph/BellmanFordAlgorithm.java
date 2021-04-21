package Graph;

import java.util.Arrays;

class BellmanFordAlgorithm
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] path = new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        
        path[0] = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(path[u] == Integer.MAX_VALUE){
                    continue;
                }
                
                if(path[u]+w < path[v]){
                    if(i == n-1){
                        return 1;
                    }
                    path[v] = path[u]+w;
                }
            }
        }
        
        
        return 0;
        
        
    }
}