class Solution {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = (right + left) / 2;
            
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < nums[right]){ // Right side is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1; 
                }
            } else { // Left side is sorted
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));                    //4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));                    //-1
        System.out.println(search(new int[]{1}, 0));                                //-1
    }
}