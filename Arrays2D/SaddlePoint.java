package Arrays2D;
import java.util.Scanner;
public class SaddlePoint {
    public static void main(String[] args) throws Exception {
        // write your code here
        
        //In array there exist only one saddle point, which is min in its row
        // and max in its column;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        for(int i = 0; i < arr.length; i++){
            int col = 0;
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] < arr[i][col]){
                    col = j;
                }
            }
            boolean flag = true;
            for(int k = 0; k < arr.length; k++){
                if(arr[k][col] > arr[i][col]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(arr[i][col]);
                return;
            }
        }
        
        System.out.println("Invalid input");
    }

}
