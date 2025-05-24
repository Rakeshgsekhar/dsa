class SolutionMSSB {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sumNum = 0;
        int i = 0;
        int min = Integer.MAX_VALUE;
        int left = 0,right = n;
        while(left<right){
            sumNum+=nums[left];
            while(sumNum>=target){
                if(sumNum >= target){
                    min = Math.min(min,left-i+1);
                }
                sumNum-=nums[i];
                i++;
            }
            left++;

        }
        return min == Integer.MAX_VALUE?0:min;//hasTarget(target,sumNum,left)?left:min;


    }

    private int hasTarget(int target,int[]sums,int x){
        for(int i = 0;i<sums.length && x*i+1<sums.length;i++){
            int xind = x*i+1;
            if((sums[xind]-sums[i]) >= target){
                return (sums[xind]-sums[i]);
            }
        }
        return -1;
    }
}
public class findMinSizeSubArray {
    public static void main(String[] args) {
        SolutionMSSB mssb = new SolutionMSSB();
        System.out.println(mssb.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(mssb.minSubArrayLen(4,new int[]{1,4,4}));
        System.out.println(mssb.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(mssb.minSubArrayLen(11,new int[]{1,2,3,4,5}));
        System.out.println(mssb.minSubArrayLen(80,new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8}));
    }
}
