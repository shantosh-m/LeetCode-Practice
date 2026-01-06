import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private static int[] twoSum(int[] nums, int target){
        Map <Integer, Integer> numMap = new HashMap<>();
        int complement = 0;
        for(int i = 0 ; i < nums.length ; i++){
            complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }numMap.put(nums[i], i);
        }
        return null;
    }   
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));               //[0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));                 //[1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));                    //[0, 1]
    } 
}
