import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main (String[] args){
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(alienDictionary(words, order));
    }
    static boolean alienDictionary(String[] words, String order){
        Map <Character, Integer> orderMap = new HashMap<>();

        for (int i = 0 ; i < order.length() ; i++){
            orderMap.put(order.charAt(i), i);
        }

        for (int j = 0 ; j < words.length - 1 ; j++){

            for (int k = 0 ; k < words[j].length() ; k++){

                // catwoman , cat --> return False;
                if ( k >= words[j+1].length() ){
                    return false;
                }

                if (words[j].charAt(k) != words[j+1].charAt(k)){
                    int currentLetterVal =  orderMap.get(words[j].charAt(k));
                    int nextLetterVal =  orderMap.get(words[j+1].charAt(k));

                    if (currentLetterVal > nextLetterVal){
                        return false;
                    }else{
                        break;
                    }

                }
            }
        }

        return true;
    }
}
