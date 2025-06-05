import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class SolutionNG2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        int n = nums.length;
        int k = 2;
        int[] ans= new int[n];
        for(int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        for(int i = 0 ;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]< nums[i] && k>0){
                ans[st.pop()] =nums[i];
                k--;
            }
            if(i<n)
                st.push(i);
        }
        return ans;
    }
}
public class NextGreater2 {
    public static void main(String[] args) {
        SolutionNG2 ng2 = new SolutionNG2();
        ng2.nextGreaterElements(new int[]{2,4,0,9,6});
    }
}
