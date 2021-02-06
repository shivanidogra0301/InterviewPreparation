package Strings;
import java.util.Scanner;
public class PrintPallindromicSubstring {
    public static void solution(String str){
		//write your code here
		for(int i = 0; i < str.length(); i++){
		    for(int j = i; j < str.length(); j++){
		        if(IsPallindromic(str.substring(i,j+1))){
		            System.out.println(str.substring(i,j+1));
		        }
		    }
		}
		
	}
	
	public static boolean IsPallindromic(String str){
	    int l = 0, r = str.length() - 1;
	    
	    while(l < r){
	        if(str.charAt(l)  != str.charAt(r)){
	            return false;
	        }
	        l++;
	        r--;
	    }
	    return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        solution(str);
        scn.close();
	}
    
}
