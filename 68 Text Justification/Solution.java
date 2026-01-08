import java.util.List;
import java.util.ArrayList;

class Solution {
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> stringList = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;

            // Find how many words fit in the current line
            // (current length + 1 space + next word length)
            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder(maxWidth);
            int numberOfWordsInLine = j - i;
            int remainingSpaces = maxWidth - lineLength;

            // SCENARIO 1: Last line OR Only one word in the line
            // Logic: Left-justified (words separated by 1 space, padding at the end)
            if (j == words.length || numberOfWordsInLine == 1) {
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                // Fill the rest of the line with spaces
                sb.append(" ".repeat(maxWidth - sb.length()));
            } 
            
            // SCENARIO 2: Fully Justified
            // Logic: Distribute spaces evenly between words
            else {
                // We already accounted for 1 space between words in 'lineLength'.
                // We need to distribute the 'remainingSpaces' into the existing gaps.
                int gaps = numberOfWordsInLine - 1;
                int evenSpacesToAdd = remainingSpaces / gaps;
                int extraSpaces = remainingSpaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    // Base single space + even extra spaces + 1 top-up if belongs to extra bucket
                    int spacesToApply = 1 + evenSpacesToAdd + (extraSpaces > 0 ? 1 : 0);
                    sb.append(" ".repeat(spacesToApply));
                    extraSpaces--;
                }
                sb.append(words[j - 1]); // Append the last word of the line
            }

            stringList.add(sb.toString());
            i = j; // Move index to the next unprocessed word
        }
        return stringList;
    }

    public static void main(String[] args) {
        // Test Case 1: Single word
        System.out.println(fullJustify(new String[]{"hii"}, 10)); 
        // Output: ["hii       "]
        
        // Test Case 2: Standard justification
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}