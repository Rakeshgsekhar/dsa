import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class SolutionCFLT {
    public int carFleet(int target, int[] position, int[] speed) {

        List<int[]> list = new ArrayList<>();
        int n = position.length;
        if(n==1) return 1;
        int count = 0;
        for(int i = 0;i<n;i++){
            list.add(new int[]{position[i],speed[i]});
        }
        list.sort((a,b)->a[0]-b[0]);

        double[] timeTaken = new double[n];
        for(int i = 0;i<n;i++){
            int[] car = list.get(i);
            double time = (target-car[0])/car[1];
            timeTaken[i] = time;
        }

        Stack<Double> stack = new Stack<>();
        for(int i =n-1;i>=0;i--){
            /*if(stack.isEmpty() || stack.peek()<timeTaken[i]){
                stack.push(timeTaken[i]);
            }else {
                double top = -1;
                if(!stack.isEmpty()) top = stack.peek();
                while (!stack.isEmpty() && stack.peek() >= timeTaken[i]) {
                    stack.pop();
                }
                if(top != -1) stack.push(top);
            }*/

            if(!stack.isEmpty() && stack.peek()>=timeTaken[i]) continue;
            stack.push(timeTaken[i]);
        }

        return stack.size();
    }
}
public class CarFleet {
    public static void main(String[] args) {
        SolutionCFLT cfleet = new SolutionCFLT();
        cfleet.carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3});
        cfleet.carFleet(100,new int[]{0,2,4},new int[]{4,2,1});
        cfleet.carFleet(10,new int[]{0,4,2},new int[]{2,1,3});
        cfleet.carFleet(10,new int[]{8,3,7,4,6,5},new int[]{4,4,4,4,4,4});
    }
}
