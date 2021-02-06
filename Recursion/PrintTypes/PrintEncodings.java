package Recursion.PrintTypes;

import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        printEncodings(str,"");

    }

    public static void printEncodings(String str,String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        else if(str.length() == 1){
            char ch = str.charAt(0);
            if(ch == '0'){
                return;
            }
            else{
                int val = ch - '0';
                char valch = (char)('a'+val -1);
                String ros = str.substring(1);
                printEncodings(ros,ans+valch);
            }
        }
        else{
            char ch = str.charAt(0);
            if(ch == '0'){
                return;
            }
            else{
                int val = ch - '0';
                String ros = str.substring(1);
                char valch = (char)('a'+val -1);
                printEncodings(ros,ans+valch);
            }
            
            String str12 = str.substring(0,2);
            String ros12 = str.substring(2);
            int val12 = Integer.parseInt(str12);
            
            if(val12 <= 26){
                char val12ch = (char)('a' + val12 - 1);
                printEncodings(ros12,ans+val12ch);
            }
            
            
        }
        
        
        
        
        

    }

}
