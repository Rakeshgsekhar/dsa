import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionSIGR {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] res = new int[n];
        int[]inDegree = new int[n];
        int nm = m;
        for(int i =0;i<n;i++){
            if(group[i] == -1) nm++;
        }
        ArrayList<ArrayList<Integer>>groupGraph = new ArrayList<>();
        for(int i = 0;i<nm;i++){
            groupGraph.add(new ArrayList<>());
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }


        for(int i = 0;i<n;i++){
            for(int prev : beforeItems.get(i)){
                adjList.get(prev).add(i);
                if(group[prev]!=group[i]){
                    groupGraph.get(group[prev]).add(group[i]);
                }
            }
        }

        List<Integer> sortedGroup = sortTopo(groupGraph);
        List<Integer> sortedAdj = sortTopo(adjList);

        if(sortedGroup.size() == 0 || sortedAdj.size() ==0) return new int[]{};
//        Queue<Integer> queue = new LinkedList<>();
        /*int idx = 0;
        for(int i = 0;i<m;i++){
            Queue<Integer> queue = new LinkedList<>();
            for(int item : groupGraph.get(i)) {
                if (inDegree[item] == 0) queue.offer(item);
            }
            while (!queue.isEmpty()){
                int node = queue.poll();
                res[idx++] = node;
                for(int neighbour:adjList.get(node)){
                    inDegree[neighbour]--;
                    if(inDegree[neighbour] == 0) queue.offer(neighbour);
                }
            }
        }*/

        List<List<Integer>> orderedGroups = new ArrayList<>();
        for(int i=0; i<nm; i++) orderedGroups.add(new ArrayList<>());
        for(int node : sortedAdj){
            orderedGroups.get(group[node]).add(node);
        }
        List<Integer> ans = new ArrayList<>();
        for(int grpInd : sortedGroup){
            for(int x : groupGraph.get(grpInd)) ans.add(x);
        }

        return ans.stream().mapToInt(i->i).toArray();

    }

    private List<Integer> sortTopo(ArrayList<ArrayList<Integer>> graph){
        int n = graph.size();
        int[] inDegree = new int[n];
        for(int i = 0;i<n;i++){
            for(int neighbour : graph.get(i))inDegree[neighbour]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sorted = new ArrayList<>();


        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            sorted.add(node);
            for(int neighbour: graph.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        return sorted.size()==n?sorted:new ArrayList<>();
    }
}
public class SortItemsByGroup {
    public static void main(String[] args) {
        SolutionSIGR si = new SolutionSIGR();
        List<List<Integer>> before = new ArrayList<>();
        for(int i = 0;i<8;i++){
            before.add(new ArrayList<>());
        }
        before.get(1).add(6);
        before.get(2).add(5);
        before.get(3).add(6);
        before.get(4).add(3);
        before.get(4).add(6);
        si.sortItems(8,2,new int[]{-1,-1,1,0,0,1,0,-1},before);
    }
}
