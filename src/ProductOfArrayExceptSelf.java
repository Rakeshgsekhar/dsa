public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
         int product = 1;
         int zeroProduct = 1;
         boolean hasZero = false;
         int zeroCount = 0;
         for(int num : nums){
             if(num == 0){
                 hasZero = true;
                 zeroProduct+=num;
                 zeroCount++;
             }else{
                 product*=num;
                 zeroProduct*=num;
             }

         }
        int[] answer = new int[nums.length];
         if(zeroCount == nums.length) return nums;
         for(int i = 0;i<nums.length;i++){
             if(hasZero){
                 if(nums[i] != 0) answer[i] = 0;
                 else answer[i] = zeroProduct;
             }else{
                 answer[i] = product/nums[i];
             }
         }

         return answer;
/*
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for(int i = 1;i<nums.length;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }

        int rightPointer =1;
        for(int i = nums.length-1;i>=0;i--){
            answer[i]*=rightPointer;
            rightPointer*=nums[i];
        }

        return answer;

        */
    }
}
