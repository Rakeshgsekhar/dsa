import java.util.Arrays;

class SolutionSL {
    public int secondLargestElement(int[] nums) {
        /*Arrays.sort(nums);
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]== nums[i+1]) continue;
            return nums[i];
        }
        return -1;
         */

        int max = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        for(int i = 0;i< nums.length;i++){
            max = Math.max(max,nums[i]);
            if(nums[i]!=max){
                maxSecond = Math.max(maxSecond,nums[i]);
            }
        }
        return maxSecond == Integer.MIN_VALUE?-1:maxSecond;
    }
}
public class SecondLargest {
    public static void main(String[] args) {
        SolutionSL sl = new SolutionSL();
        System.out.println(sl.secondLargestElement(new int[]{8, 8, 7, 6, 5}));
        System.out.println(sl.secondLargestElement(new int[]{10, 10, 10, 10, 10}));
        System.out.println(sl.secondLargestElement(new int[]{10, 10, 8, 8, 9}));
    }
}
