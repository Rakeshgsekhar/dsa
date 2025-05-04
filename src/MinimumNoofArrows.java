import java.util.Arrays;

public class MinimumNoofArrows {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] temp = new int[points.length][2];
        temp[0] = points[0];
        int k = 0;
        int left = 0,right = left+1;
        while(right<points.length){
            if(doOverlap(temp[k],points[right])){
                int start = Math.min(temp[k][0],points[right][0]);
                int end = Math.min(temp[k][1],points[right][1]);

                temp[k][0] = start;
                temp[k][1] = end;
                right++;
            }else{
                k++;
                temp[k] = points[right];
                right++;
            }
        }

        return k+1;

        /**
         * Faster method according to LC
         * if(points.length == 0) return 0;
         *         Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
         *         int arrow = 0;
         *         int arrows = points[0][1];
         *         for(int i = 1;i<points.length;i++){
         *             if(arrows < points[i][0]){
         *                 arrow++;
         *                 arrows = points[i][1];
         *             }
         *         }
         *         return arrow+1;
         */
    }
    private boolean doOverlap(int[] interval1,int[] interval2){
        if(interval2[0] <= interval1[1]) return true;
        return false;
    }
}
