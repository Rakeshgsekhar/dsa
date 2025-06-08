import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class SolutionNSME {
    public long numberOfSubarrays(int[] nums) {
        /*long subArrays = nums.length;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == nums[i]) subArrays++;

            if(stack.s)
            stack.push(nums[i]);
        }
        return subArrays;*/
        long subArrays = 0;
        int n = nums.length;
        // Deque<Integer> stack = new ArrayDeque<>();
        Deque<int[]> stack = new ArrayDeque<>();
        /*for(int i = n-1;i>=0;i--){

            while(!stack.isEmpty() && nums[i] > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == nums[i]) subArrays++;

            stack.push(nums[i]);
            // if(stack.isEmpty() ) stack.push(nums[i]);
            if(stack.size()>2 && stack.peekLast() == nums[i]){
                subArrays++;
            }


        }*/
        for(int num : nums){
            while(!stack.isEmpty() && num > stack.peek()[0]){
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek()[0] != num)
                stack.push(new int[]{num, 0});

            subArrays += ++stack.peek()[1];
        }
        //System.out.println(stack);
        return subArrays;
    }
}
public class NoOfSubarrayMax {
    public static void main(String[] args) {
        SolutionNSME nsme = new SolutionNSME();
//        nsme.numberOfSubarrays(new int[]{5,4,3,2,3,4,5});
        nsme.numberOfSubarrays(new int[]{3,3,3});
    }
}
