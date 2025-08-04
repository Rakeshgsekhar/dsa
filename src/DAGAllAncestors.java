import java.util.*;

class SolutionDAGAAT {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for(int [] edge:edges){
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int i = 0;i<n;i++){
            if(adjList.get(i).size()>0){
                findAncestors(adjList,result,i);
            }
        }

        return result;
    }


    private void findAncestors(ArrayList<ArrayList<Integer>>adjList,List<List<Integer>> result,int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        List<Integer>ans = new ArrayList<>();
        boolean[] visited = new boolean[result.size()];
        while(!queue.isEmpty()){
            int child = queue.poll();
            for(int ancestor: adjList.get(child)){
                if(!visited[ancestor]) {
                    visited[ancestor] = true;
                    ans.add(ancestor);
                    queue.add(ancestor);
                }
            }
        }
        Collections.sort(ans);
        result.get(node).addAll(ans);
    }
}
public class DAGAllAncestors {
    public static void main(String[] args) {
        SolutionDAGAAT dg = new SolutionDAGAAT();
        dg.getAncestors(5,new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}});
    }
}
