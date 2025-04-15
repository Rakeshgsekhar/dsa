public class RemoveDuplicatesFromSortedArray {
    /*
    26. Remove Duplicates from Sorted Array
    Solved
    Easy
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    Top Interview 150
     */

    public int removeDuplicates(int[] nums) {
        int result = 1;
        int end = nums.length-1;
        int i = 1;
        while(i<=end){
            if(nums[i] != nums[i-1]){
                nums[result++]=nums[i];
            }
            i++;

        }
        return result;
    }
}
