import java.util.ArrayList;
import java.util.List;
import java.util.*;

class SolutionSMS {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            List<int[]> cols = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] col = new int[k];
                for (int x = 0; x < k; x++) {
                    col[x] = grid[i + x][j];
                }
                cols.add(col);
            }

            TreeMap<Integer, Integer> windowFreq = new TreeMap<>();
            int minDiff = Integer.MAX_VALUE;

            for (int c = 0; c < k; c++) {
                for (int val : cols.get(c)) {
                    windowFreq.put(val, windowFreq.getOrDefault(val, 0) + 1);
                }
            }
            minDiff = computeMinDiff(windowFreq);
            ans[i][0] = minDiff;

            for (int j = 1; j <= n - k; j++) {
                for (int val : cols.get(j - 1)) {
                    int count = windowFreq.get(val);
                    if (count == 1) windowFreq.remove(val);
                    else windowFreq.put(val, count - 1);
                }
                for (int val : cols.get(j + k - 1)) {
                    windowFreq.put(val, windowFreq.getOrDefault(val, 0) + 1);
                }

                minDiff = computeMinDiff(windowFreq);
                ans[i][j] = minDiff;
            }
        }

        return ans;
    }
    private int computeMinDiff(TreeMap<Integer, Integer> freq) {
        if (freq.size() <= 1) return 0;

        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        for (Integer key : freq.keySet()) {
            if (prev != null) {
                minDiff = Math.min(minDiff, key - prev);
            }
            prev = key;
        }
        return minDiff;
    }
}
public class SlidingMatrixQN {
}
