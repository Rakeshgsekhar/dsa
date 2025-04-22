import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurance {
    public boolean uniqueOccurrences(int[] arr) {
        /*
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        Set<Integer> mapper = new HashSet<>();
        for(int n : map.values()){
            mapper.add(n);
        }

        return mapper.size()== map.keySet().size();
         */

        int[] occurance = new int[3000];
        for( int i : arr){
            occurance[i+1000]++;
        }
        int[] unique = new int[1001];
        for(int i = 0;i<arr.length;i++){
            int current  = occurance[arr[i]+1000];
            if(current>0){
                unique[current]++;
                if(unique[current]>1) return false;

                occurance[arr[i]+1000] -= current;
            }
        }
        return true;
    }
}
