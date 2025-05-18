
class SolutionRD{
    public int removeDuplicates(int[] nums) {
        int result = 2;
        int n = nums.length;
        for(int j = 2;j<n;j++){
            if(nums[j]!=nums[result-2]){
                nums[result++] = nums[j];
            }
        }
        return result;
    }
}
public class RemoveDuplicatesFromSortedArray {
    /*
    26. Remove Duplicates from Sorted Array
    Solved
    Easy
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    Top Interview 150
     */
    public static void main(String[] args) {
        SolutionRD rd = new SolutionRD();
        System.out.println(rd.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

}
