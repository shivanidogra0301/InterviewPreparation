package Graph;

import java.util.HashMap;

public class LongestConsecutiveSequence {
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            if(nums.length == 1){
                return 1;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
           
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                int n = nums[i];
                if(map.containsKey(n) == false){
                    int sp = n;
                    int ep = n;
                    
                    if(map.containsKey(n-1)){
                        sp = sp - map.get(n-1);
                    }
                    if(map.containsKey(n+1)){
                        ep = ep + map.get(n+1);
                    }
                    int len = ep - sp+1;
                    map.put(sp,len);
                    map.put(ep,len);
                    
                    if(sp != n && ep != n){
                        map.put(n,1);
                    }
                    
                    max = Math.max(max,len);
                    
                }
            }
            return max;
        }
    
}
