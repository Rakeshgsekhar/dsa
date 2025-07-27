import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionFP1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[]garden = new int[n];
        Arrays.fill(garden,0);
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] path:paths){
            adjList.get(path[0]).add(path[1]);
        }

        int k = 1;
        for(int i=1;i<=n;i++){
            if(garden[i-1] == 0){
                isBipartite(garden,i,adjList);
            }
        }
        return garden;
    }

    private void isBipartite( int[] ans,int src,ArrayList<ArrayList<Integer>> graph){
       /* while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjList.get(node)){
                if(nodeColor[neighbour] == -1){
                    nodeColor[neighbour] = nodeColor[node] == 1? 0:1;
                    queue.add(neighbour);
                }else{
                    if(nodeColor[neighbour] == nodeColor[node]) return false;
                }
            }
        }

        return true;*/
        Queue<Integer> q = new LinkedList();

        q.add(src);
        ans[src] = 1;

        while(!q.isEmpty()){
            int u = q.poll();
            int color = ans[u];

            for(int v : graph.get(u)){
                if( ans[v] == 0 || ans[v] == color ) {
                    ans[v] = color == 4 ? 1 : color +1;
                    q.add(v);
                }
            }
        }
    }
}
public class FlowerPlaniting1042 {
}
