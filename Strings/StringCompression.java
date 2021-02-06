package Strings;
import java.util.Scanner;
public class StringCompression {
    public static String compression1(String str){
		// write your code here
		int i = 1;
		String nstr = str.charAt(0)+"";
		while(i < str.length() ){
		    
		    if(str.charAt(i) != str.charAt(i-1)){
		        nstr += str.charAt(i);
		    }
		    i++;
		}
		
		

		return nstr;
	}

	public static String compression2(String str){
		// write your code here
		int i = 1;
		String nstr = str.charAt(0)+"";
		int count = 1;
		while(i < str.length()){
		    char prev = str.charAt(i-1);
		    char cur = str.charAt(i);
		    
		    if(prev != cur){
		        if(count > 1){
		            nstr += count;
		            count = 1;
		        }
		        nstr+= cur;
		    }
		    else{
		        count++;
		    }
		    i++;
		}
		
		if(count > 1){
		    nstr += count;
		}

		
		

		return nstr;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}
    

