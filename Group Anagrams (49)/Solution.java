import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){ return new ArrayList<>(); }
        Map <String, List<String>> keyMap = new HashMap<>();
        int[] charCount = new int[26];
        for(String str : strs){
            Arrays.fill(charCount, 0);
            for(char c : str.toCharArray()){
                charCount[c-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0 ; i < 26 ; i++){
                sb.append(charCount[i]);
                sb.append("#");
            }
            String key = sb.toString();
            if(!keyMap.containsKey(key)){
                keyMap.put(key, new ArrayList<>());
            }
            keyMap.get(key).add(str);
        }
        return new ArrayList<>(keyMap.values());
    }
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));           //[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[]{""}));                                            //[[""]]
        System.out.println(groupAnagrams(new String[]{"a"}));                                            //[["a"]]

    }
}