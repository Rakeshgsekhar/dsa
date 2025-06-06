import java.util.Stack;

class SolutionTPR {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        int n = height.length;
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int width = i-left-1;
                int boundaryHeight = Math.min(height[i],height[left])-height[bottom];
                water+=(boundaryHeight*width);
            }
            stack.push(i);
       }
        return water;
    }
}
public class TrapRainWater {
}
