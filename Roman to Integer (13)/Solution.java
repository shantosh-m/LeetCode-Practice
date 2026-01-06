import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map <String, Integer> romanValues = new HashMap<>();
    static{
        romanValues.put("I",  1);
        romanValues.put("V", 5);
        romanValues.put("X", 10);
        romanValues.put("L", 50);
        romanValues.put("C", 100);
        romanValues.put("D", 500);
        romanValues.put("M", 1000);
        romanValues.put("IV",  4);
        romanValues.put("IX", 9);
        romanValues.put("XL", 40);
        romanValues.put("XC", 90);
        romanValues.put("CD", 400);
        romanValues.put("CM", 900);
    }

    private static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(i < s.length()-1){
                String twoSymbols = s.substring(i, i+2);
                if(romanValues.containsKey(twoSymbols)){
                    sum += romanValues.get(twoSymbols);
                    i = i+1;
                    continue;
                }
            }
            String oneSymbol = s.substring(i, i+1);
            sum += romanValues.get(oneSymbol); 
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(romanToInt("III"));                      //3
        System.out.println(romanToInt("LVIII"));                    //58
        System.out.println(romanToInt("MCMXCIV"));                  //1994
    }
}
