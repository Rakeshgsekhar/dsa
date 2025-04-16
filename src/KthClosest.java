import java.util.Comparator;
import java.util.PriorityQueue;

public class KthClosest {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] - a[1]*a[1]));

        for(int[] i : points){
            maxHeap.offer(i);
            if(maxHeap.size()>k) maxHeap.poll();
        }

        int i = 0;
        while(!maxHeap.isEmpty()){
            result[i++] = maxHeap.poll();
        }

        return result;

        /*

         int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1]));

        for(int[] i : points){
            maxHeap.offer(i);
        }

        //int i = 0;
        for(int i = 0;i<k;i++){
            result[i] = maxHeap.poll();
        }

        return result;
         */
    }
}
