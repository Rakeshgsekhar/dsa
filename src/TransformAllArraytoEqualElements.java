class SolutionTAAEE {
    public boolean canMakeEqual(int[] nums, int k) {
        return (canMakeAllToTarget(nums,k,1)<=k) || (canMakeAllToTarget(nums,k,-1)<=k);

    }
    private int canMakeAllToTarget(int[] nums, int k, int target){
        int n = nums.length;
        int[] flip = new int[n];
        int flips = 0;
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            flips ^= flip[i];
            int val = nums[i] * (flips % 2 == 0 ? 1 : -1);
            if (val != target) {
                if (i + 1 >= n) return Integer.MAX_VALUE;
                flip[i] = 1;
                flips ^= 1;
                res++;
            }
        }


        int last = nums[n - 1] * (flips % 2 == 0 ? 1 : -1);
        if (last != target) return Integer.MAX_VALUE;

        return res;
    }
}
public class TransformAllArraytoEqualElements {
    public static void main(String[] args) {
        SolutionTAAEE taaee = new SolutionTAAEE();
        System.out.println(taaee.canMakeEqual(new int[]{1,-1,1},2));
        System.out.println();
    }
}
