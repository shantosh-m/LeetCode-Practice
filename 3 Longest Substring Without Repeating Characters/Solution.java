import java.util.HashSet;
import java.util.Set;

class Solution{
    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("bbbbb"));
        System.out.println(longestSubstring("pwwkew"));        
    }
    
    private static int longestSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int right = 0, left = 0, ans = 0;
        Set <Character> substringChars = new HashSet<>();
        for ( ; right < s.length() ; right++){
            while (substringChars.contains(s.charAt(right))){
                substringChars.remove(s.charAt(left));
                left++;
            }
            substringChars.add(s.charAt(right));
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}