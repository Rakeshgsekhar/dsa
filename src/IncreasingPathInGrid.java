import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionIPIG {
    public int countPaths(int[][] grid) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = grid.length,m = grid[0].length;
        int[]dx = {1,0,-1,0};
        int[]dy = {0,1,0,-1};
        for(int i = 0 ;i<n*m;i++) adjList.add(new ArrayList<>());

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int d=0;d<4;d++){
                    int ni = i+dx[d];
                    int nj = j+dy[d];
                    if(nj>=0 && ni>=0 && ni<n && nj<m && grid[i][j]<grid[ni][nj]){
                        adjList.get(m*(i+j)).add(m*(ni+nj));
                    }
                }
            }
        }
        return computePathTopo(adjList);
    }

    private int computePathTopo(ArrayList<ArrayList<Integer>> adjList){
        int mod = (int)1e9+7;
        int n = adjList.size();
        int count = 0;
        int[] inDegree = new int[n];
        int[] path = new int[n];
        Arrays.fill(path,1);

        for(int i = 0;i<n;i++){
            for(int neighbour:adjList.get(i)){
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            count = (count+path[node])%mod;
            for(int neighbour:adjList.get(node)){
                path[neighbour] = (path[neighbour]+path[node])%mod;
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }
        return count;
    }
}
public class IncreasingPathInGrid {
}
