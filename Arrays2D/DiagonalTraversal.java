package Arrays2D;
import java.util.Scanner;
public class DiagonalTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        
        for(int gap = 0; gap < arr.length; gap++){
            int i = 0;
            int j = gap;
            while(j < arr[0].length){
                System.out.println(arr[i][j]);
                i++;
                j++;
            }
            
        }
    }
}
