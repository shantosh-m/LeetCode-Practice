import java.util.Map;
import java.util.HashMap;

class Solution{
    private static String minWindowSubstring(String s, String t){
        if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length()){
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            char c = t.charAt(i);
            int count = mapT.getOrDefault(c, 0);
            mapT.put(c, count+1);
        }
        int l = 0, r = 0;
        int required = mapT.size();
        int created = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> substringMapS = new HashMap<>(); 
        for ( ; r < s.length() ; r++){
            char c = s.charAt(r);
            int count = substringMapS.getOrDefault(c, 0);
            substringMapS.put(c, count+1);
            if(mapT.containsKey(c) && mapT.get(c).intValue() == substringMapS.get(c).intValue()){
                created++;
            }
            while(l<=r && required==created){
                if(ans[0] == -1 || ans[0]>=r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                c = s.charAt(l);
                substringMapS.put(c, substringMapS.get(c)-1);
                if(mapT.containsKey(c) && mapT.get(c).intValue() > substringMapS.get(c).intValue() ){
                    created--;
                }
                l++;
            }
        }
        if(ans[0]==-1){
            return "";
        }
        return s.substring(ans[1],ans[2]+1);
    }
    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC","ABC"));
        System.out.println(minWindowSubstring("a", "a"));
        System.out.println(minWindowSubstring("a","aa"));   
    }
}