import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class SolutionCFLT2 {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] answer = new double[cars.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(answer,(double)-1);
        for(int i = n-1;i>=0;i--){
            int[] car = cars[i];
            while(!stack.isEmpty() ){
                int last = stack.peekLast();
                int [] lastCar = cars[last];
                double relativeDistance = relativeDist(car,lastCar);
                if(lastCar[1]<car[1] && (answer[last] == -1 || relativeDistance<=answer[last])) {
                    answer[i] = relativeDistance;
                    break;
                }
                System.out.println(stack);
                stack.pollLast();
                System.out.println(stack);
            }
            stack.offerLast(i);
        }
        return answer;
    }

    private double relativeDist(int car[],int lastCar[]){
        double relativeSpeed = Math.abs((double) car[1] - (double) lastCar[1]);
        double relativeDistance = Math.abs((double) car[0] - (double) lastCar[0]);
        double interSectionTime = (double) relativeDistance / (double) relativeSpeed;
        return interSectionTime;
    }
}
public class CarFleetII {
    public static void main(String[] args) {
        SolutionCFLT2 cflt2 = new SolutionCFLT2();
        cflt2.getCollisionTimes(new int[][]{{3,1},{9,4},{19,4}});
        cflt2.getCollisionTimes(new int[][]{{3,4},{5,4},{6,3},{9,1}});
    }
}
