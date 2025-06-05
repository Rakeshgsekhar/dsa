import java.util.*;

class SolutionNG4 {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        /*for(int i = n-1;i>=0;i--){
            while(stack.size()>2 && stack.peek()<=nums[i]){
                stack.pop();
            }
            if(stack.size()<2){
                res[i] = -1;
            }else{
                Stack<Integer> temp = new Stack<>();
                for(int id = 0;id<2;id++){
                    temp.push(stack.pop());
                }
                res[i] = temp.peek();
                for(int id = 0;id<2;id++){
                    stack.push(temp.pop());
                }
            }
            stack.push(nums[i]);
        }*/
        for(int i = n-1;i>=0;i--){
            while(stk.size()>2 && stk.peekFirst()<=nums[i]){
                stk.pollFirst();
            }
            if(stk.size()<2) res[i] = -1;
            else{
                while(stk.size()>2){
                    stk.pollLast();
                }
                res[i] = stk.peekLast();
            }
            stk.push(nums[i]);
        }

//        Map<Integer,Stack<Integer>>map = new HashMap<>();
//        for(int num = 0;num<n;num++){
//            map.put(num,new Stack<>());
//        }
//
//        for(int i = 0;i<n;i++){
//            for(int j = i+1;j<n;j++){
//                if(nums[j]>nums[i]){
//                    map.get(i).push(nums[j]);
//                }
//            }
//        }
//
//        for(int key : map.keySet()){
//            Stack<Integer> st = map.get(key);
//            if(st.isEmpty()) res[key] = -1;
//            else{
//                while(st.size()>2)
//                    st.pop();
//                res[key] = st.peek();
//            }
//        }
        return res;
    }
}
public class NextGreatFour {
    public static void main(String[] args) {
        SolutionNG4 ng4 = new SolutionNG4();
        ng4.secondGreaterElement(new int[]{2,4,0,9,6});
    }
}
