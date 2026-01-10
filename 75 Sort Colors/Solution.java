import java.util.Arrays;

class Solution {
    public static void sortColors(int[] nums) {
        int LP = 0; // Pointer for the next position of 0 (Red)
        int HP = nums.length - 1; // Pointer for the next position of 2 (Blue)
        int CP = 0; // Current pointer, scanning the array

        // Continue as long as the current pointer is within the unprocessed section
        // and the low pointer hasn't crossed the high pointer (ensuring 1s stay centered)
        while (CP <= HP && LP < HP) { // Loop condition adjusted for clarity/correctness
            if (nums[CP] == 0) { // If current element is 0 (Red)
                // Swap nums[CP] with nums[LP] to move 0 to the front
                nums[CP] = nums[LP];
                nums[LP] = 0;
                LP++; // Expand the 0s region
                CP++; // Move current pointer forward
            } else if (nums[CP] == 2) { // If current element is 2 (Blue)
                // Swap nums[CP] with nums[HP] to move 2 to the back
                nums[CP] = nums[HP];
                nums[HP] = 2;
                HP--; // Shrink the 2s region (from the end)
                // DO NOT increment CP; the swapped element from HP needs processing
            } else { // If nums[CP] is 1 (White)
                // It's in the correct potential middle section, just move on
                CP++;
            }
        }
        System.out.println(Arrays.toString(nums));
        // Handle the case where the loop ends with CP pointing to a 1 (which belongs)
        // or if LP catches up to HP (all 0s and 2s sorted, 1s remain)
    }
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2, 0, 1});
        
    }
}
