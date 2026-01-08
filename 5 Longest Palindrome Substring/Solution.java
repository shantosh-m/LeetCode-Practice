class Solution {
    private static String longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int[] indices = {0, 1};
        for(int i = 0 ; i < s.length() ; i++){
            checkPalindrome(s, i , i, indices);
            checkPalindrome(s, i , i+1, indices);
        }
        return s.substring(indices[0], indices[1]);
    }
    private static void checkPalindrome(String s, int left, int right, int[] indices){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int currentLength = indices[1] - indices[0];
        int length = right - left - 1;
        if(currentLength < length){
            indices[0] = left + 1;
            indices[1] = right;
        }
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));                  //bb
        System.out.println(longestPalindrome("babad"));                 //bab
    }
}
