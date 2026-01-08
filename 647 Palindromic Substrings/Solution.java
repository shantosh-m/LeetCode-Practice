class Solution {
    private static int countSubstrings(String s){
        int ans = 0;
        for(int i = 0; i < s.length() ; i++){
            //odd palindrome
            ans += checkPalindrome(s, i, i);
            //even palindrome
            ans += checkPalindrome(s, i, i+1);
        }
        return ans;
    }
    private static int checkPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }    
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));                 //3
        System.out.println(countSubstrings("aaa"));                 //6
    }
}
