import java.util.*;

class SolutionTFKW {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String s: words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(int i = 0;i<k;i++){
            String max = findMaxKey(map);
            result.add(max);
        }
        return result;
    }

    private String findMaxKey(HashMap<String,Integer>map){
        String res = "";
        int max = 0;
        for(String s:map.keySet()){
            if(max<map.get(s)){
                max = map.get(s);
                res = s;
            }else if(max == map.get(s)){
                if(res.compareTo(s) > 0){
                    res = s;
                }
            }
        }
        map.put(res,0);
        return res;
    }

    static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
public class TopKFrequentWords {
    public static void main(String[] args) {
        SolutionTFKW topk = new SolutionTFKW();
        System.out.println(topk.topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"},4));
    }
}
