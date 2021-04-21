package HashMap;

import java.util.HashMap;

// total subarrays having equal zeros and ones
public class TotalSubarrays {
    public static void main(String[] args){
        String str = "1001011";
        int[] pc0 = new int[str.length()];
        int[] pc1 = new int[str.length()];
        if(str.charAt(0) == '0'){
            pc0[0] = 1;
        }
        else{
            pc1[0] = 1;
        }
        for(int i = 1; i < str.length(); i++){
            char ch  = str.charAt(i);

            if(ch == '0'){
                pc0[i] = pc0[i-1]+1;
            }
            else{
                pc0[i] = pc0[i-1];
            }
        }

        for(int i = 1; i < str.length(); i++){
            char ch  = str.charAt(i);

            if(ch == '1'){
                pc1[i] = pc1[i-1]+1;
            }
            else{
                pc1[i] = pc1[i-1];
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // base case
        int count = 0;
        for(int j = 0; j < str.length(); j++ ){
            int diff = pc1[j] - pc0[j];
            if(map.containsKey(diff)){
                count+= map.get(diff);
            }
            if(map.containsKey(diff)){
                map.put(diff,map.get(diff)+1);
            }
            else{
                map.put(diff,1);
            }
        }

        System.out.println(count);
    }
}
