import java.util.HashMap;
import java.util.Map;

public class LexographicallySmallestSubString {
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        Map<Character,Integer> cnt = new HashMap<>();
        String R = "";
        for(int i = 0;i<s.length();i++){
            char a = s.charAt(i);
            cnt.put(a,cnt.getOrDefault(a,0)+1);
        }

        for(char i = 'a';i<='z';i++){
            if(cnt.getOrDefault(i,0)%2!=0){
                R+=i;
            }
        }

        int length = R.length();
        int j = 0;


        for(int i = length-1;i>=length/2;i--){
            cnt.put(R.charAt(i),cnt.get(R.charAt(i))-1);
            R.replace(R.charAt(i),R.charAt(j));
            cnt.put(R.charAt(j),cnt.get(R.charAt(j))+1);
            j++;
        }
        String first = "", middle = "", second = "";
        for (char i = 'a'; i <= 'z'; i++) {
            if (cnt.getOrDefault(i, 0) != 0) {
                if (cnt.get(i) % 2 == 0) {
                    j = 0;
                    while (j < cnt.get(i) / 2) {
                        first += i;
                        j++;
                    }
                }
                else {
                    j = 0;
                    while (j < (cnt.get(i) - 1) / 2) {
                        first += i;
                        j++;
                    }
                    middle += i;
                }
            }
        }
        second = new StringBuilder(first).reverse().toString();
        String resultant = first + middle + second;
        return resultant;
    }
}
