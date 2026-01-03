import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length-2 && nums[i] <= 0 ; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                twoSum2(i, nums, result);
            }
        }
        return result;
    }
    private static void twoSum2(int i, int[] nums, List<List<Integer>> result){
        int left = i+1;
        int right = nums.length-1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum < 0){
                left++;
            }else if(sum > 0){
                right--;
            }else{
                result.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
            }
        }
    } 
    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{-4, -2, -2, 0, 2, 2, 4}));

    }    
}
