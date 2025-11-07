import java.util.Arrays;

class SolutionMPOT {
    public long maxProduct(int[] nums) {
        long ans = 1l;
        int zeros = 0;
        for(int num : nums){
            if(num == 0) zeros++;
        }
        if(nums.length < 3) return 0;
        if(zeros>nums.length/2) return 0;

        int minRange = -100000;
        int maxRange = 100000;

        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE,l3 = Integer.MIN_VALUE;
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > l1){
                l3 = l2;
                l2 = l1;
                l1 = num;
            }else if( num > l2){
                l3 = l2;
                l2 = num;
            }else {
                l3 = num;
            }
            if(num<s1){
                s2 = s1;
                s1 = num;
            }else{
                s2 = num;
            }
        }
        System.out.println("MAX : ("+l1+")-("+l2+")-("+l3+")-");
        System.out.println("MIN :"+s1+"-"+s2+"-");

        int[] range = new int[]{minRange,maxRange};

        for(int r : range){
            int[] selected = new int[]{s1,s2,l3,l2,l1};
            for(int i = 0;i<5;i++){
                int temp = selected[i];
                selected[i] = r;
                ans = Math.max(ans,Math.max((1l*selected[4]*selected[3]*selected[2]),(1l*selected[0]*selected[1]*selected[4])));
                selected[i] = temp;
            }
        }

        return ans;
    }
}
public class MaxProductOfThree {
    public static void main(String[] args) {
        SolutionMPOT mp = new SolutionMPOT();
        System.out.println(mp.maxProduct(new int[]{-5,7,0}));
    }
}
