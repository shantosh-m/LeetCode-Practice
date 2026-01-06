class Solution {
    private static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] charCounts = new int[26];
        for( int i = 0 ; i < s.length() ; i++){
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i)-'a']--;
        }
        for(int n : charCounts){
            if(n != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));        //true
        System.out.println(isAnagram("rat", "car"));                //false
        
    }    
}
