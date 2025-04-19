public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int numPointer = 0;
        if(nums.length == 1) return;
        while(numPointer<nums.length){
            if(nums[numPointer] !=0 ){
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[numPointer];
                nums[numPointer] = temp;
                zeroPointer++;
            }
            numPointer++;
        }
        /*
        for(int zero = 0;zero<nums.length;zero++){
            if(nums[zero] != 0){
                int temp = nums[zero];
                nums[zero] = nums[numPointer];
                nums[numPointer] = temp;
                numPointer++;
            }

        }
        */

    }
}
