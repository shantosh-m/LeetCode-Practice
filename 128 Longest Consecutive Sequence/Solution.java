import java.util.HashSet;
import java.util.Set;;

public class Solution {
    public static void main (String[] args){
        // int[] numArr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        // int[] numArr = {100, 4, 200, 1, 3, 2};
        int[] numArr = {1, 0, 1, 2};
        System.out.println(longestConsecutiveSeq(numArr));

    }
    static int longestConsecutiveSeq(int[] arr){
        if (arr.length == 0){
            return 0;
        }
        Set <Integer> numSet = new HashSet<>();
        for (int n : arr){
            numSet.add(n);
        }
        int LCS = 1;
        for (int num : numSet){
            if (numSet.contains(num-1)){
                continue;
            }else{
                int seqNo = 1;
                while (numSet.contains(num+1)) {
                    seqNo++;
                    num++;
                }
                LCS = Math.max(seqNo, LCS);
            }
        }
        return LCS;
    }
}
