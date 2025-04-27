import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> graph = buildGraph(equations,values);
        double[] answers = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            String divident = queries.get(i).get(0);
            String divisor  = queries.get(i).get(1);

            if(!graph.containsKey(divident) || !graph.containsKey(divisor)){
                answers[i] = -1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                double[] currAns = {-1.0};
                double temp = 1.0;
                dfs(graph,divident,divisor,visited,currAns,temp);
                answers[i] = currAns[0];
            }
        }
        return answers;
    }

    private HashMap<String,HashMap<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
        for(int i = 0;i<equations.size();i++){
            String divident = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(divident,new HashMap<>());
            graph.putIfAbsent(divisor,new HashMap<>());

            graph.get(divident).put(divisor,value);
            graph.get(divisor).put(divident,1.0/value);
        }

        return graph;
    }


    private void dfs(HashMap<String,HashMap<String,Double>> graph, String source,String destination, HashSet<String> visited
            ,double[] answer,double temp){
        if(visited.contains(source)) return;
        visited.add(source);
        if(source.equals(destination)){
            answer[0] = temp;
            return;
        }

        for(Map.Entry<String,Double> entry : graph.get(source).entrySet()){
            String key = entry.getKey();
            double val = entry.getValue();
            dfs(graph,key,destination,visited,answer,temp*val);
        }
    }
}
