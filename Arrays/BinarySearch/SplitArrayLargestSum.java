package Arrays.BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args){
        int[] nums = {3,2,2,4,1,4};
        int m = 3;
        System.out.println(splitArray(nums,m));

    }

    public  static int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE; // contain max value of array
        int high = 0; // sum of the array
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > low){
                low = nums[i];
            }
            high += nums[i];
        }
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(largestsumvalid(nums,m,mid)){ // check if it is possible to split the array into m  subarrays such that largest sum is mid
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
     public static boolean largestsumvalid(int[] nums, int m, int ls){
        int rm = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > ls){
                rm++;
                sum = 0;
            }
            sum += nums[i];
            
            
        }
        
        return rm <= m;
    }
    
}
