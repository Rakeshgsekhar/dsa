import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTPSKBFS{
    public int[] getOrder(int V,int[][] ip){
        int[] inDegree= new int[V];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] ipf:ip){
            adjList.get(ipf[0]).add(ipf[1]);
        }
        for(int i = 0;i<V;i++){
            for(int it:adjList.get(i)){
                //if(inDegree[it]==i)
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int[] order = new int[V];
        int i = 0;
        while (!queue.isEmpty()){
            int cr = queue.poll();
            order[i++] = cr;
            for(int nxt:adjList.get(cr)){
                inDegree[nxt]--;
                if(inDegree[nxt] == 0){
                    queue.offer(nxt);
                }
            }
        }
        return order;
    }
}
public class TopoSortKahnBFS {
}
