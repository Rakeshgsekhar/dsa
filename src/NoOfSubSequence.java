import java.util.Arrays;

class SolutionNSGS {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0,right = n-1,ans = 0;
        int[] subSequenceCounter = new int[n];

        subSequenceCounter[0] = 1;
        for(int i = 1;i<n;i++){
            subSequenceCounter[i] = (subSequenceCounter[i-1]*2)%10000007;
        }
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans+=subSequenceCounter[right-left];
                ans%=10000007;
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
public class NoOfSubSequence {
}
