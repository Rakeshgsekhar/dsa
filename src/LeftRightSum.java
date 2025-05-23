class SolutionLRS {
    public int[] leftRightDifference(int[] nums) {
        if(nums.length == 1){
            return new int[]{0};
        }
        int n = nums.length;
        int[] diffSum = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = 0;
        for(int i = 1;i<n;i++){
            leftSum[i] = leftSum[i-1]+nums[i-1];
        }
        rightSum[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            rightSum[i] = rightSum[i+1]+nums[i+1];
        }

        for(int i = 0;i<n;i++){
            diffSum[i] = Math.abs(leftSum[i]-rightSum[i]);
        }

        return diffSum;
    }
}
public class LeftRightSum {
    public static void main(String[] args) {
        SolutionLRS lrs = new SolutionLRS();
        int[] res = lrs.leftRightDifference(new int[]{10,4,8,3});

        for(int n : res)
            System.out.println(n);
    }
}
