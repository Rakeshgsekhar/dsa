import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> (a[0]+a[1]) - (b[0] + b[1]));

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums1.length && i < k; i++) queue.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            if(curr[2]+1 >= nums2.length) continue;
            queue.offer(new int[]{curr[0], nums2[curr[2]+1], curr[2] + 1});
        }

        return res;
    }
}
