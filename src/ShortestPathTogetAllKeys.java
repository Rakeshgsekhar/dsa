import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SolutionSPTOK {
    class KeyMap{
        int keys;
        int row;
        int col;

        public KeyMap(int keys, int row, int col) {
            this.keys = keys;
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        /*int[]lc = new int[26];
        int lcCounter = 0;
        for(String gr:grid){
            lcCounter+=getLCCount(gr);
        }
        int[]start = getStart(grid);
        boolean[][]visited = new boolean[grid.length][grid[0].length()];
        int steps = dfs(grid,lc,lcCounter,start[0],start[1],0,visited);
        return steps==Integer.MAX_VALUE?-1:steps-1;*/
        int[]lc = new int[26];
        int lcCounter = 0;
        for(String gr:grid){
            lcCounter+=getLCCount(gr);
        }
        int[]start = getStart(grid);
        //boolean[][]visited = new boolean[grid.length][grid[0].length()];
        Set<String> visited = new HashSet<>();

        //int steps = dfs(grid,lc,lcCounter,start[0],start[1],0,visited);
        //BFS
        int m = grid.length,n=grid[0].length();
        int keyCount = 0;
        int steps = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<KeyMap> queue = new LinkedList<>();
        queue.offer(new KeyMap(0,start[0],start[1]));
        visited.add(0 + " " + start[0] + " " + start[1]);
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                KeyMap km = queue.poll();
                if(km.keys==(1<<lcCounter)-1) return steps;
                for (int[] dir : dirs) {
                    int row = km.row+dir[0];
                    int col = km.col+dir[1];
                    int keys = km.keys;
                    if(row>=0&&row<m && col>=0&&col<n){
                        char ch = grid[row].charAt(col);
                        if(ch == '#') continue;
                        if(ch>='a' && ch<='f'){
                            keys|=1<<(ch-'a');
                        }
                        if(ch>='A' && ch<='F' && ((keys >> (ch - 'A')) & 1) == 0) continue;
                        if(!visited.contains(keys + " " + row + " " + col)) {
                            visited.add(keys + " " + row + " " + col);
                            queue.offer(new KeyMap(keys,row,col));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private int getLCCount(String str){
        int cnt = 0;
        for(char ch : str.toCharArray()){
            if(Character.isLowerCase(ch))cnt++;
        }
        return cnt;
    }

    private int[] getStart(String[] grid){
        for(int i = 0;i<grid.length;i++){
            String gr = grid[i];
            if(gr.contains("@")){
                return new int[]{i,gr.indexOf("@")};
            }
        }
        return new int[]{-1,-1};
    }

    private int dfs(String[] grid,int[]lc,int lcCounter,int row,int col,int steps,boolean[][]visited){
        if(row<0 || col<0 || row>=grid.length||col>=grid[0].length() || grid[row].charAt(col) == '#') return Integer.MAX_VALUE;
        if(visited[row][col]) return Integer.MAX_VALUE;
        if(Character.isUpperCase(grid[row].charAt(col))){
            if(lc[Character.toLowerCase(grid[row].charAt(col))-'a'] != 1) return Integer.MAX_VALUE;
        }
        visited[row][col] = true;

        if(Character.isLowerCase(grid[row].charAt(col))) {
            lc[grid[row].charAt(col)-'a'] = 1;
            lcCounter--;
        }
        steps++;
        if(lcCounter==0) return steps;
        //System.out.println(steps);
        int left = dfs(grid,lc,lcCounter,row,col-1,steps,visited);
        int right =  dfs(grid,lc,lcCounter,row,col+1,steps,visited);
        int up = dfs(grid,lc,lcCounter,row-1,col,steps,visited);
        int down =  dfs(grid,lc,lcCounter,row+1,col,steps,visited);

        return Math.min(left,Math.min(right,Math.min(up,down)));

    }
}
public class ShortestPathTogetAllKeys {
    public static void main(String[] args) {
        SolutionSPTOK sp = new SolutionSPTOK();
        System.out.println(sp.shortestPathAllKeys(new String[]{"@.a..","###.#","b.A.B"}));
        System.out.println(sp.shortestPathAllKeys(new String[]{"@..aA","..B#.","....b"}));
        System.out.println(sp.shortestPathAllKeys(new String[]{"@Aa"}));
        System.out.println(sp.shortestPathAllKeys(new String[]{"@...a",".###A","b.BCc"}));
    }
}
