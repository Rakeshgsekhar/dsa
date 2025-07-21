import java.util.*;

class SolutionUDCD {

    class edgePair{
        int edge;
        int parent;

        public edgePair(int edge, int parent) {
            this.edge = edge;
            this.parent = parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Incase if the graph is broken into multiple minor graphs we need to detect cycle in each
        for(int i = 0;i<V;i++){
            if(!visited[i] && detect(i,adj,visited)) return true;
        }
        return false;
    }

    private boolean detect(int source,ArrayList<ArrayList<Integer>>adj,boolean[]visited){
        visited[source] = true;
        Queue<edgePair>queue = new LinkedList<>();
        queue.offer(new edgePair(source,-1));
        while (!queue.isEmpty()){
            edgePair pair = queue.poll();
            int node = pair.edge;
            int parent = pair.parent;
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(new edgePair(neighbour,node));
                }else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
public class UnDirectedCycleDetection {
    public static void main(String[] args) {
        SolutionUDCD udcd = new SolutionUDCD();
        System.out.println(udcd.isCycle(4,new int[][]{{0,1},{0,2},{1,2},{2,3}}));

        System.out.println(udcd.isCycle(4,new int[][]{{0,1},{1,2},{2,3}}));
    }
}
