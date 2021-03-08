package Arrays;

public class KadaneApplication {
    public static void main(String[] args){
        int[] arr = {3,1,6,5,4,2 };
        int ans = arr[0] * arr[0];
        int cursum = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++){
            int incmin = (arr[i] < min? arr[i]:min);
            int incans = (cursum+arr[i])* incmin;
            int excans = arr[i]*arr[i];

            if(incans > excans){
                cursum += arr[i];
                min = incmin;
            }
            else{
                cursum = arr[i];
                min = arr[i];
            }
            ans = Math.max(ans,Math.max(incans,excans));
            }
        System.out.println(ans);

        }
}

