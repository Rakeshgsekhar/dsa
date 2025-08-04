import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SolutionLCV {
    public int largestPathValue(String colors, int[][] edges) {
        int lcv = -1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        char[] nodeColors = colors.toCharArray();
        int n = colors.length();
        int[]inDegree = new int[n];
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[][]dp = new int[n][26];
        Queue<Integer>queue = new LinkedList<>();
//        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            int color = nodeColors[node]-'a';
            dp[node][color]++;
            lcv = Math.max(lcv,dp[node][color]);
            for(int neighbour: adjList.get(node)){
                /*for(int i = 0;i<26;i++){
                    dp[neighbour][i] = Math.max(dp[neighbour][i],dp[node][i]);
                }*/
                dp[neighbour][nodeColors[neighbour]-'a']++;
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }
        for(int degree : inDegree){
            if(degree>0) return -1;
        }

        return lcv;
    }

}
public class LargestColorValue {
    public static void main(String[] args) {
        SolutionLCV lcv = new SolutionLCV();
        lcv.largestPathValue("abaca",new int[][]{{0,1},{0,2},{2,3},{3,4}});
    }

}
