import java.util.Stack;

class SolutionMKF {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            stack.push(num);
        }
        int n = nums.length;
        int i = 0;
        while(i<n){
            if(stack.peek() == 0){
                int[] nk = new int[k];
                if(i+k > n) return -1;
                for(int ik = 0;ik<k;ik++){
                    nk[ik] = stack.pop()==0?1:0;
                }
                for(int ik = k-1;ik>=0;ik--){
                   // if(nk[ik] != 1)
                        stack.push(nk[ik]);
                }
                flips++;

            }
            stack.pop();
            i++;
        }
        while(!stack.isEmpty()){
            if(stack.pop() == 0) return -1;
        }
        return flips;
    }
}
public class MinKFlips {
    public static void main(String[] args) {
        SolutionMKF mkf = new SolutionMKF();
        System.out.println(mkf.minKBitFlips(new int[]{0,1,0},1));
        System.out.println(mkf.minKBitFlips(new int[]{1,1,0},2));
        System.out.println(mkf.minKBitFlips(new int[]{0,0,0,1,0,1,1,0},3));
    }
}
