import java.util.Arrays;
import java.util.Comparator;

class SolutionMNOLG {
    public int minGroups(int[][] intervals) {
        int groups = 0;
        int n = intervals.length;
        int[] start_times = new int[n];
        int[] end_times = new int[n];
        for (int i = 0; i < n; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }

        Arrays.sort(start_times);
        Arrays.sort(end_times);

        int end_ptr = 0;

        for (int start : start_times) {
            if (start > end_times[end_ptr]) {
                end_ptr++;
            } else {
                groups++;
            }
        }

        return groups;
    }

    private boolean nonOverLapping(int[]g1, int[] g2){
        return g2[0]>g1[1] || g2[0]<g1[0];
    }
}
public class MinNonOverLapGroup {
    public static void main(String[] args) {
        SolutionMNOLG mnolg = new SolutionMNOLG();
        mnolg.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}});
        mnolg.minGroups(new int[][]{{1,3},{5,6},{8,10},{11,3}});
    }
}
