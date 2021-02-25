package Recursion.RecursionInArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(grayCode(n));
        scn.close();
    }
    public static List<Integer> grayCode(int n) {
        if(n == 0){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        
        List<Integer> recresult = grayCode(n-1);
        int size = recresult.size();
        for(int i = size - 1; i >= 0; i--){
            int element = recresult.get(i);
            int ntoadd = (int)Math.pow(2,(n-1));
            recresult.add(element+ntoadd);
            
        }
        return recresult;
    }
    
}
