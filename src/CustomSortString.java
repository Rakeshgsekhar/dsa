import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class SolutionCSS {
    public String customSortString(String order, String s) {
        /*StringBuilder result = new StringBuilder();
        Map<Character,Integer> orderMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            orderMap.put(ch,orderMap.getOrDefault(ch,0)+1);
        }

        for(char ch:order.toCharArray()){
            if(orderMap.containsKey(ch)){
                result.append(String.valueOf(ch).repeat(Math.max(0,orderMap.get(ch))));
                orderMap.remove(ch);
            }
        }
        for(char ch : orderMap.keySet()){
            result.append(String.valueOf(ch).repeat(Math.max(0,orderMap.get(ch))));
        }


        return result.toString();

         */
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[(int)ch-'a']++;
        }

        StringBuilder res = new StringBuilder();
        for(char ch : order.toCharArray()){
            while(freq[(int) ch-'a']-->0){
                res.append(ch);
            }
        }

        for(int i =0;i<26;i++){
            while(freq[i]-->0){
                res.append((char)('a'+i));
            }
        }
        return res.toString();
    }
}
public class CustomSortString {
    public static void main(String[] args) {
        SolutionCSS css = new SolutionCSS();
        System.out.println(css.customSortString("cba","abcd"));
        System.out.println(css.customSortString("bcafg","abcd"));
    }
}
