import java.util.HashMap;
import java.util.Map;

class SolutionPAKG {
    public boolean partitionArray(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> counter = new HashMap<>();
        for(int num : nums){
            counter.put(num,counter.getOrDefault(num,0)+1);
        }
        if(k == len){
            for(int key : counter.keySet()){
                if(counter.get(key) > 1) return false;
            }

            return true;
        }
        if(len%k != 0) return false;
        int groups = len/k;
        for(int key : counter.keySet()){
            if(counter.get(key) > groups) return false;
        }
        return true;
    }
}
public class PartitionArraytoKDistinctGroop {
    public static void main(String[] args) {
        SolutionPAKG pk = new SolutionPAKG();
        System.out.println(pk.partitionArray(new int[]{35,39,65,101,101,54,1,111,8,107,96,90,91,54,115,36,46,76,111,39,29,122,4,113,101,73,125,39,124,33,82,39},16));
       /* System.out.println(pk.partitionArray(new int[]{3,5,2,2},2));
        System.out.println(pk.partitionArray(new int[]{74,103,74},3));
        System.out.println(pk.partitionArray(new int[]{14,40},2))*;*/

    }
}
