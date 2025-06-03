import Entity.Interval;

import java.util.Stack;

class SolutionPN {
    public int evalRPN(String[] tokens) {
        if(tokens.length<2) return Integer.parseInt(tokens[0]);
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if("*-+/".contains(tokens[i])){
                int second = stack.pop();
                int first = stack.pop();
                if(tokens[i].equals("*")) res = first*second;
                if(tokens[i].equals("+")) res = first+second;
                if(tokens[i].equals("-")) res = first-second;
                if(tokens[i].equals("/")) res = first/second;

                stack.push(res);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return res;
    }
}
public class PolishNotation {
    public static void main(String[] args) {
        SolutionPN pn = new SolutionPN();

        System.out.println(pn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
