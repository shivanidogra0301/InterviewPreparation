package Dp.AdvancedDynamicProgramming.GapStrategyQues;

import java.util.Scanner;

class BooleanParanthesis{
    public static int solution(String str1, String str2) {
		int[][] tt = new int[str1.length()][str1.length()];
		int[][] ft = new int[str1.length()][str1.length()];
		
		for(int g = 0; g < tt.length; g++){
		    for(int i = 0, j = g; j < tt.length; j++,i++){
		        if(g == 0){
		            if(str1.charAt(i) == 'T'){
		                tt[i][j] = 1;
		            }
		            else{
		                ft[i][j] = 1;
		            }
		        }

		        else {
		            int tans = 0;
		            int fans = 0;
		            for(int k = i; k < j; k++){
		                int lt = tt[i][k];
		                int rt = tt[k+1][j];
		                int lf = ft[i][k];
		                int rf = ft[k+1][j];
		                if(str2.charAt(k) == '&'){
		                   tans += lt*rt;
		                   fans += lt*rf + lf * rf + lf * rt;
		                }
		                else if(str2.charAt(k) == '|'){
		                    tans += lt*rt + lt*rf + lf*rt;
		                    fans += lf*rf;
		                }
		                else{
		                    tans += lt*rf + lf*rt;
		                    fans += lf*rf + lt*rt;
		                }
		            }
		            
		            tt[i][j] = tans;
		            ft[i][j] = fans;
		            
		        }
		    }
		    
		}
		

		return tt[0][tt.length-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		scn.close();
		System.out.println(solution(s1, s2));
	}
}