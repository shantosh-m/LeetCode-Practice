class Solution{
    public static void main(String[] args){
        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome("race a car"));
        System.out.println(validPalindrome(" "));
    }
    private static boolean validPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}