import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {-1, 0}, -1)));
    }
    
    // If there exists exactly one solution in the array
    // private static int[] twoSum(int[] numbers, int target){
    //     int left = 0;
    //     int right = numbers.length-1;
    //     while(target != numbers[left] + numbers[right]){
    //         if(target > numbers[left]+numbers[right]){
    //             left++;
    //         }
    //         if(target < numbers[left]+numbers[right]){
    //             right--;
    //         }
    //     }
    //     return new int[] {left+1, right+1};
    // }  

    // If there exists  one solution or not in the array, So null is also a solution
    private static int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            if(target > numbers[left]+numbers[right]){
                left++;
            }else if(target < numbers[left] + numbers[right]){
                right--;
            }else{
                return new int[] { left+1, right+1};
            }
        }
        return null;
    } 
}
