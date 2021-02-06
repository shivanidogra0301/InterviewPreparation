package Arrays2D;
import java.util.Scanner;
public class WaveTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] a1 = new int[n1][m1];
        
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < m1; j++){
                a1[i][j] = scn.nextInt();
            }
        }
        scn.close();
        
        
        
        for(int i = 0; i < a1[0].length; i++){
            if( i %2 == 0){
                for(int j = 0; j < a1.length; j++){
                    System.out.println(a1[j][i]);
                    
                }
               
                
            }
            else{
                for(int j = a1.length-1; j >= 0; j--){
                    System.out.println(a1[j][i]);
                }
                
            }
            
        }
     }
}
