package Recursion.BackTracking;

import java.util.Scanner;
/* 
8
8
0 1 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 0 0 0 0
0 1 0 1 0 1 1 1
0 0 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 1 1 1 0
0 1 0 0 0 0 0 0
*/

public class floodfill {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        boolean[][] visited = new boolean[n][m];
        Floodfill(arr,0,0,"",visited);
    }

    public static void Floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        if(row < 0 || col < 0 ||row >= maze.length || col >= maze[0].length ||maze[row][col] == 1 || visited[row][col] == true ){
            return;
        }
        if(row == maze.length -1 && col == maze[0].length - 1 ){
            System.out.println(psf);
            return;
        }
        
        
        
        visited[row][col] = true;
        Floodfill(maze,row-1,col,psf+"t",visited);
        Floodfill(maze,row+1,col,psf+"d",visited);
        Floodfill(maze,row,col+1,psf+"r",visited);
        Floodfill(maze,row,col-1,psf+"l",visited);
        visited[row][col] = false;

    }
}
