public class ConnectedCities {
    public int findCircleNum(int[][] isConnected) {
        /*
        nxn matrix isConnected[i][j] = 1 means connected;
        Initialize a visited array to keep track of which cities we've already explored.
        Loop through each city:
        If it hasn't been visited, start a DFS from that city.
        Each new DFS call means we’ve found a new province, so increment the count.
        In the DFS:
        Mark the current city as visited.
        Recursively visit all directly connected cities that haven’t been visited.
        */
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int city = 0;city<visited.length;++city){
            if(!visited[city]){
                provinces++;
                dfs(city,isConnected,visited);
            }
        }
        return provinces;
    }

    private void dfs(int city,int[][] isConnected,boolean[] visited){
        visited[city] = true;
        for(int neighbourCity = 0;neighbourCity<visited.length;++neighbourCity){
            if(isConnected[city][neighbourCity] == 1 && !visited[neighbourCity]){
                dfs(neighbourCity,isConnected,visited);
            }
        }

    }
}
