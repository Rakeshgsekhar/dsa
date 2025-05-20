import java.util.*;

class SolutionJN {
    int[]orderMap;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        orderMap = mapping;
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();

        for(int num:nums){
            int order = order(String.valueOf(num));
            if(!map.containsKey(order)) map.put(order,new ArrayList<>());
            map.getOrDefault(order,new ArrayList<>()).add(num);
        }

        int index = 0;
        int[] result = new int[nums.length];
        for(int key : map.keySet()){
            List<Integer> val = map.get(key);
            for(int i = 0;i<val.size();i++) {
                result[index++] = val.get(i);
            }
        }

        return result;
    }

    private int order(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            sb.append(orderMap[s.charAt(i)-'0']);
            i++;
        }
        int order = Integer.valueOf(sb.toString());
        return Integer.valueOf(sb.toString());
    }
}
public class SortJumbledNumbers {
    public static void main(String[] args) {
        SolutionJN jn = new SolutionJN();
        jn.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6},new int[]{991,338,38});
       // jn.sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9},new int[]{0,999999999});
        jn.sortJumbled(new int[]{8,2,9,5,3,7,1,0,6,4},new int[]{418,4191,916,948,629641556,574,111171937,28250,42775632,6086,85796326,696292542,186,67559,2167,366,854,2441,78176,621,4257,2250097,509847,7506,77,50,4135258,4036,59934,59474,3646243,9049356,85852,90298188,2448206,30401413,33190382,968234660,7973,668786,992777977,77,355766,221,246409664,216290476,45,87,836414,40952});
    }
}
