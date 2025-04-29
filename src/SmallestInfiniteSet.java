import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> pq ;
    int current = 1;
    Set<Integer> addedBack;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for(int i = 1 ;i<=1000;i++){
            pq.add(i);
        }
    }

    public int popSmallest() {
        if(!pq.isEmpty())
            return pq.poll();
        return current++;
    }

    public void addBack(int num) {
        if(!pq.contains(num)){
            pq.add(num);
        }
    }

    /*


     PriorityQueue<Integer> pq ;
    int current = 1;
    Set<Integer> addedBack;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        current = 1;
        addedBack = new HashSet<>();
    }

    public int popSmallest() {
        if(!pq.isEmpty()){
            int smallest = pq.poll();
            addedBack.remove(smallest);
            return smallest;
        }
        return current++;
    }

    public void addBack(int num) {
        if(num<current && !addedBack.contains(num)){
            pq.offer(num);
            addedBack.add(num);
        }
    }
     */
}
