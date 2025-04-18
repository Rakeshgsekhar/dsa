import java.util.Arrays;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        int length = words.length;
        StringBuilder ans = new StringBuilder();
        for(int i = length-1;i>=0;i--){
            ans.append(words[i]);
            if(i!=0)ans.append(" ");

        }
        return ans.toString().trim();
    }
}
