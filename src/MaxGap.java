import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionMG {
    public int maximumGap(int[] nums) {
       /* int maxGap = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE,high = 0,n=nums.length;
        List<List<Integer>> bucket = new ArrayList<>();
        for(int num : nums){
            low = Math.min(low,num);
            high = Math.max(high,num);
        }
        int bSize = Math.max(high-low/(n-1),1);
        for(int key = high-low/bSize;key>=0;key--){
            bucket.add(new ArrayList<>());
        }
        for(int num : nums){
            bucket.get((n-low)/bSize).add(num);
        }

        int currHigh = 0;
        for(List<Integer> li : bucket){
            if(li.isEmpty()) continue;
            int prevHigh = currHigh>0?currHigh:li.get(0);
            int currlow = li.get(0);
            for(int num : li){
                currHigh = Math.max(currHigh,num);
                currlow = Math.min(currlow,num);
            }

            maxGap = Math.max(maxGap,currlow-prevHigh);
        }
        return maxGap;*/

        int arrLen = nums.length;
        if(arrLen<2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n : nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        if(min == max) return 0; // No diff
        int bSize = (int) Math.ceil((double) (max-min)/arrLen-1);
        int bCount = ((max-min)/bSize)+1;
        int[]minBucket = new int[bCount]; //storing min to max
        int[]maxBucket = new int[bCount]; // storing max to min;

        for(int i = 0;i<bCount;i++){
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }

        for(int n : nums){
            int index = (n-min)/bSize;
            minBucket[index] = Math.min(n,minBucket[index]);
            maxBucket[index] = Math.max(n,maxBucket[index]);
        }

        int maxGap = 0;
        int prevHigh = max;

        for(int i = 0;i<bCount;i++){
            if(minBucket[i]!=Integer.MAX_VALUE){
                maxGap = Math.max(maxGap,minBucket[i]-prevHigh);
                prevHigh = maxBucket[i];
            }
        }

        return maxGap;

    }

}
public class MaxGap {
    public static void main(String[] args) {
        SolutionMG mg = new SolutionMG();
        mg.maximumGap(new int[]{9,6,3,1});
    }
}
