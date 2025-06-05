import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class SolutionFirstUnique {
    private  Map<Integer, Integer> countMap = new HashMap<>();
    private Deque<Integer> queue = new ArrayDeque<>();

    public SolutionFirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }
    public int showFirstUnique() {

        while (!queue.isEmpty() && countMap.get(queue.peekFirst()) != 1) {
            queue.pollFirst();
        }
        return queue.isEmpty() ? -1 : queue.peekFirst();
    }
    public void add(int value) {
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        if (countMap.get(value) == 1) {
            queue.offer(value);
        }
    }
}

public class FirstUnique {
}
