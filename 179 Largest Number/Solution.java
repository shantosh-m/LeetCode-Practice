import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static String largestNumber(int[] nums) {
        // 1. Convert int array to String array so we can sort properly
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 2. Custom Comparator
        // If s1 + s2 > s2 + s1, then s1 should come first.
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // We want descending order, so we compare order2 against order1
                return order2.compareTo(order1);
            }
        });

        // 3. Edge Case: If the largest number is "0", the result is just "0"
        // (e.g. input [0, 0] should return "0", not "00")
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 4. Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));                                    //"210"
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));                              //"9534330"
    }
}