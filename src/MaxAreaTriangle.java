import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class SolutionMAT {
    public long maxArea(int[][] coords) {
        int n = coords.length;
        Map<Integer, TreeSet<Integer>> xparallel = new HashMap<>();
        Map<Integer,TreeSet<Integer>> yparallel = new HashMap<>();
        TreeSet<Integer>xCords = new TreeSet<>();
        TreeSet<Integer> yCords = new TreeSet<>();

        for(int[] cord : coords){
            int x = cord[0],y = cord[1];
            xparallel.computeIfAbsent(x,k->new TreeSet<>()).add(y);
            yparallel.computeIfAbsent(y,k->new TreeSet<>()).add(x);
            xCords.add(x);
            yCords.add(y);
        }
        long area = Long.MIN_VALUE;

        //maxArea with x base
        for(Map.Entry<Integer,TreeSet<Integer>> xmap : xparallel.entrySet()){
            int x = xmap.getKey();
            TreeSet<Integer> ySet  = xparallel.get(x);
            if(ySet.size()<2) continue;

            int minY = ySet.first();
            int maxY = ySet.last();
            int base = maxY-minY;
            int minX = xCords.first();
            int maxX = xCords.last();

            if(minX != x) area = Math.max(area,1l*Math.abs(x-minX)*base);
            if(maxX != x) area = Math.max(area,1l*Math.abs(maxX-x)*base);

        }
        for(Map.Entry<Integer,TreeSet<Integer>> ymap : yparallel.entrySet()){
            int y = ymap.getKey();
            TreeSet<Integer> xSet  = yparallel.get(y);
            if(xSet.size()<2) continue;

            int minX = xSet.first();
            int maxX = xSet.last();
            int base = maxX-minX;
            int minY = yCords.first();
            int maxY = yCords.last();

            if(minY != y) area = Math.max(area,1l*Math.abs(y-minY)*base);
            if(maxY != y) area = Math.max(area,1l*Math.abs(maxY-y)*base);

        }

        return area == Long.MIN_VALUE?-1:area;
    }
}
public class MaxAreaTriangle {
}
