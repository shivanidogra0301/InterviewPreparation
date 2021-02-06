package Arrays.BinarySearch;

//leetcode 1011
public class CapacityToShipPackages {

    public static void main(String[] args){
        int[] weights = {3,2,2,4,1,4};
        int D = 3;
        System.out.println(shipWithinDays(weights,D));

    }
    public static int shipWithinDays(int[] weights, int D) {
        int low = Integer.MIN_VALUE; // contain max value of array
        int high = 0; // sum of the array
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > low){
                low = weights[i];
            }
            high += weights[i];
        }
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(capacity(weights,D,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
    
    public static boolean capacity(int[] weights, int D, int cap){
        int rd = 1;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            if(sum + weights[i] > cap){
                rd++;
                sum = 0;
            }
            sum += weights[i];
            
            
        }
        
        if(rd > D) return false;
        return true;
    }
}
