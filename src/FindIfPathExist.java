import java.util.*;

class SolutionIFPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       /* boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] vertices:edges){
            int u = vertices[0];
            int v = vertices[1];
            graph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }

        //return dfs(graph,visited,source,destination);
       // dfsVoid(graph,visited,source,destination);
        //return visited[destination];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            if(visited[destination]) return true;
            int node = queue.poll();
            for(int neighbour:graph.getOrDefault(node,new ArrayList<>())){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return false;*/

        int[] parent = new int[n];
        int[] rank =  new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = i;
        }

        for(int[]edge:edges){
            union(edge[0],edge[1],parent,rank);
        }

        return find(source,parent)==find(destination,parent);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph,boolean[]visited,int node,int destination){
        if(node == destination) return true;
        visited[node] = true;
        for(int neighbour: graph.getOrDefault(node,new ArrayList<>())){
            if(!visited[neighbour]){
                if(dfs(graph,visited,neighbour,destination)) return true;
            }
        }
        return false;
    }

    private void dfsVoid(Map<Integer, List<Integer>> graph,boolean[]visited,int node,int destination){
        visited[node] = true;
        for(int neighbour: graph.getOrDefault(node,new ArrayList<>())){
            if(!visited[neighbour]){
                dfsVoid(graph,visited,neighbour,destination);
            }
        }
    }

    private int find(int v,int[]parent){
        if(parent[v]!=v){
            parent[v] = find(parent[v],parent);
        }
        return parent[v];
    }


    private void union(int u,int v,int[]parent, int[]rank){
        int rootU = find(u,parent);
        int rootV = find(v,parent);

        if(rootU != rootV){
            if(rank[rootU]>rank[rootV]){
                parent[rootV] = rootU;
            }else if (rank[rootU]<rank[rootV]){
                parent[rootU] = rootV;
            }else{
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}
public class FindIfPathExist {
    public static void main(String[] args) {

    }
}
