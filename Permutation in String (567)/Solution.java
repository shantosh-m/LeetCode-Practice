import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusive("ab", "eidbaooo"));
        System.out.println(checkInclusive("ab", "eidboaoo"));
    }
    
    private static boolean checkInclusive(String s1, String s2){
        if(s1.length() > s2.length()){
            return false;
        }
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        int i = 0;

        for ( ; i < s1.length() ; i++){
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqS1,freqS2)){
            return true;
        }

        for ( ; i < s2.length() ; i++){
            freqS2[s2.charAt(i) - 'a']++;
            freqS2[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(freqS1, freqS2)){
                return true;
            }
        }
        return false;
    }
}
