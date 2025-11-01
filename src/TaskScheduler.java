import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class PairMp{
    public char key;
    public int val;
    public PairMp(char key, int val) {
        this.key = key;
        this.val = val;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
class SolutionTSK {
    public int leastInterval(char[] tasks, int n) {
    /*// ============================================================
    // 🧠 Step 1: Restate the Problem
    // ============================================================
    **Problem:**
    (Write a short restatement in your own words)

    **Example:**
    Input: ...
    Output: number of CPU's

    **Constraints:**
    - same CPU can be scheduled only after N idle time.
    - 10^4

    **Edge Cases:**
    - ...
    - ...

    **Goal:**
    Describe what you need to compute or return.


    // ============================================================
    // 💡 Step 2: Brainstorm Possible Approaches
    // ============================================================

    **Approach 1: (e.g., Brute Force)**
    - Idea: ...
    | A | 0
    | B | 0

    n = 2

    currentpu -> 2
    A -> 1
    B -> 2
    id -> 3
    A -> 4
    B -> 5
    id -> 6
    A -> 7
    B -> 8


    return currentPu;

    - Time Complexity: O(...)
    - Space Complexity: O(...)

    **Approach 2: (e.g., Optimized / Hash Map / Two Pointers)**
    - Idea: ...
    - Time Complexity: O(...)
    - Space Complexity: O(...)

    **Choice:** Explain which approach you’ll implement and why.


    // ============================================================
    // 🧩 Step 3: Plan Your Algorithm (Pseudocode)
    // ============================================================
    - Step 1: ...
    - Step 2: ...
    - Step 3: ...
    - Step 4: Return result


    // ============================================================
    // 💻 Step 4: Implement the Algorithm
    // ============================================================
    */
        int cpu_intervals = 0;

        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> lastPos = new HashMap<>();
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0)+1);
            lastPos.put(task,0);
        }
        if(n == 1) return tasks.length;
        Comparator<PairMp> valueDescendingComparator = new Comparator<PairMp>() {
            @Override
            public int compare(PairMp entry1, PairMp entry2) {
                // For descending order, compare entry2's value to entry1's value
                return entry2.getVal()-(entry1.getVal());
            }
        };

        PriorityQueue<PairMp> pq = new PriorityQueue<>(valueDescendingComparator);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new PairMp(entry.getKey(),entry.getValue()));
        }

        while(!pq.isEmpty()){
            PairMp temp = pq.peek();
            if(temp.getVal() == 0){
                pq.poll();
            }else{
                if(cpu_intervals == 0){
                    cpu_intervals++;
                    lastPos.put(temp.getKey(),cpu_intervals);
                    pq.poll();
                    pq.offer(new PairMp(temp.getKey(), temp.getVal()-1));
                }else{
                    int lastp = lastPos.get(temp.getKey());
                    cpu_intervals++;
                    if (lastp == 0) {
                        lastPos.put(temp.getKey(),cpu_intervals);
                        pq.poll();
                        pq.offer(new PairMp(temp.getKey(), temp.getVal()-1));
                    }
                    else if(lastp+n+1 <= cpu_intervals){
                        lastPos.put(temp.getKey(),cpu_intervals);
                        pq.poll();
                        pq.offer(new PairMp(temp.getKey(), temp.getVal()-1));
                    }
                }
            }
        }

        return cpu_intervals;
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        SolutionTSK tsk = new SolutionTSK();
        System.out.println(tsk.leastInterval(new char[]{'A','A','A','B','B','B','C','C','D','D','F','F'},2));
//        System.out.println(tsk.leastInterval(new char[]{'A','C','A','B','D','B'},1));
//        System.out.println(tsk.leastInterval(new char[]{'A','A','A', 'B','B','B'},3));

    }
}
