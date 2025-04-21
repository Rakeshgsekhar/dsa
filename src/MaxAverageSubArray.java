public class MaxAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0,right = 0;
        int n = nums.length;
        int sum = 0,maxSum = Integer.MIN_VALUE;
        while(right<n){
            sum+=nums[right];
            if(right-left+1 == k){
                maxSum = Math.max(maxSum,sum);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return (double)maxSum/k;

    }
}
