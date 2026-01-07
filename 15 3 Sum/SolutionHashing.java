import java.util.*;

class SolutionHashing {

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Build frequency map for elements after i
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            }

            for (int j = i + 1; j < nums.length - 1; j++) {

                // Consume nums[j]
                freqMap.put(nums[j], freqMap.get(nums[j]) - 1);

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = -nums[i] - nums[j];

                // Enforce canonical order to avoid duplicates
                if (k < nums[j]) continue;

                if (freqMap.getOrDefault(k, 0) > 0) {
                    ansList.add(Arrays.asList(nums[i], nums[j], k));
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{-4, -2, -2, 0, 2, 2, 4}));
    }
}
