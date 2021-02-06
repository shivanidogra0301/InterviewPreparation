package Arrays2D;
import java.util.Scanner;
/*5. You are given a number r, representing number of anti-clockwise rotations (for +ve numbers) of the shell s.
6. You are required to rotate the sth shell of matrix by r rotations and display the matrix using display function.
*/
public class ShellRotate {
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
        
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        scn.close();
        shellrotate(arr,s,r);
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void shellrotate(int[][] arr, int s , int r){
        int[] oned = getonedfromShell(arr,s);
        rotate1D(oned,r);
        fillshellfromoned(oned,arr,s);
    }
    public static int[] getonedfromShell(int[][] arr,int s){
        int minr = s - 1;
        int minc = s-1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        
        int size = 2 *(maxr - minr + maxc - minc);
        int[] oned = new int[size];
        
        int idx=0;
        for(int i = minr,j = minc; i <= maxr; i++){ //south
            oned[idx] = arr[i][j];
            idx++;
        }
        minc++;
        for(int i = maxr,j = minc; j <= maxc; j++){ //east
            oned[idx] = arr[i][j];
            idx++;
        }
        maxr--;
        for(int i = maxr,j = maxc; i >= minr; i--){ //north
            oned[idx] = arr[i][j];
            idx++;
        }
        maxc--;
        for(int i = minr,j = maxc; j >= minc; j--){ //west
            oned[idx] = arr[i][j];
            idx++;
        }
        return oned;
    }
    
    
    public static void fillshellfromoned(int[] oned,int[][] arr, int s){
        int minr = s - 1;
        int minc = s-1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        
        
        
        int idx=0;
        for(int i = minr,j = minc; i <= maxr; i++){ //south
            arr[i][j] = oned[idx];
            idx++;
        }
        minc++;
        for(int i = maxr,j = minc; j <= maxc; j++){
            arr[i][j] = oned[idx];
            idx++;
        }
        maxr--;
        for(int i = maxr,j = maxc; i >= minr; i--){
            arr[i][j] = oned[idx];
            idx++;
        }
        maxc--;
        for(int i = minr,j = maxc; j >= minc; j--){
            arr[i][j] = oned[idx];
            idx++;
        }
        
    }
    
    public static void reverse(int[] arr, int l,int r){
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    
    public static void rotate1D(int[] arr, int r){
        r = r % arr.length;
        if(r < 0){
            r = r+arr.length;
        }
        
        reverse(arr,0,arr.length - 1 - r);
        reverse(arr, arr.length - r, arr.length -1);
        reverse(arr,0,arr.length-1);
    }

    
}
