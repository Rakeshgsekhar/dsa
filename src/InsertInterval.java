import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionIUV {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        boolean hasInserted = false;
        List<int[]> list = new ArrayList<>();
        while(i<n && intervals[i][1]< newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[2] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);

        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
public class InsertInterval {
    public static void main(String[] args) {
        SolutionIUV iv = new SolutionIUV();
        //iv.insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        int[][] result = iv.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{17,18});
        Arrays.asList(result).stream().forEach(a->{
            System.out.print("["+a[0]+","+a[1]+"]");
        });
    }
}
