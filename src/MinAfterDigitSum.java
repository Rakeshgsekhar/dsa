class SolutionMADS {
    public int minElement(int[] nums) {
        int min = nums[0];
        for(int num : nums){
            min = Math.min(min,compute(num));
        }
        return min;
    }
    private int compute(int n){
        int sum = 0;
        while(n>0){
            sum = (sum*10)+ n%10;
            n/=10;
        }
        return sum;
    }
}
public class MinAfterDigitSum {
}
