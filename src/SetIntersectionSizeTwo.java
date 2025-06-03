import java.time.LocalTime;
import java.util.Arrays;

class SolutionSIST {
    public int intersectionSizeTwo(int[][] intervals) {
        int minSetCount = 2;
        Arrays.sort(intervals,(a,b)->(a[1] == b[1])? b[0]-a[0] : a[1]-b[1]); // wants to make sure large intervals are to the right

        int maxEnd = intervals[0][1];
        int maxSecond = intervals[0][1]-1;
        for(int i =1;i<intervals.length;i++){
            int currentEnd = intervals[i][1];
            int currentStart = intervals[i][0];
            if(maxEnd>= currentStart && maxSecond>=currentStart){
                continue;
            }

            if(maxEnd>=currentStart){
                maxSecond = maxEnd;
                maxEnd = currentEnd;
                minSetCount+=1; // added one element since there is overlap
            }else{
                maxEnd = currentEnd;
                maxSecond = currentEnd-1;
                minSetCount+=2; //adding both elements since other is no overlap
            }
        }

        return minSetCount;
    }
}
public class SetIntersectionSizeTwo {
}
