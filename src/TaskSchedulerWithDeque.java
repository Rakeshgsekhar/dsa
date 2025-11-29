import java.util.*;
public class TaskSchedulerWithDeque {
    /**
     * Finds the minimum time required to execute all tasks using a Deque
     * for the two-pointer greedy pairing.
     *
     * @param A The array of memory requirements for each task.
     * @param T The array of task types for each task.
     * @param maxMemory The maximum memory limit for two paired tasks.
     * @return The minimum time required to execute all tasks.
     */
    public static int minTime(int[] A, String[] T, int maxMemory) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // 1. Group tasks by type
        Map<String, List<Integer>> tasksByType = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            tasksByType.computeIfAbsent(T[i], k -> new ArrayList<>()).add(A[i]);
        }

        int totalMinTime = 0;

        // 2. Process each task type independently
        for (List<Integer> memoryList : tasksByType.values()) {

            // Sort the memory requirements. This is REQUIRED for the greedy strategy.
            Collections.sort(memoryList);

            // Load the sorted list into a Deque for efficient removal from both ends.
            Deque<Integer> taskDeque = new LinkedList<>(memoryList);

            int timeForType = 0;

            // Greedy pairing using the Deque
            // Loop runs as long as there are tasks to process.
            while (!taskDeque.isEmpty()) {

                // One time unit is consumed for the tasks processed in this iteration.
                timeForType++;

                if (taskDeque.size() == 1) {
                    // Only one task left, execute it alone, and we're done with this type.
                    taskDeque.removeFirst();
                    break;
                }

                // Smallest remaining task is at the front.
                int smallest = taskDeque.peekFirst();
                // Largest remaining task is at the back.
                int largest = taskDeque.peekLast();

                // Check if the smallest and largest can be paired
                if (smallest + largest <= maxMemory) {
                    // Case 1: Paired tasks
                    // Remove both (Smallest and Largest) for 1 time unit.
                    taskDeque.removeFirst(); // Removes smallest
                    taskDeque.removeLast();  // Removes largest
                } else {
                    // Case 2: Largest task executes alone
                    // The largest task is too big to pair with the smallest.
                    // It must execute alone. Remove the largest task only.
                    taskDeque.removeLast();
                }
            }

            totalMinTime += timeForType;
        }

        return totalMinTime;
    }

    // --- Example Usage ---
    public static void main(String[] args) {
        int[] A = {10, 5, 20, 50, 10};
        String[] T = {"A", "B", "A", "B", "A"};
        int maxMemory = 30;

        int minTimeResult = minTime(A, T, maxMemory);
        System.out.println("--- Example 1 ---");
        System.out.println("A=" + Arrays.toString(A) + ", T=" + Arrays.toString(T) + ", maxMemory=" + maxMemory);
        System.out.println("Minimum Time Required: " + minTimeResult); // Expected: 4

        System.out.println("--- Example 2 ---");
        int[] A2 = {1, 2, 3, 4, 5, 6};
        String[] T2 = {"X", "Y", "X", "Y", "X", "Y"};
        int maxMemory2 = 5;

        int minTimeResult2 = minTime(A2, T2, maxMemory2);
        System.out.println("A=" + Arrays.toString(A2) + ", T=" + Arrays.toString(T2) + ", maxMemory=" + maxMemory2);
        System.out.println("Minimum Time Required: " + minTimeResult2);
    }
}
