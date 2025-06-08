import java.util.ArrayDeque;
import java.util.Deque;

class SolutionSSALK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        int minLength = n+1;
        prefixSum[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }

        Deque<Integer> indexDeque = new ArrayDeque<>();
        indexDeque.addLast(0);
        for(int i = 1;i<n;i++){
            while(!indexDeque.isEmpty() && prefixSum[i] - nums[indexDeque.peekFirst()] >=k){
                minLength = Math.min(minLength,i-indexDeque.peek()); /// loop to compare and get the minlength
            }

            while(!indexDeque.isEmpty() && prefixSum[indexDeque.peekLast()]>=nums[i]){
                indexDeque.pollLast(); // loop to maintain order in the queue;
            }

            indexDeque.addLast(i);
        }

        return minLength == n+1 ? -1:minLength;
    }
}
public class ShortestSubArrayAtleastSumK {
}
