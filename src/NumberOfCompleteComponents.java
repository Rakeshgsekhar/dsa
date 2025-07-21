import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SolutionCCOM {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[]count = new int[]{0};
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
           // adj.get(v).add(u);
        }
        for(int i = 0;i<n;i++) {
            if(!visited[i])
                detectCompleteComponents(n, adj, visited, count,i);
        }
        return count[0];
    }

    private void detectCompleteComponents(int n,ArrayList<ArrayList<Integer>>adj, boolean[]visited,int[]count,int node){
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            int nd = queue.poll();
            visited[nd] = true;
            if (adj.get(nd).size() == 0) {
                count[0]++;
                return;
            }
            for (int neighbour : adj.get(nd)) {
                if (!visited[neighbour]) queue.offer(neighbour);
                else {
                    count[0]++;
                    return;
                }

            }
        }
    }
}
public class NumberOfCompleteComponents {
    public static void main(String[] args) {
        SolutionCCOM cc = new SolutionCCOM();
       // System.out.println(cc.countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4}}));
        System.out.println(cc.countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
    }
}
