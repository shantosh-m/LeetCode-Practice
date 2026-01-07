class Solution {
    public static void main(String[] args) {
        System.out.println(characterReplacement("PXQYXXA", 2));
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
    private static int characterReplacement(String s, int k){
        int[] occurence = new int[26];
        int left = 0, right = 0;
        int maxOccurence = 0;
        int ans = 0;

        for (; right < s.length() ; right++){
            maxOccurence = Math.max(maxOccurence, ++occurence[s.charAt(right)-'A']);
            if (right - left + 1 - maxOccurence > k){
                occurence[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
