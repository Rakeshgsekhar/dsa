import java.util.*;
import java.util.stream.Collectors;

class SolutionMCMAE {
    class Pair{
        int value;
        int weight;

        public Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        Long minCost = 0L;
        Long sum = 0L;

        List<Pair> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new Pair(nums[i],cost[i]));
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.value,o2.value);
            }
        });

        System.out.println(list);

        for(int k = 0;k<n;k++){
            sum+= list.get(k).weight;
        }

        int i = 0;
        Long median = 0L,total = 0L;
        while(total<(sum+1)/2 && i<nums.length){
            total+=list.get(i).weight;
            median=(long)list.get(i).value;
            i++;
        }

        for(int x = 0;x<n;++x){
            minCost+= 1L*(Math.abs(nums[x]-median))*cost[x];
        }


        System.out.println(minCost);

        return minCost;
    }
    /**
     *
     * Binary Method
     * private long findCost(int[] nums, int[] cost, long x) {
     *         long res = 0L;
     *         for (int i = 0; i < nums.length; i++){
     *             res += Math.abs(nums[i] - x) * cost[i];
     *         }
     *         return res;
     *     }
     *     public long minCost(int[] nums, int[] cost) {
     *         long left = 1L;
     *         long right = 1000000L;
     *         for (int num : nums) {
     *             left = Math.min(num, left);
     *             right = Math.max(num, right);
     *         }
     *         long ans = findCost(nums, cost, 1);
     *         while (left < right) {
     *             long mid = (left + right) / 2;
     *             long y1 = findCost(nums, cost, mid);
     *             long y2 = findCost(nums, cost, mid + 1);
     *             ans = Math.min(y1, y2);
     *             if (y1 < y2){
     *                 right = mid;
     *             }
     *             else{
     *                 left = mid + 1;
     *             }
     *         }
     *         return ans;
     *     }
     */
}
public class MinCostToMakeArrayEquals {
    public static void main(String[] args) {
        SolutionMCMAE sol = new SolutionMCMAE();

        sol.minCost(new int[]{735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518},new int[]{724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614});
        sol.minCost(new int[]{1,1,1,1},new int[]{2,3,1,14});
        sol.minCost(new int[]{1,3,5,2},new int[]{2,3,1,14});
    }
}
