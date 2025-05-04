import java.util.Arrays;

public class BSTemplate {
    /**
     * Template for binarySearch
     * @param array
     * @return
     */
    public int binarySearch(int[] array){
        int[] minMax = minAndMax(array);//Min and Max value from the array
        int left = minMax[0];
        int right = minMax[1];

        while(left<right){
            int mid = left+(right-left)/2;
            if(condition(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private int[] minAndMax(int [] nums){
        int min = nums[0];
        int max = nums[0];
        for(int i = 1;i<nums.length;i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return new int[]{min,max};
    }

    private static boolean condition(int value){
        if(value == 0 ) return true; //if condition passes return true;
        return false;
    }
}
