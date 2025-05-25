import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class SolutionGAN {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = getKey(s);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.getOrDefault(key,new ArrayList<>()));
        }

        return result;

    }
    private String getKey(String s){
        char ch [] = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
public class GroupAnagram {
}
