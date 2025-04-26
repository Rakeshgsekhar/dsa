import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoomsAndKeys {
    Queue<Integer> queue = new LinkedList<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited = new boolean[n];


        dfs(0,rooms,visited);
        for(boolean hasVisited:visited){
            if(!hasVisited) return false;
        }
        return true;
    }

    private void bfs(int room,List<List<Integer>>rooms,boolean[] visited){
        visited[room] = true;
        queue.add(room);

        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int key:rooms.get(current)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.add(key);
                }

            }
        }
    }

    private void dfs(int room, List<List<Integer>>rooms,boolean[] visited){
        if(visited[room]) return;
        visited[room] =  true;
        for(int key : rooms.get(room)){
            dfs(key,rooms,visited);
        }
    }
}
