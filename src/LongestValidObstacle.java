import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionLVOC {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        int[]dp = new int[n];
//        Arrays.fill(dp,-1);
        int len =0;
        for(int i = 0;i<n;i++){
            int index = searchIndex(dp,0,len-1,obstacles[i]);

            dp[index] = obstacles[i];
            if(index == len)len++;

            res[i] = index+1;
        }
        return res;
    }

    private int searchIndex(int[] dp, int left, int right, int target){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
   /* private int compute(int index,int prev,int[] obstacles){
        if(index<0) return 0;
        //if(index==0) return 1;
        if(prev==-1) return 1+compute(index-1,index,obstacles);
        if(obstacles[index]<=obstacles[prev]) return 1+compute(index-1,index,obstacles);
        else return compute(index-1,prev,obstacles);
    }*/
    private int compute(int index,int prev,int[] obstacles,int[]dp){
        if(index<0) return 0;
        //if(index==0) return 1;
        if(dp[index]!=-1) return dp[index];
        if(prev==-1) return dp[index]=1+compute(index-1,index,obstacles,dp);
        if(obstacles[index]<=obstacles[prev]) return dp[index]=1+compute(index-1,index,obstacles,dp);
        else return dp[index]=compute(index-1,prev,obstacles,dp);
    }

    private int compute(int index,int prev,int[] obstacles,Map<Integer,Integer>dp){
        if(index == 0) return 1;
        if(dp.containsKey(index)) return dp.get(index);
        int courseLength = 0;
        if(obstacles[index]<=obstacles[prev]){
            courseLength = 1+compute(index-1,index,obstacles,dp);
        }else {
            courseLength = compute(index-1,prev,obstacles,dp);
        }
        dp.put(index,courseLength);
        return courseLength;
        /*if(index<0) return 0;
        //if(index==0) return 1;
        if(dp[index]!=-1) return dp[index];
        if(prev==-1) return dp[index]=1+compute(index-1,index,obstacles,dp);
        if(obstacles[index]<=obstacles[prev]) return dp[index]=1+compute(index-1,index,obstacles,dp);
        else return dp[index]=compute(index-1,prev,obstacles,dp);*/
    }
}
public class LongestValidObstacle {
    public static void main(String[] args) {
        SolutionLVOC lvoc = new SolutionLVOC();
        lvoc.longestObstacleCourseAtEachPosition(new int[]{5,1,5,5,1,3,4,5,1,4});
    }
}
