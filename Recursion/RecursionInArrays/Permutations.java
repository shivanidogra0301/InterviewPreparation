package Recursion.RecursionInArrays;

import java.util.HashSet;

public class Permutations {
    public static void main(String[] args){
        String str = "abc";
        int[] nums = {1,2,3};
        permutationString(str,"");
        System.out.println("*********************");
        permutationArrays(nums,0,nums.length-1);
        //unique permuation
        int[] nums1 = {1,2,1};
        HashSet<Integer> set = new HashSet<>();
        System.out.println("*********************");
        UniquePermutation(nums1,0,nums1.length-1,set);
    }
    // Permutation for String
    public static void permutationString(String str, String psf) {
        if(str.length() == 0){
            System.out.println(psf);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            permutationString(ros,psf+ch);
        }

    }
    //Permutation with arrays
    public static void permutationArrays(int[]nums,int l,int r){
        if(l == r){
            
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i] +" ");
            }
            System.out.println();
            return;
        }
        
        for(int i = l; i <= r; i++){
            swap(nums,i,l);
            permutationArrays(nums,l+1,r);
            swap(nums,i,l);
        }
    }

    public  static void  UniquePermutation(int[]nums,int l,int r,HashSet<Integer> set){
        if(l == r){
            
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            return;
        }

        set = new HashSet<>();
        for(int i = l; i <= r; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                swap(nums,i,l);
                UniquePermutation(nums,l+1,r,set);
                swap(nums,i,l);
            }
            
        }
    }
    
    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
