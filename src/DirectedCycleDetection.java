import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SolutionDCD {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        for(int i = 0;i<V;i++){
            if(!visited[i])
                if(detect(i,adj,visited,pathVisited)) return true;
        }

        return false;
    }

    private boolean detect(int source,ArrayList<ArrayList<Integer>>adj,boolean[]visited,boolean[]pathVisited){
        visited[source] = true;
        pathVisited[source] = true;
        for(int neighbour:adj.get(source)){
            if(!visited[neighbour] && detect(neighbour,adj,visited,pathVisited)) return true;
            else if (pathVisited[neighbour]) return true;
        }
        pathVisited[source]=false;
        return false;
    }
}
public class DirectedCycleDetection {
    public static void main(String[] args) {
        SolutionDCD dcd = new SolutionDCD();
        System.out.println(dcd.isCyclic(4,new int[][]{{0,1},{0,2},{1,2},{2,3}}));
        System.out.println(dcd.isCyclic(4,new int[][]{{0,1},{0,2},{1,2},{2,0},{2,3}}));
    }
}
