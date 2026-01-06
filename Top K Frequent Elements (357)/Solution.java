import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private static int[] topKFrequent(int[] nums, int k){
        if(nums.length <= k){
            return nums;
        }
        Map <Integer, Integer> numCount = new HashMap<>();
        for(int n : nums){
            numCount.put(n, numCount.getOrDefault(n, 0)+1);
        }
        Queue <Integer> minHeap = new PriorityQueue<>((a,b) -> numCount.get(a) - numCount.get(b)); 
        for(int key : numCount.keySet()){
            minHeap.add(key);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i] = minHeap.poll();
        }
        return ans;
    }    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));               //[2, 1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));                         //[1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)));       //[1,2]
    }
}
