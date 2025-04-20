public class MaxPossibleSize {

    /*
    100554. Make Array Non-decreasing
User Accepted:5263
User Tried:6486
Total Accepted:5404
Total Submissions:9217
Difficulty:Medium
You are given an integer array nums. In one operation, you can select a subarray and replace it with a single element equal to its maximum value.

Return the maximum possible size of the array after performing zero or more operations such that the resulting array is non-decreasing.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [4,2,5,3,5]

Output: 3

Explanation:

One way to achieve the maximum size is:

Replace subarray nums[1..2] = [2, 5] with 5 → [4, 5, 3, 5].
Replace subarray nums[2..3] = [3, 5] with 5 → [4, 5, 5].
The final array [4, 5, 5] is non-decreasing with size 3.

Example 2:

Input: nums = [1,2,3]

Output: 3

Explanation:

No operation is needed as the array [1,2,3] is already non-decreasing.



Constraints:

1 <= nums.length <= 2 * 105
1 <= nums[i] <= 2 * 105
     */
    public int maximumPossibleSize(int[] nums) {
        int count = 1;
        int n = nums.length;
        for(int i = 1 ;i<n;){
            if(nums[i] < nums[i-1]){
                int currentMax = nums[i-1];
                while(i<n){
                    if(nums[i]>=currentMax){
                        currentMax=nums[i];
                        count++;
                        i = i +1;

                    }else{
                        i++;
                    }
                }

            }else{
                count++;
            }
            i++;
        }
        return count;

    }
}
