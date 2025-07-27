import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionFCP {
    class Pair{
        int station;
        int cost;

        public Pair(int station, int cost) {
            this.station = station;
            this.cost = cost;
        }
    }

    class Config{
        int station;
        int stops;
        int cost;

        public Config(int station, int stops, int cost) {
            this.station = station;
            this.stops = stops;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i = 0;i<m;i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Config> queue = new LinkedList<>();

        queue.offer(new Config(src,0,0));
        int[]stationCost = new int[n];
        Arrays.fill(stationCost,(int)1e9);

        stationCost[src] = 0;
        while (!queue.isEmpty()){
            Config config = queue.poll();
            int station = config.station;
            int stops = config.stops;
            int cost = config.cost;

            if(stops>k) continue;
            for(Pair neighbour : adjList.get(station)){
                int nextStation = neighbour.station;
                int nextStationCost = neighbour.cost;
                int totalCostToNextStation = cost+nextStationCost;
                if( totalCostToNextStation< stationCost[nextStation] && stops<=k){
                    stationCost[nextStation] = totalCostToNextStation;
                    queue.add(new Config(nextStation,stops+1,totalCostToNextStation));
                }
            }
        }
        return stationCost[dst] == (int)1e9 ? -1 : stationCost[dst];
    }
}
public class CheapestFlightWithInKStops {
}
