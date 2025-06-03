import java.util.Arrays;

class SolutionMTCTS {
    public int findMinimumTime(int[][] tasks) { //[[2,3,1],[4,5,1],[1,5,2]]
        int[] seconds = new int[2001];
        int timeRequried = 0;
        Arrays.sort(tasks,(a,b)->a[1]-b[1]);

        for(int[] task : tasks){
            int duration = task[2];
            int []onDurations = getOnDurationsInRange(task[0],task[1],seconds);
            if(onDurations[0] >= duration) continue;

            int remaningDuration = duration-onDurations[0];
            int index = task[1];

            while(remaningDuration>0){
                if(seconds[index] != 1) {
                    seconds[index] = 1;
                    remaningDuration--;
                }
                index--;
            }
        }


        for(int second : seconds){
            if(second == 1){
                timeRequried++;
            }
        }
        return timeRequried;
    }

    private int[] getOnDurationsInRange(int start,int end,int[] seconds){
        int lastSetIndex = end;
        int duration = 0;
        for(int i = end;i>=start;i--){
            if(seconds[i] == 1){
                duration++;
                lastSetIndex = i;
            }
        }
        return new int[]{duration,lastSetIndex};
    }
}
public class MinTimeToCompleteTask {
    public static void main(String[] args) {
        SolutionMTCTS mtcts = new SolutionMTCTS();
        System.out.println(mtcts.findMinimumTime(new int[][]{{2,3,1},{4,5,1},{1,5,2}}));
        System.out.println(mtcts.findMinimumTime(new int[][]{{1,3,2},{2,5,3},{5,6,2}}));
        System.out.println(mtcts.findMinimumTime(new int[][]{{10,16,3},{10,20,5},{1,12,4},{8,11,2}}));
        System.out.println(mtcts.findMinimumTime(new int[][]{{68,129,2},{58,86,9},{112,142,10},{106,108,1},{48,48,1},{116,143,2},{28,43,5},{1,1,1},{75,83,3},{104,136,10},{11,11,1},{60,63,1},{73,111,8},{57,57,1},{117,119,3},{25,38,2},{20,21,1},{78,80,2},{17,17,1},{28,28,1},{77,117,3},{76,109,4},{61,61,1},{84,92,5},{18,41,4},{47,55,9},{74,132,6},{53,87,3},{102,131,7},{26,26,1},{66,68,3},{59,73,1},{22,30,9},{9,13,2},{31,35,2},{90,91,2},{72,72,1},{62,84,8},{105,106,2},{3,3,1},{32,32,1},{99,103,4},{45,52,4},{108,116,3},{91,123,8},{89,114,4},{94,130,7},{103,104,2},{14,17,4},{63,66,4},{98,112,7},{101,140,9},{58,58,1},{109,145,1},{8,15,8},{4,16,5},{115,141,1},{40,50,4},{118,118,1},{81,120,7}}));
    }
}
