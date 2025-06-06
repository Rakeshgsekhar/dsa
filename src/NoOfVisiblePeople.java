import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class SolutionNVP {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Arrays.fill(res,0);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(heights[n-1]);
        for(int i = n-2;i>=0;i--){
            int count = 0;
            while(!stack.isEmpty() && heights[i]>stack.peek()){
                count++;
                stack.pop();
            }
            res[i] = count+1;
            stack.push(heights[i]);
        }
        return res;
    }
}
public class NoOfVisiblePeople {
}
