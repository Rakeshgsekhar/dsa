import java.util.HashMap;
import java.util.Map;

class SolutionVC {
    public int maxFreqSum(String s) {
        Map<Character,Integer> charFreq = new HashMap<>();

        for(char ch : s.toCharArray()){
            charFreq.put(ch,charFreq.getOrDefault(ch,0)+1);
        }
        int vowels = 0;
        int consonats = 0;
        for(char ch : charFreq.keySet()){
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ){
                vowels = Math.max(vowels,charFreq.get(ch));
            }else{
                consonats = Math.max(consonats,charFreq.get(ch));
            }
        }

        return vowels+consonats;

    }
}
public class MostFrequentVC {
}
