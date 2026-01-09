import java.util.Arrays;

class Solution{
    private static int[] searchRange(int[] nums, int target){
        int firstPosition = findBound(nums, target, true);
        if(firstPosition == -1){
            return new int[]{-1, -1};
        }
        int secondPosition = findBound(nums, target, false);
        return new int[]{firstPosition, secondPosition};
    }
    private static int findBound(int[] nums, int target, boolean isFirst){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int middle = (left + right)/2;
            if(target < nums[middle]){
                right = middle-1;
            }else if(target > nums[middle]){
                left = middle+1;
            }else{
                //Finding first position, for that traversing to the front
                if(isFirst){
                    if(middle == left || target != nums[middle-1]){
                        return middle;
                    }else{
                        right = middle-1;
                    }
                }else{
                    //Finding last position, for that traversing to the back
                    if(middle == right || target != nums[middle+1]){
                        return middle;
                    }else{
                        left = middle+1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));           //[3,4]
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));           //[-1,-1] 
        System.out.println(Arrays.toString(searchRange(new int[]{}, 6)));                       //[-1,-1]
    }
}