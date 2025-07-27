import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionIGBP {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] nodeColor = new int[n];
        Arrays.fill(nodeColor,-1);

        ArrayList<ArrayList<Integer>>adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            adjList.get(i).addAll(Arrays.stream(graph[i]).boxed().toList());
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<n;i++) {
            if(nodeColor[i] == -1) {
                //queue.add(i);
                //nodeColor[i] = 0;
                if(!isBipartiteDFS(i,0,nodeColor,graph)) return false;
               // if (!isBipartite(adjList, nodeColor, queue)) return false;
            }
        }

        return true;

    }

    private boolean isBipartite(ArrayList<ArrayList<Integer>> adjList,int[] nodeColor,Queue<Integer> queue){
        while(!queue.isEmpty()){
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

        return true;
    }

    private boolean isBipartiteDFS(int node,int color,int[] nodeColor,int[][]graph){
        nodeColor[node] = color;
        for(int neighbor : graph[node]){
            if(nodeColor[neighbor] == -1){
                if(!isBipartiteDFS(neighbor,1-color,nodeColor,graph)) return false;
            }else if(nodeColor[node] == nodeColor[neighbor]) return false;
        }
        return true;

    }
}
public class ISGraphBipartite {
}
