import java.util.Arrays;

class Solution{
    private static void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;               //pointer for nums1 iteration from backwards
        int p2 = n-1;               //pointer for nums2 iteration from backwards
        int placer = m+n-1;
        //until p2 reaches 0 we have to do the comparison, if it reaches that means everything sorted. 
        // because already nums1 sorted, 
        // so we have to sort the numbers which are currently not in the array.
        while(p2 >= 0){
            //To do the comparison p1 should be greater than 0, otherwise we dont have to do the comparison
            //Why? We have reached start of the nums1, so we just paste the nums2 in the remaining slots
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[placer] = nums1[p1];
                p1--;
            }else{
                //If nums1 reaches its left side or nums2 value is greater than equal to nums1 value we will store the nums2 value in the nums1[placer]. 
                nums1[placer] = nums2[p2];
                p2--;
            }
            placer--;       //We have to iterate from backwards;
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
        merge(new int[]{1}, 1, new int[0], 0);
        merge(new int[]{0}, 0, new int[] {1}, 1);
    }
}