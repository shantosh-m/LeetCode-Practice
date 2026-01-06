import java.util.HashSet;
import java.util.Set;;

class Solution {
    private static boolean containsNearbyDuplicate(int[] nums, int k){
        Set <Integer> numSet = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(numSet.contains(nums[i])){
                return true;
            }numSet.add(nums[i]);
            if(numSet.size()>k){
                numSet.remove(nums[i-k]);
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));         //true
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 2));         //true
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));     //false
    }
}
