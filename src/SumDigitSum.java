class SolutionSDS {
    public int smallestIndex(int[] nums) {
        int index = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(digitSum(nums[i]) == i){
                index = Math.min(index,i);
            }
        }
        return index==Integer.MAX_VALUE?-1:index;

    }
    int digitSum(int val){
        int sum = 0;
        int n = val;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        System.out.println(sum);
        return sum;
    }
}
public class SumDigitSum {
    public static void main(String[] args) {
        SolutionSDS sds = new SolutionSDS();
        System.out.println(sds.smallestIndex(new int[]{1,3,2}));
        System.out.println(sds.smallestIndex(new int[]{1,2,3}));
        System.out.println(sds.smallestIndex(new int[]{804,368,101,3}));
    }
}
