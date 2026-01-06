import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,5,4,3});
        nextPermutation(new int[]{1,2,3,4,5});
        nextPermutation(new int[]{5,4,3,2,1});
    }

    private static void nextPermutation(int[] nums){
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if( i >= 0){
            int j = nums.length-1;
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
    reverse(nums, i+1);  
    System.out.println(Arrays.toString(nums));  
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int left){
        int right = arr.length -1;
        int temp = 0;
        while(left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }
    }
    
}
