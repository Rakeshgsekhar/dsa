class SolutionMPSA {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;


        for(int i =0;i<nums.length;i++){
            int[]maxPro = new int[1];
            maxProduct(i,maxPro,1,nums);
            max = Math.max(max,maxPro[0]);
        }

        return max;
    }

    private void maxProduct(int index,int[] maxPro,int prod, int[] nums){
        if(index>= nums.length) return;

        maxPro[0] = Math.max(maxPro[0], prod*nums[index]);
        maxProduct(index+1,maxPro,prod*nums[index],nums);
        prod=nums[index]!=0?prod/nums[index]:0;
        maxProduct(index+1,maxPro,prod,nums);
    }
}
public class MaxProductSubArray {
    public static void main(String[] args) {
        SolutionMPSA b = new SolutionMPSA();
        System.out.println(b.maxProduct(new int[]{2,3,-2,4}));

        System.out.println(b.maxProduct(new int[]{-1,4,-4,5,-2,-1,-1,-2,-3}));
    }
}
