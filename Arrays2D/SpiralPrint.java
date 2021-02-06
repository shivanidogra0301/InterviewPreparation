package Arrays2D;
import java.util.Scanner;
public class SpiralPrint {
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
        
        int dir = 1; // 1 - south, 2 - east, 3 - north, 4- west
        int top = 0, left = 0;
        int right = arr[0].length - 1, bottom = arr.length -1;
        int count = n * m;
        
        while(left <= right && top <= bottom){
            if(dir == 1 && count > 0){
                for(int i = top; i <= bottom; i++){
                        System.out.println(arr[i][left]);
                        count--;
                }
                left++;
                dir = 2;
            }
            if(count > 0 && dir == 2){
                for(int i = left; i <= right; i++){
                        System.out.println(arr[bottom][i]);
                        count--;
                }
                bottom --;
                dir = 3;
                
            }
            if(count > 0 && dir == 3){
                for(int i = bottom; i >= top; i--){
                        System.out.println(arr[i][right]);
                        count--;
                }
                right--;
                dir = 4;
                
            }
            if(count > 0 && dir == 4){
                for(int i = right; i >= left; i--){
                        System.out.println(arr[top][i]);
                        count--;
                }
                top++;
                dir = 1;
                
            }
        }
    }
}
