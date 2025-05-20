
class SolutionFDC {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int k = 0;
        while(k<n){
            if(nums[k] != k+1){
                int correctIndex = nums[k]-1;
                if(nums[k] != nums[correctIndex]){
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[k];
                    nums[k] = temp;
                }else{
                    return nums[k];
                }
            }else{
                k++;
            }

        }
        return -1;
    }
}
public class FindDuplicate {
    public static void main(String[] args) {
        SolutionFDC fdc = new SolutionFDC();
        System.out.println(fdc.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(fdc.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(fdc.findDuplicate(new int[]{3,3,3,3,3}));
        System.out.println(fdc.findDuplicate(new int[]{8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));
    }
}
