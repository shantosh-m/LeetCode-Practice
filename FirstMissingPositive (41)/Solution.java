class Solution {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{100,4,200,1,2,3}));
        System.out.println(firstMissingPositive(new int[]{0,5,3,-1,200,-1,0,2,7,4}));
        System.out.println(firstMissingPositive(new int[]{100,99,4,200,1,2,3}));

    }
    static int firstMissingPositive(int[] nums) {
        boolean isOneThere = false;
        for (int n : nums){
            if (n == 1){
                isOneThere = true;
                break;
            }
        }

        if(!isOneThere){
            return 1;
        }

        for (int i = 0 ; i < nums.length ; i++){
            if ( nums[i] < 1 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        for (int i = 0 ; i < nums.length ; i++){
            int n = Math.abs(nums[i]);
            int index = n-1 ;
            if (nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}