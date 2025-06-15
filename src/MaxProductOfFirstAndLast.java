import java.util.ArrayList;
import java.util.List;

class SolutionMPFL {
    static long maxProduct = Long.MIN_VALUE;
    public long maximumProduct(int[] nums, int m) {
        /*compute(0,m,nums,new ArrayList<>());
        return maxProduct;*/
        int n = nums.length;
        long maxProduct = Long.MIN_VALUE;

        long maxSoFar = Long.MIN_VALUE;
        long minSoFar = Long.MAX_VALUE;

        for (int j = m - 1; j < n; j++) {

            int i = j - (m - 1);

            if (i == 0) {
                maxSoFar = nums[0];
                minSoFar = nums[0];
            } else {
                maxSoFar = Math.max(maxSoFar, nums[i]);
                minSoFar = Math.min(minSoFar, nums[i]);
            }


            long product1 = (long)nums[j] * (long)maxSoFar;
            long product2 = (long)nums[j] * (long)minSoFar;

            maxProduct = Math.max(maxProduct, Math.max(product1, product2));
        }

        return maxProduct;
    }

    private void compute(int index,int m,int[] nums,List<Integer> curr){
        if(curr.size() == m){
            long prod = curr.get(0)*curr.get(curr.size()-1);
            maxProduct = Math.max(maxProduct,prod);
            return;
        }

        for(int i = index;i<= nums.length-(m-curr.size());i++){
            curr.add(nums[i]);
            compute(i+1,m,nums,curr);
            curr.remove(curr.size()-1);
        }
    }
}
public class MaxProductOfFirstAndLast {
    public static void main(String[] args) {
        SolutionMPFL mpfl = new SolutionMPFL();
        System.out.println(mpfl.maximumProduct(new int[]{-1,-9,2,3,-2,-3,1},1));
    }
}
