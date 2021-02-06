package Arrays;
 // Maximum Sum subarray
public class KadaneAlgo{
    public static void main(String[] args){
        int[] arr = {1,2,-1,5,-1};

        int msf = arr[0];
        int omax = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(msf + arr[i] > arr[i]){
                msf = msf + arr[i];
            }
            else{
                msf = arr[i];
            }

            //for overall max
            if(msf > omax){
                omax = msf;
            }
        }

        System.out.println(omax);
    }
}