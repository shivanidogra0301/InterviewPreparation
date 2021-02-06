package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*  
- You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
- You are required to find and count the number of islands.

Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

output
3
 */

public class NumberOfIslands {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int m = Integer.parseInt(br.readLine());
	      int n = Integer.parseInt(br.readLine());
	      int[][] arr = new int[m][n];

	      for (int i = 0; i < arr.length; i++) {
	         String parts = br.readLine();
	         for (int j = 0; j < arr[0].length; j++) {
	            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
	         }
	      }

	      
	      int count=0;
	      boolean[][] visited= new boolean[arr.length][arr[0].length];
	      for(int i=0;i<arr.length;i++){
	          for(int j=0;j<arr[i].length;j++){
	              if(arr[i][j]==0&&visited[i][j]==false){
	                  drawtree(arr,i,j,visited);
	                  count++;
	              }
	          }
	      }
	      System.out.println(count);

	}
	
	public static void drawtree(int[][] arr, int i, int j, boolean[][] visited){
        if(i<0||j<0||i>=arr.length||j>=arr.length||arr[i][j]==1||visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        drawtree(arr,i-1,j,visited);
        drawtree(arr,i,j+1,visited);
        drawtree(arr,i+1,j,visited);
        drawtree(arr,i,j-1,visited);
        
    }

}
