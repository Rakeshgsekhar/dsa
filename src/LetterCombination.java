import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public List<String> letterCombinations(String digits) {

        /**
         * String Array Method
         */
        String[] key = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",""};
        List<String>result = new ArrayList<>();
        if(digits.equals("")) return result;
        int digitIndex = digits.charAt(0)-'0';
        buildString(key,new String[0], digits,0,digitIndex,result);
        return result;
    }
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
            '2',
            "abc",
            '3',
            "def",
            '4',
            "ghi",
            '5',
            "jkl",
            '6',
            "mno",
            '7',
            "pqrs",
            '8',
            "tuv",
            '9',
            "wxyz"
    );
    private String phoneDigits;


    /**
     * Map Method
     * @param digits
     * @return
     */
    public List<String> letterCombinationsMapMethod(String digits) {
        if(digits.equals("")) return combinations;

        return combinations;
    }

    /**
     * Back Track Method with Map
     * @param index
     * @param path
     */
    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     * Backtqack method with String array
     * @param key
     * @param temp
     * @param digits
     * @param row
     * @param index
     * @param result
     */
    private void buildString(String[] key,String[] temp,String digits,int row,int index, List<String>result){
        if(row>=digits.length()){
            for(int i = 0; i<temp.length;i++){
                result.add(temp[i]);
            }
            return; // return
        }
        else{
            if(temp.length == 0 ){
                temp = new String[key[index-1].length()];
                for(int i = 0;i<key[index-1].length();i++)
                    temp[i] = String.valueOf(key[index-1].charAt(i));

                if(row+1 < digits.length()) {
                    index = digits.charAt(row+1)-'0';
                }
                buildString(key,temp,digits,row+1,index,result);
            }else{
                int l = temp.length * key[index-1].length();
                String [] temp2 = new String[l];
                int k = 0;
                for(int i = 0;i<temp.length;i++){
                    for(int j = 0;j<key[index-1].length();j++){
                        temp2[k++] = temp[i]+String.valueOf(key[index-1].charAt(j));
                    }
                }
                if(row+1 < digits.length()) index = digits.charAt(row+1)-'0';
                buildString(key,temp2,digits,row+1,index,result);
            }
        }
    }
}
