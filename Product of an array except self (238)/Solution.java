import java.util.Arrays;

class Solution{
    private static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int prefix = 1;
        for(int i = 0; i < length ; i++){
            ans[i] = prefix;
            prefix = prefix*nums[i];
        }
        int postfix = 1;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            ans[i] = ans[i] * postfix;
            postfix = postfix*nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));                //[24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));            //[0,0,9,0,0]
    }
}