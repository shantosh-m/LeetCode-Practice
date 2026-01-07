import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<String> fizzBuzz(int n){
        List <String> ansList = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            if(i % 3 == 0 && i % 5 == 0){
                ansList.add("FizzBuzz");
            }else if(i % 3 == 0){
                ansList.add("Fizz");
            }else if(i % 5 == 0){
                ansList.add("Buzz");
            }else{
                ansList.add(i + "");
            }
        }
        return ansList;
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));            //["1","2","Fizz"]
        System.out.println(fizzBuzz(5));            //["1","2","Fizz","4","Buzz"]
        System.out.println(fizzBuzz(15));           //["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]        
    }    
}
