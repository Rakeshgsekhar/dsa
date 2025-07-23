import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionSPAC {

    class PairColor{
        int node;
        int color;
        int length;

        public PairColor(int node, int color,int length) {
            this.node = node;
            this.color = color;
            this.length = length;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjB = new ArrayList<>();
        boolean[]visitedB = new boolean[n];
        boolean[]visitedR = new boolean[n];
        for(int i = 0;i<n;i++){
            adjR.add(new ArrayList<>());
            adjB.add(new ArrayList<>());
        }
        for(int[] edgeR: redEdges){
            int a = edgeR[0];
            int b = edgeR[1];
            adjR.get(a).add(b);
        }

        for(int[] edgeB: blueEdges){
            int u = edgeB[0];
            int v = edgeB[1];
            adjB.get(u).add(v);
        }
        int[]ans = new int[n];
        Arrays.fill(ans,-1);
        bfs(adjR,adjB,n,visitedB,visitedR,ans);
        return ans;
    }
    //0-red,1-blue
    private void bfs(ArrayList<ArrayList<Integer>> adjR, ArrayList<ArrayList<Integer>> adjB,int n,boolean[]visitedB,boolean[]visitedR,int[]ans){
        Queue<PairColor> queue = new LinkedList<>();
        queue.offer(new PairColor(0,-1,0));
        while(!queue.isEmpty()){
            PairColor temp = queue.poll();
            int cNode = temp.node;
            int col = temp.color;
            int length = temp.length;
           /* for(int neighbour: col == 1?adjR.get(cNode):adjB.get(cNode)){
                if(res[col == 1? 0 : col][neighbour] == 2*n){
                    res[col == 1? 0 : col][neighbour] = 1+res[col == 1? col:0][cNode];
                    queue.offer(new PairColor(neighbour,1-col));
                }
            }*/
            if(ans[cNode] == -1){
                ans[cNode] = length;
            }
            if(col!=0){
                for(int neighbour:adjB.get(cNode)){
                    if(!visitedB[neighbour]){
                        visitedB[neighbour] = true;
                        queue.offer(new PairColor(neighbour,0,length+1));
                    }
                }
            }
            if(col!=1){
                for(int neighbour:adjR.get(cNode)){
                    if(!visitedR[neighbour]){
                        visitedR[neighbour] = true;
                        queue.offer(new PairColor(neighbour,1,length+1));
                    }
                }
            }
        }
    }
}
public class SHortestPathAlternationColor {
}
