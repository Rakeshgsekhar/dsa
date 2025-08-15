class SolutionMXO {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = Integer.MIN_VALUE;
        /*for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j]!=1){
                        ans = Math.max(ans,j-i+1);
                        i=j;
                        break;
                    }
                }
            }
        }*/
        //int left = 0 ,right = 0;
        int count = 0;
        for(int n : nums){
            if(n == 0){
                count = 0;
            } else {
                count++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
public class MaxOnes {
    public static void main(String[] args) {
        SolutionMXO mo = new SolutionMXO();
        System.out.println(mo.findMaxConsecutiveOnes(new int[]{1,1,0,0,1,1,1}));
        System.out.println(mo.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
