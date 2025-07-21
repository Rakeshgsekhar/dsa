import java.lang.reflect.Array;
import java.util.ArrayList;

class SolutionCCCOM {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]) {
                ArrayList<Integer> components = new ArrayList<>();
                detect(i, adj, visited,components);
                int nodes = components.size();
                int totalEdges = 0;
                for(int node:components){
                    totalEdges+=adj.get(node).size();
                }
                totalEdges/=2;
                if(totalEdges==nodes*(nodes-1)/2)ans++;
            }
        }

        return ans;
    }

    private void detect(int source,ArrayList<ArrayList<Integer>>adj,boolean[]visited,ArrayList<Integer> components){
        visited[source] = true;
        components.add(source);
        for(int neighbour:adj.get(source)){
            if(!visited[neighbour]){
                detect(neighbour,adj,visited,components);
            }
        }
        //pathVisited[source]=false
    }
}
public class CompleteConnectedComponenets {
    public static void main(String[] args) {
        SolutionCCCOM cc = new SolutionCCCOM();
        System.out.println(cc.countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4}}));
        System.out.println(cc.countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
    }
}
