
class SolutionDAE {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int num : nums){
            if(num>max) max = num;
        }

        int [] dp = new int[max+1];

        for(int num : nums){
            dp[num]++;
        }
        int[] points = new int[max+1];
        points[0] = dp[0];
        points[1] = dp[1];
        int res = Integer.MIN_VALUE;

        for(int num : nums){
            points[num] = dp[num]*num;
        }

        for(int i = 2;i<=max;i++){
            points[i] = Math.max(points[i] +  points[i-2],points[i-1]);
        }


        for(int num : nums){
            res = Math.max(points[num],res);
        }

        return res;
    }
}
public class DeleteAndEarn {
    public static void main(String[] args) {
        SolutionDAE dae = new SolutionDAE();
        //dae.deleteAndEarn(new int[]{2,2,3,3,3,4});
        System.out.println(dae.deleteAndEarn(new int[]{17,15,21,61,51,69,42,48,97,88,2,35,29,72,49,76,54,72,30,94,20,72,21,65,80,31,11,81,14,43,39,83,45,29,94,76,81,1,97,48,71,88,44,34,53,62,25,1,81,79,58,24,99,15,46,63,10,11,50,19,91,56,44,56,86,35,76,22,52,27,52,60,84,15,38,80,99,1,38,86,79,85,43,16,61,68,41,8,67,29,63,64,70,91,24,79,14,62,11,41}));
       // System.out.println(dae.deleteAndEarn(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
