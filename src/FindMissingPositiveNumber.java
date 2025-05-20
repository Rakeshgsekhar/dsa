class SolutionFMPN { //     You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    /**
     * Cyclic Sort
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n){
            if(nums[i] != i+1){
                int correctPosition = nums[i] -1;
                if(correctPosition>=0 && correctPosition<n && nums[i] != nums[correctPosition]){
                    int temp = nums[correctPosition];
                    nums[correctPosition] = nums[i];
                    nums[i] = temp;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }

        for(int k = 0;k<n;k++){
            if(nums[k] != k+1){
                return k+1;
            }
        }
        return nums.length+1;
    }
}
public class FindMissingPositiveNumber {
    public static void main(String[] args) {
        SolutionFMPN mp = new SolutionFMPN();
        System.out.println(mp.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(mp.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(mp.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(mp.firstMissingPositive(new int[]{1,1}));

    }
}
