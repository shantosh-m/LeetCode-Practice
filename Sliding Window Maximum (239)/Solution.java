import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
class Solution {
    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0 || nums.length == 0){
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque <Integer> deque = new LinkedList<>();

        for (int i = 0 ; i < n ; i++){
            // Remove the indices which are out of the particular sliding window
            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            // Remove the indices from backwards which values are less than nums[i] 
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            // Add the indices atlast in the queue
            deque.offer(i);
            
            // Add to the output array if i greater than or equal to k-1
            if (i >= k-1){
                ans[i-k+1] = nums[deque.peek()];
            }

        }
        return ans;
        
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));    
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));    
    }
}