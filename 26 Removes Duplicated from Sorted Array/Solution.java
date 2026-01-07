
// Below Solution took 0ms

// import java.util.Arrays;

// class Solution {
//     public static int removeDuplicates(int[] nums) {
//         if(nums.length == 0 || nums == null){
//              return 0;
//         }
//         int left = 0;
//         int right = 1;
//         int lenArray = nums.length;
//         int index = 1;
//         while(right < lenArray){
//             if(nums[left] != nums[right]){
//                 nums[index++] = nums[right];
//                 left = right;

//             }
//             right++;
//         }
//         return index;
//     }
//     public static void main(String[] args) {
//         System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//     }
// }