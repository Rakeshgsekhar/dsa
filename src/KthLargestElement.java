import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Max-Heap

        // for(int i : nums){
        //     pqMax.add(i);
        // }

        // for(int i = 0;i<k-1;i++){
        //     pqMax.poll();
        // }

        for(int i = 0;i<k;i++){
            pq.offer(nums[i]);
        }

        for(int i = k;i<nums.length;i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
