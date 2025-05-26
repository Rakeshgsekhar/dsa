import java.util.HashMap;

class SolutionMSDP {
    public int minSubarray(int[] nums, int p) {
        int min = Integer.MAX_VALUE;
        int[] prefixSum = new int[nums.length];
        int n = nums.length;
        HashMap<Integer,Integer>prefixMod = new HashMap<>();
        prefixSum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }

        int totalSum = nums[n-1];
        int rem = totalSum%p;
        for(int i = 0;i<nums.length;i++){
            int currMod = prefixSum[i]%p;
            int targetMod = (currMod-rem+p)%p;
            if(prefixMod.containsKey(targetMod)){
                min = Math.min(min,i-prefixMod.get(targetMod));
            }
            prefixMod.put(currMod,i);
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
public class MakeSumDivisibkeByP {
    public static void main(String[] args) {
        SolutionMSDP msdp = new SolutionMSDP();
        System.out.println(msdp.minSubarray(new int[]{3,1,4,2},10));
        System.out.println(msdp.minSubarray(new int[]{6,3,5,2},9));
        System.out.println(msdp.minSubarray(new int[]{1,2,3},3));
    }
}
