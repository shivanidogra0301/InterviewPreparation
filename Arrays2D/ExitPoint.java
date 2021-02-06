package Arrays2D;
import java.util.Scanner;
/* Interesting set of interview questions on matrix.

 1. You are given a 2d matrix containing 1's and 0's.

 2. The player enters the matrix at 0, 0 in east direction.

 3. The player moves straight till the time 0's are encountered. On meeting a 1, the player turns 90 degree right.

 4. You should print the coordinates of the point where player exits the matrix.
*/
public class ExitPoint{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
 	 	 int c = scn.nextInt();
 	 	 int[][] arr = new int[r][c];
 	 	 for (int i = 0; i < arr.length; i++) {
 	 	 	 for (int j = 0; j < arr[0].length; j++) {
 	 	 	 	 arr[i][j] = scn.nextInt();
 	 	 	 }
 
           }
           scn.close();
 	 	 exitPoint(arr);

    }
    public static void exitPoint(int[][] arr) {
        int i = 0, j = 0;
        int dir = 0; // 0 - east, 1 - south, 2- west, 3- north

        while(true){
            dir = (dir + arr[i][j])%4;
            if(dir == 0){
                j++;
            }
            else if(dir == 1){
                    i++;
            }
            else if(dir == 2){
                j--;
            }
            else{
                i--;
            }

            if(i < 0){
                i++;
                break;
            }
            else if(i > arr.length){
                i--;
                break;
            }
            else if(j < 0){
                j++;
                break;
            }
            else if(j > arr[0].length){
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);

   }
}