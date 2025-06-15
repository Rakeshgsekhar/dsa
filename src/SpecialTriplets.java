import java.util.HashMap;
import java.util.Map;

class SolutionSTP {
    public int specialTriplets(int[] nums) {
        /*int MOD = 1_000_000_009;
        int count = 0,n = nums.length;
        if(nums.length<3) return count;
        int t1 = 0;
        while(t1<n-2){
            int t2 = t1+1,t3 = t2+1;
            while(t3<n){
                if(nums[t3] == nums[t1] && nums[t2] == nums[t1]/2){
                    count++;
                    count%=MOD;
                    t3++;
                    t2++;
                }
                if(nums[t2]<=nums[t3]) t3++;
                else t2++;
            }
            t1++;
        }
        return count;*/
        int MOD = 1_000_000_007;
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer> leftFreq = new HashMap<>();
        Map<Integer, Integer> rightFreq = new HashMap<>();
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            int mid = nums[j];
            rightFreq.put(mid, rightFreq.get(mid) - 1);

            int doubleVal = mid * 2;
            int leftCount = leftFreq.getOrDefault(doubleVal, 0);
            int rightCount = rightFreq.getOrDefault(doubleVal, 0);
            result = (result + 1L * leftCount * rightCount) % MOD;
            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0) + 1);
        }

        return (int) result;
    }
}
public class SpecialTriplets {
    public static void main(String[] args) {
        SolutionSTP stp =new SolutionSTP();
        System.out.println(stp.specialTriplets(new int[]{8,4,2,8,4}));
        System.out.println(stp.specialTriplets(new int[]{0,1,0,0}));
    }
}
