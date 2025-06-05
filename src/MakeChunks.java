import java.util.Stack;

class SolutionMCTS {
    public int maxChunksToSorted(int[] arr) {
        /*int n = arr.length;
        int max = 0,counter=0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            max = Math.max(max,arr[i]);
            if(max==i){
                counter++;
            }

        }
        return counter;
         */
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            if(stack.isEmpty() || stack.peek()<arr[i] ){
                stack.push(arr[i]);
            }else {
                int top = -1;
                if(!stack.isEmpty()) top = stack.peek();
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                if(top != -1) stack.push(top);
            }

        }
        System.out.println(stack);
        return stack.size();
    }
}
public class MakeChunks {
    public static void main(String[] args) {
        SolutionMCTS mcts = new SolutionMCTS();
       // System.out.println(mcts.maxChunksToSorted(new int[]{4,3,2,1,0}));
       //System.out.println(mcts.maxChunksToSorted(new int[]{1,0,2,3,4}));
        //System.out.println(mcts.maxChunksToSorted(new int[]{0,1,2,3,4,5}));
        System.out.println(mcts.maxChunksToSorted(new int[]{2,3,4,1,5,0,6,7}));


    }
}
