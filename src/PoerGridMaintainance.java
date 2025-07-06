import java.util.*;

class SolutionGridMain {
    static class DSU {
        int[] parent;

        public DSU(int size) {
            parent = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        /*boolean grids[] = new boolean[c+1];
        List<Integer> result = new ArrayList<>();
        for(int i = 1;i<=c;i++){
            grids[i] = true;
        }
        Map<Integer, List<Integer>> connectedGrid = new HashMap<>();
        for(int [] ls : connections){
            int id = ls[0];
            int contectedGridId = ls[1];
            connectedGrid.getOrDefault(id,new ArrayList<>()).add(contectedGridId);
        }
        for(int[] query : queries){
            if(query[0] == 1 ){
                if(grids[query[1]]) result.add(query[1]);
                else{
                    List<Integer> ccg = connectedGrid.get(query[1]);
                    if(ccg.size() == 0) result.add(-1);
                    else{
                        int currentGrid = ccg.get(0);
                        for(int grid : ccg){
                            if(grids[grid] && grid<currentGrid){
                                currentGrid = grid;
                            }else break;
                        }
                        result.add(currentGrid);
                    }
                }
            }else{
                grids[query[1]] = false;
            }
        }

        int[] res = new int[result.size()];
        int idx = 0;
        for(int r : result){
            res[idx++] = r;
        }
        return res;*/
        DSU dsu = new DSU(c);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        // Component to online stations mapping (Sorted for min retrieval)
        Map<Integer, TreeSet<Integer>> gridOnlineStations = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            gridOnlineStations.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true); // Initially all are online

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0], x = query[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (online[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = gridOnlineStations.get(root);
                    if (set == null || set.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(set.first());
                    }
                }
            } else if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    TreeSet<Integer> set = gridOnlineStations.get(root);
                    if (set != null) {
                        set.remove(x);
                    }
                }
            }
        }
        int[] res = new int[result.size()];
        int idx = 0;
        for(int r : result){
            res[idx++] = r;
        }
        return res;
    }
}
public class PoerGridMaintainance {
    public static void main(String[] args) {
        SolutionGridMain gm = new SolutionGridMain();
        gm.processQueries(5,new int[][]{{1,2},{2,3},{3,4},{4,5}},new int[][]{{1,3},{2,1},{1,1},{2,2},{1,2}});
    }
}
