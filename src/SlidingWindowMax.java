import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SolutionWDMAX {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer>deque = new ArrayDeque<>();
        int nk = 0,n= nums.length;
        int index = 0;
        int[] maxSubArra = new int[n-k-1];
        for(int i = 0;i<k;i++){
           while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]){
               deque.removeLast();
           }
           deque.addLast(i);
        }
        maxSubArra[index++] = nums[deque.peekFirst()];
        for(int i = k;i<n;i++){
            if(i-k >= deque.peekFirst()){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            maxSubArra[index++] = nums[deque.peekFirst()];
        }


        return maxSubArra;
    }
}
public class SlidingWindowMax {
}
