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
        for(int i = 0;i<nums.length;i++){
            int prod = 1;
            for(int j = 0;j<nums.length;j++){

                if(i!=j){
                    prod*=nums[j];
                }
            }
            answer[i] = prod;
        }
        return answer;*/
    }
}
