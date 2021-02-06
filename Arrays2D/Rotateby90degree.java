package Arrays2D;
import java.util.Scanner;
public class Rotateby90degree {
    public static void main(String[] args) throws Exception {
        // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[][] a1 = new int[n1][n1];
    
    for(int i = 0; i < n1; i++){
        for(int j = 0; j < n1; j++){
            a1[i][j] = scn.nextInt();
        }
    }
    scn.close();
    int[][] invarr = new int[n1][n1];
    
    // transpose
    for(int i = 0; i < n1; i++){
        for(int j = 0; j < n1; j++){
            invarr[j][i] = a1[i][j];
        }
    }
    
    //reverse
    int k = invarr[0].length -1;
    for(int j = 0; j < invarr[0].length/2; j++){
        for(int i = 0; i < invarr.length; i++){
                int temp = invarr[i][j];
                invarr[i][j] = invarr[i][k];
                invarr[i][k] = temp;
                
        }
        k--;
    }
    display(invarr);
    
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
