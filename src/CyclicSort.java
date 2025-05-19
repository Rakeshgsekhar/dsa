class SolutionCS{
    public int[] sort(int[] nums){
        int n = nums.length;
        int k = 0;
        while(k<n){
            if(k!=nums[k]-1){
                int temp = nums[nums[k]-1];
                nums[nums[k]-1] = nums[k];
                nums[k] = temp;
            }else{
                k++;
            }
        }
        return nums;
    }
}
public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,4};
        SolutionCS cs  = new SolutionCS();
        int[] res = cs.sort(nums);
        for(int n :res) System.out.println(n);
    }
}
