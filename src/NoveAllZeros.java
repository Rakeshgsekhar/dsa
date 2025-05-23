
class SolutionMZB {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i =0;
        int j = 0;
        while(i<n){
            while(j<n){
                if(nums[j]!=0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
                j++;
            }
            break;
        }

        while(i<n){
            nums[i++] = 0;
        }
    }
}
public class NoveAllZeros {
    public static void main(String[] args) {
        SolutionMZB mzb = new SolutionMZB();
        int[] nums = new int[]{0,1,0,3,12};
        mzb.moveZeroes(nums);
        for(int num:nums)
            System.out.println(num);
    }
}
