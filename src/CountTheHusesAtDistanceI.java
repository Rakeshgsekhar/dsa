import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionCTHADI {

    class PairHD{
        int house;
        int k;

        public PairHD(int house, int k) {
            this.house = house;
            this.k = k;
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            adj.get(i).add(i+1);
            adj.get(i+1).add(i);
        }
        adj.get(x).add(y);
        adj.get(y).add(x);

        int [] ans = new int[n];
        for(int i =1;i<=n;i++){
            boolean[] visited = new boolean[n+1];
            countDistance(adj,i,visited,ans);
        }
        return ans;
    }

    private void countDistance(ArrayList<ArrayList<Integer>>adj,int source,boolean[]visited,int[]ans){
        Queue<PairHD>queue = new LinkedList<>();
        queue.add(new PairHD(source,0));
        visited[source]=true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                PairHD temp = queue.poll();
                if(temp.k >= 1) ans[temp.k-1]++;
                for(int neighbour : adj.get(temp.house)){
                    if(!visited[neighbour]) {
                        visited[neighbour]=true;
                        queue.offer(new PairHD(neighbour, temp.k+1));
                    }
                }
            }

        }
    }
}
public class CountTheHusesAtDistanceI {
    public static void main(String[] args) {
        SolutionCTHADI cd = new SolutionCTHADI();
        int[]ans = cd.countOfPairs(3,1,3);
        Arrays.stream(ans).forEach(s-> System.out.println(s));
    }
}
