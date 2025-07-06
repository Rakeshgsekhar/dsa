import java.util.ArrayList;
import java.util.List;

class SolutionMADJS {
    List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();
    public int minSwaps(int[] nums) {

        if(nums.length<2) return -1;
        if(isImpossible(nums)) return -1;
        if(isValid(nums)) return 0;
        int swaps = Integer.MAX_VALUE;
        if(even.size()>=odd.size()){
            swaps = Math.min(swaps,validate(even));
        }
        if(odd.size()>= even.size()){
            swaps = Math.min(swaps,validate(odd));
        }

        return swaps;
        //core

    }
    private int validate(List<Integer>nums){
        int swaps = 0;
        for(int i = 0;i<nums.size();i++){
            swaps+=Math.abs(nums.get(i)-2*i);
        }
        return swaps;
    }
    private boolean isValid(int[] nums){
        for(int i = 1;i<nums.length;i++){
            if((nums[i-1]%2==0 && nums[i]%2==0)|| (nums[i-1]%2!=0 && nums[i]%2!=0)) return false;
        }
        return true;
    }

    private boolean isImpossible(int[] nums){
        int evenCount = 0,oddCOunt =0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2==0) {
                even.add(i);
                evenCount++;
            }
            else {
                odd.add(i);
                oddCOunt++;
            }
        }
        return Math.abs(evenCount-oddCOunt)>1;
    }
}
public class MinAdjSwaps {
}
