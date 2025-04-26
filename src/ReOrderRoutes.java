import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReOrderRoutes {
    public int minReorder(int n, int[][] connections) {
       boolean[] visited = new boolean[n];/*
        visited[0] = true;
        int changedEdge = 0;
        Arrays.sort(connections,(a,b)->Integer.compare(a[1],b[1]));
        for(int[] edge : connections){
            if(!visited[edge[1]]){
                System.out.println("["+edge[0]+","+edge[1]+"]");
                System.out.println(edge[1]+"->"+visited[edge[1]]);
                changedEdge++;
                visited[edge[1]] = true;
                visited[edge[0]] = true;
            }else if(visited[edge[1]]){
                visited[edge[0]] = true;
            }
        }

       // return changedEdge;

        */

        List<List<Integer>> group  = new ArrayList<>();
        for(int i = 0;i<n;i++){
            group.add(new ArrayList<>());
        }

        for(int[] c : connections){
            group.get(c[0]).add(c[1]);
            group.get(c[1]).add(-c[0]);
        }


        return dfs(group,visited,0);
    }

    public int dfs(List<List<Integer>> group, boolean[] visited, int from){
        int changedEdge = 0;
        visited[from] = true;
        for(int to : group.get(from)){
            if(!visited[Math.abs(to)]){
                changedEdge+=dfs(group,visited,Math.abs(to)) + (to>0?1:0);
            }
        }
        return changedEdge;
    }
}
