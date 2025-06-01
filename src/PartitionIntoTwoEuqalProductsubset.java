import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionPTEPS {
    public boolean checkEqualPartitions(int[] nums, long target) {
        /*
        long totalProduct = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i< nums.length;i++){
            map.put(nums[i],i);
        }
        for(int num : nums){
            totalProduct*=num;
        }
        if(totalProduct/2 != target) return false;

        for(int i = 0;i< nums.length;i++){
            int val = nums[i];
            long tar = target/val;

            if(map.containsKey((int)tar)){
                if(val*tar == target){
                    map.remove(val);
                    map.remove(tar);
                    totalProduct = totalProduct/(val*tar);
                    if(totalProduct == target) return true;
                    else return false;
                }
            }

        }
        return false;
        */

        int n = nums.length;
        if (n < 2) return false;

        Map<Long, Integer>[] factorMaps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            factorMaps[i] = buildMap(nums[i]);
        }

        Map<Long, Integer> targetFactors = buildMap(target);

        int total = 1 << n;
        for (int mask = 1; mask < total - 1; mask++) {
            Map<Integer, Integer> left = new HashMap<>();
            Map<Integer, Integer> right = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    addFactors(left, factorMaps[i]);
                } else {
                    addFactors(right, factorMaps[i]);
                }
            }

            if (left.equals(targetFactors) && right.equals(targetFactors)) {
                return true;
            }
        }

        return false;

    }
    private Map<Long,Integer> buildMap(long num){
        Map<Long, Integer> factors = new HashMap<>();
        for (int p = 2; p * p <= num; p++) {
            while (num % p == 0) {
                factors.put((long)p, factors.getOrDefault(p, 0) + 1);
                num /= p;
            }
        }
        if (num > 1) {
            factors.put(num, factors.getOrDefault(num, 0) + 1);
        }
        return factors;
    }

    private void addFactors(Map<Integer, Integer> acc, Map<Long, Integer> toAdd) {
        for (var entry : toAdd.entrySet()) {
            acc.put(Math.toIntExact(entry.getKey()), acc.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private  boolean isSubSetProdcut(int n, int[] nums,int product,int target){
        if(product == target) return true;
        if(n == 0) return false;
        return false;
    }
}
public class PartitionIntoTwoEuqalProductsubset {
}
