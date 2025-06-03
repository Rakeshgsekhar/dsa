import Entity.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SolutionMR {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->a.start-b.start);

        for(int i = 1;i<intervals.size();i++){
            if(intervals.get(i).start<= intervals.get(i-1).end) return false;
        }
        return true;
    }
    public int minMeetingRooms(List<Interval> intervals) {
        int days = 0;
        int[] start = new int[intervals.size()];
        int[]end = new int[intervals.size()];
        int k = 0;
        for(Interval i : intervals){
            start[k] = i.start;
            end[k] = i.end;
            k++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0,e =0,count = 0;
        while(s<e){
            if(start[s]<end[e]){
                s++;
                count++;
            }else {
                e++;
                count--;
            }
            days = Math.max(days,count);
        }
        return days;
    }
}
public class MeetingRooms {

}
