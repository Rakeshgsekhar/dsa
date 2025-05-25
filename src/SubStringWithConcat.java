import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SolutionSSC {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        List<String> permutaions = permute(words);
        List<String> sm = Arrays.asList(words).stream().distinct().collect(Collectors.toList());
        if(sm.size() == 1){

        }
        HashMap<Character,List<String>> map = new HashMap<>();
        buildMap(map,permutaions);
        StringBuilder str = new StringBuilder(s);
        int n = words[0].length();
        int nm = n*words.length;
        if(map.size() == 1){
            if(map.getOrDefault(str.charAt(0),new ArrayList<>()).size() ==0) return res;
        }

        for(int i = 0;i<s.length();i++){
            char key = s.charAt(i);
            List<String> combinations = map.getOrDefault(key,new ArrayList<>());
            if(combinations.size()>0){
                if(i+nm-1<s.length()){
                    String sr = str.substring(i,i+nm);
                    if(combinations.contains(sr)){
                        res.add(i);
                        //i=i+nm;
                    }
                }
            }
        }
        return res;

        /**
         *  List<Integer> ans = new ArrayList<>();
         *
         *         if (words.length == 0 || s.length() == 0) {
         *             return ans;
         *         }
         *
         *         int wordSize = words[0].length();
         *         int wordCount = words.length;
         *         int N = s.length();
         *
         *         HashMap<String,Integer> originalCount = new HashMap<>();
         *         for(int i = 0; i<words.length; i++){
         *             originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
         *         }
         *
         *         for(int offset = 0; offset<wordSize; offset++){
         *             HashMap<String,Integer> currentCount = new HashMap<>();
         *             int start = offset;
         *             int count = 0;
         *             for(int end = offset; end + wordSize <= N; end += wordSize){
         *                 String currWord = s.substring(end, end + wordSize);
         *                 if(originalCount.containsKey(currWord)){
         *                     currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
         *                     count++;
         *
         *                     while(currentCount.get(currWord)>originalCount.get(currWord)){
         *                         String startWord = s.substring(start,start+wordSize);
         *                         currentCount.put(startWord, currentCount.get(startWord)-1);
         *                         start+=wordSize;
         *                         count--;
         *                     }
         *
         *                     if(count == wordCount){
         *                         ans.add(start);
         *                     }
         *
         *                 }
         *                 else{
         *                     count = 0;
         *                     start = end + wordSize;
         *                     currentCount.clear();
         *                 }
         *             }
         *
         *         }
         *         return ans;
         */
    }

    private void buildMap(HashMap<Character,List<String>> map,List<String> list){
        for(String comb:list){
            char key = comb.charAt(0);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(comb);
        }
    }
    /*
    private static List<String> getWordPermutations(String[] arr) {
        List<String> permutations = new ArrayList<>();
        permute(arr, 0, permutations);
        return permutations;
    }

    private static void permute(String[] arr, int currentIndex, List<String> permutations) {
        if (currentIndex == arr.length - 1) {
            permutations.add(String.join("", arr));
            return;
        }

        for (int i = currentIndex; i < arr.length; i++) {
            swap(arr, currentIndex, i);
            permute(arr, currentIndex + 1, permutations);
            swap(arr, currentIndex, i); // backtrack
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
*/
    public static List<String> permute(String[] arr) {
        List<String> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private static void backtrack(String[] arr, int start, List<String> result) {
        if (start == arr.length) {
            result.add(String.join("",arr.clone()));//Arrays.asList(arr.clone()));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            backtrack(arr, start + 1, result);
            swap(arr, start, i); // backtrack
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
public class SubStringWithConcat {
    public static void main(String[] args) {
        SolutionSSC ssc = new SolutionSSC();
        //System.out.println(ssc.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
        //System.out.println(ssc.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
        //System.out.println(ssc.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));
        //System.out.println(ssc.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
        System.out.println(ssc.findSubstring("fffffffffffffffffffffffffffffffff",new String[]{"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"}));
    }
}
