import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        //strs[i] contains any possible characters out of 256 valid ASCII characters.
        char seperator = (char)257;
        for(String str: strs){
            sb.append(str);
            sb.append(seperator);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> decoded_string = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        char seperator = (char)257;
        for(char c : str.toCharArray()){
            if(c != seperator){
                sb.append(c);
            }else{
                decoded_string.add(sb.toString());
                sb.setLength(0);
            }
        }
        return decoded_string;
    }

    public static void main(String[] args) {
        // Arrays.asList(..) --> Change the array to ArrayList
        String msg1 = encode(Arrays.asList(new String[]{"Hello","World"}));
        System.out.println(msg1);                                                                                    //Hello?World?
        // list.toArray() will convert the List into Object[] array
        // But to convert into String array we use list.toArray(new String[0])
        String[] decoded_string1 = decode(msg1).toArray(new String[0]);
        System.out.println(Arrays.toString(decoded_string1));                                                       //[Hello,World] 
        
        String msg2 = encode(Arrays.asList(new String[]{""}));  
        System.out.println(msg2);                                                                                   //?                
        System.out.println(decode(msg2));                                                                           //[]
    }
}
