import java.util.ArrayDeque;
import java.util.Deque;

class SolutionCSC {
    public long continuousSubarrays(int[] nums) {
        long subArray = 0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int left = 0,right = 0,n=nums.length;
        for(;right<n;right++){
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()]<nums[right]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(right);

            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[right]){
                minQueue.pollLast();
            }
            minQueue.addLast(right);

            while(nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] >2){
                if(maxQueue.peekFirst() == left) maxQueue.pollFirst();
                if(minQueue.peekFirst() == left) minQueue.pollFirst();
                left++;
            }

            subArray+= (right-left+1);
        }

        return subArray;
    }
    private boolean isContinusSubArray(int i,int j,int[]nums,int[]max,int[]min){
        return Math.abs(nums[i]-nums[j]) <=2;
    }
}
public class ContinousSubArrayCond  {
    public static void main(String[] args) {
        SolutionCSC csc = new SolutionCSC();
        csc.continuousSubarrays(new int[]{5,4,2,4});
        csc.continuousSubarrays(new int[]{1,2,3});
    }
}
