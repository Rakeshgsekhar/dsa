import java.util.Arrays;
import java.util.Comparator;

class SolutionRCI {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = intervals.length;
        for(int i = 0;i<intervals.length;i++){
            for(int j = 0;j<intervals.length;j++){
                if(isCovered(intervals[i],intervals[j]) && i!=j){
                    count--;
                    break;
                }
            }
        }
        return count;
    }


    private boolean isCovered(int[] interval1,int[] interval2){
        if(interval1[0] >= interval2[0] && interval1[1] <= interval2[1] ) return true;
        return false;
    }
}
public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        SolutionRCI rci = new SolutionRCI();
        System.out.println(rci.removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(rci.removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
    }
}
