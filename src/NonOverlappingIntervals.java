import java.util.Arrays;

 class SolutionNNOI {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int max = intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0] < max){
                count++;
            }else{
                max = intervals[i][1];
            }
        }
        return count;
    }
}
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        SolutionNNOI nnoi = new SolutionNNOI();
        System.out.println(nnoi.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}
