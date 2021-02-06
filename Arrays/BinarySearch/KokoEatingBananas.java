package Arrays.BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        int H = 8;
        System.out.println(minEatingSpeed(piles,H));

    }
    public static int minEatingSpeed(int[] piles, int H) {
        int low = 1;  // contain min value of array
        int high = Integer.MIN_VALUE; // contain max value of array
        for(int i = 0; i < piles.length; i++){
           
            if(piles[i] > high){
                high = piles[i];
            }
        }
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(capacity(piles,H,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
    
    public static boolean capacity(int[] piles, int H, int K){
        int rh = 0;
        
        for(int i = 0; i < piles.length; i++){
            rh += Math.ceil((double)piles[i] / K);
            
        }
        
        return rh <= H;
    }
}
