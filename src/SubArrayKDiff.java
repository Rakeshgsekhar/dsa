import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionSDKK {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle empty or null array case
        }

        int n = nums.length;
        int result = 0; // Initialize result to the smallest possible integer

        // Core logic for solving the subarray problem goes here
        // This might involve Kadane's algorithm, sliding window, or other techniques

        for (int i = 0; i < n; i++) {
           // int currentSum = 0; // Reset current sum for each starting position

                Set<Integer> set = new HashSet<>();
                set.add(nums[i]);
                for(int l = i+1;l<n;l++){
                    set.add(nums[l]);
                    if(set.size() == k){
                        result++;
                    }
                }

        }
        return result;
    }
}
public class SubArrayKDiff {
    public static void main(String[] args) {
        SolutionSDKK sdkk = new SolutionSDKK();
        System.out.println(sdkk.subarraysWithKDistinct(new int[]{1,2,1,2,3},2));
        System.out.println(sdkk.subarraysWithKDistinct(new int[]{1,2,1,3,4},3));
    }
}
