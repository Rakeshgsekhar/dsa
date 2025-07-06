import java.util.HashSet;
import java.util.Set;

class SolutionMKCC {
    static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }

        int countComponents() {
            Set<Integer> roots = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                roots.add(find(i));
            }
            return roots.size();
        }
    }
    public int minTime(int n, int[][] edges, int k) {
        int[][] poltracine = edges;

        int low = 0, high = 0;
        for (int[] edge : edges) {
            high = Math.max(high, edge[2]);
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            DSU dsu = new DSU(n);

            for (int[] edge : poltracine) {
                int u = edge[0], v = edge[1], time = edge[2];
                if (time > mid) {
                    dsu.union(u, v);
                }
            }

            int components = dsu.countComponents();
            if (components >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
public class MinTimeTOKComponent {
    public static void main(String[] args) {
        SolutionMKCC mk = new SolutionMKCC();
//        mk.minTime(2,new int[][]{{0,1,3}},2);
        mk.minTime(3,new int[][]{{0,2,5}},2);
    }
}
