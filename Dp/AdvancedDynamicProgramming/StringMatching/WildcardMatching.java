package Dp.AdvancedDynamicProgramming.StringMatching;
import java.util.*;
public class WildcardMatching {

    public static boolean solution(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        
        for(int i = p.length(); i >= 0; i--){
            for(int j = s.length(); j >= 0; j--){
                if(i == p.length() && j == s.length()){
                    dp[i][j] = true;
                }
                else if(i == p.length()){
                    dp[i][j] = false;
                }
                else if(j == s.length()){
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j];
                    }
                }
                else {
                    char ch1 = p.charAt(i);
                    char ch2 = s.charAt(j);
                    if(ch1 == '?'){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(ch1 == '*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }
                    else{
                        if(ch1 == ch2){
                            dp[i][j] = dp[i+1][j+1];
                        }
                        else{
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
        scn.close();
    }

}

